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