# blue-green-istio-platform
act -j build --secret-file .secrets

act -j build --env-file .env --secret-file .secrets
act -j deploy-green --secret-file .secrets


Install Istio CLI on Windows
Option 1 — winget (recommended)

istioctl install --set profile=demo -y

Open PowerShell as Administrator:

winget install Istio.Istio

3. Install local Kubernetes

Since you already use Rancher Desktop:

Enable:

Kubernetes
Traefik or NGINX ingress

Then verify:

kubectl get nodes

4. Install Istio locally
istioctl install --set profile=demo -y

Enable sidecar injection:

kubectl label namespace default istio-injection=enabled

5. Install ArgoCD locally
kubectl create namespace argocd
kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
   

helm upgrade --install migration-svc ./charts/helm-prod -n prod --create-namespace
kubectl label namespace prod istio-injection=enabled

Pending issue:
Option 1 — Use the same registry credentials locally

Ask DevOps for:

username
password/token

for:

docker-registry-client-credentials

Then create .secrets:

DOCKER_USERNAME=docker
DOCKER_PASSWORD=your_password_here

kubectl create secret docker-registry regcred --docker-server=docker-registry.sandstone.com.au --docker-username=docker --docker-password=immuc0nt@iner -n prod


If ArgoCD exists for this app:

Turn OFF:

Auto Sync
Self Heal
Prune

kubectl -n argocd get secret argocd-initial-admin-secret \
-o jsonpath="{.data.password}" | base64 -d

run in command line:

act -j deploy-green ^
--secret-file .secrets ^
-v %USERPROFILE%\.kube/config:/root/.kube/config ^
--env KUBECONFIG=/root/.kube/config ^
--container-options "--network host"


docker run --rm -it ^
-v C:\temp\kubeconfig.yaml:/root/.kube/config ^
-e KUBECONFIG=/root/.kube/config ^
bitnami/kubectl config view


act -j deploy-green ^
--secret-file .secrets ^
--env-file .env ^
--container-options "--add-host=host.docker.internal:host-gateway -v C:/temp/kubeconfig.yaml:/root/.kube/config" ^
--env KUBECONFIG=/root/.kube/config


act -j deploy-blue ^
--secret-file .secrets ^
--env-file .env ^
--container-options "--add-host=host.docker.internal:host-gateway -v C:/temp/kubeconfig.yaml:/root/.kube/config" ^
--env KUBECONFIG=/root/.kube/config


helm delete migration-svc -n prod

Argo Rollouts Dashboard
kubectl port-forward svc/argo-rollouts-dashboard -n argo-rollouts 3100:3100
http://localhost:3100

Argo CD
kubectl port-forward svc/argocd-server -n argocd 8080:443
https://localhost:8080

Kiali
kubectl port-forward svc/kiali -n istio-system 20001:20001
http://localhost:20001

Grafana
kubectl port-forward svc/grafana -n monitoring 3000:80
http://localhost:3000

Prometheus
kubectl port-forward svc/prometheus -n istio-system 9090:9090
http://localhost:9090

Run in background (PowerShell)

Start-Process powershell -ArgumentList "kubectl port-forward svc/argo-rollouts-dashboard -n argo-rollouts 3100:3100"

Start-Process powershell -ArgumentList "kubectl port-forward svc/argocd-server -n argocd 8080:443"

Start-Process powershell -ArgumentList "kubectl port-forward svc/kiali -n istio-system 20001:20001"

Start-Process powershell -ArgumentList "kubectl port-forward svc/grafana -n istio-system 3000:80"

Start-Process powershell -ArgumentList "kubectl port-forward svc/prometheus -n istio-system 9090:9090"


helm upgrade --install fakehost .   -n dev --create-namespace

1..500 | % { curl  -Headers @{Host="fakehost.staging.internal"} http://localhost:18080 }

kubectl argo rollouts dashboard