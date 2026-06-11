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


## The comparison of using native K8s and argo rollouts

| Capability | Native K8s                                            | Argo Rollouts |
|---|-------------------------------------------------------|---|
| Automated Blue/Green lifecycle | ❌ Manual                                              | ✅ Built-in |
| Traffic switch coordination | ❌ Patch Service                                       | ✅ Native |
| Automatic rollback | ❌                                                     | ✅ |
| Health checks & readiness gates | ⚠️ Basic                                              | ✅ Advanced |
| Manual promotion approval | ❌                                                     | ✅ |
| GitOps-friendly (Argo CD) | ❌                                                     | ✅ Perfect |
| Progressive delivery support | ❌ (workaround is to manually write the script | ✅ Canary + Blue/Green |

---

##  How Argo Rollouts Does Blue/Green

1. You define **one Rollout resource**
2. Argo automatically manages:
    - `active` (Blue)
    - `preview` (Green)
3. Validates Green health
4. Switches traffic (via Service)
5. Keeps old ReplicaSet for instant rollback

---

##  Minimal Blue/Green Rollout Example

```yaml
apiVersion: argoproj.io/v1alpha1
kind: Rollout
metadata:
  name: myapp
spec:
  replicas: 3
  strategy:
    blueGreen:
      activeService: myapp-active
      previewService: myapp-preview
      autoPromotionEnabled: false   # manual approval
  selector:
    matchLabels:
      app: myapp
  template:
    metadata:
      labels:
        app: myapp
    spec:
      containers:
      - name: myapp
        image: nginx:1.25
```

✅ Traffic switch = automatic
✅ Rollback = instant
✅ No downtime

---

## Industry-Standard Combinations

| Use Case | Recommended Stack |
|---|---|
| GitOps + Blue/Green | **Argo CD + Argo Rollouts** |
| Cross-NS + Canary | **Istio + Argo Rollouts** |
| Lightweight Blue/Green | **Gateway API + Argo Rollouts** |
| Minimal setup | Native Service |

---
##  Can we use native service for blue/green deployment?

if we use native K8s (two Deployments + one Service) and run kubectl apply/patch manually from your terminal, we are completely bypassing Argo CD.

Here's a clear breakdown of what that means:

• Write:

• deployment-blue.yaml

- deployment-green.yaml
  • service.yaml

• Deploy with:
kubectl apply -f blue.yaml
kubectl apply -f green.yaml
kubectl apply -f svc.yaml

• Switch traffic with:
kubectl patch svc myapp-svc -p '{"spec":{"selector":{"version":"v2"}}}'


 No Argo CD involved at all.

 What "bypassing Argo CD" means

Aspect With Argo CD Manual kubectl 

Sync from Git ✅ Auto ❌ You do it

Audit trail ✅ Git commit history ❌ (unless you track YAML in Git manually)

Rollback ✅ git revert ❌ Manual undo / re-apply

UI visibility ✅ Argo CD dashboard ❌ None

Drift detection ✅ ❌


 What will show up in Argo CD:

1. Argo CD may fight you  
   If the app was already managed by Argo CD and you kubectl patch the Service → Argo CD may show it as OutOfSync or auto-revert it on next sync (depending on your selfHeal setting).

   ✅ Solution: Either
   • Don't manage that app in Argo CD, OR

   • Disable auto-sync / mark it as external

2. No built-in safety net  
   No health checks, no promotion gate, no auto-rollback — it's all manual.

✅ Summary

Yes — using two Deployments + kubectl commands skips Argo CD entirely.

It works fine for basic Blue/Green, just be aware you lose GitOps benefits.


✅ Why Argo Rollouts is almost mandatory once you have Argo CD

• Argo CD automatically syncs the Rollout CRD

• Rollout status (Progressing / Healthy / Degraded) shows directly in the Argo CD UI

• You can see in Argo CD:

• Which version is Active (Blue)

• Which version is Preview (Green)

• Whether it is waiting for Manual Promotion

• Rollback = git revert → Argo CD sync → Automatic rollback ✅

🧱 What you need (Minimum Setup)

1️⃣ Install Argo Rollouts (One-time)

kubectl apply -f https://github.com/argoproj/argo-rollouts/releases/latest/download/install.yaml


2️⃣ Rollout (Replaces Deployment)

apiVersion: argoproj.io/v1alpha1
kind: Rollout
metadata:
name: myapp
spec:
replicas: 3
strategy:
blueGreen:
activeService: myapp-active
previewService: myapp-preview
autoPromotionEnabled: false   # <- Manual Promote button
selector:
matchLabels:
app: myapp
template:
metadata:
labels:
app: myapp
spec:
containers:
- name: myapp
image: myrepo/myapp:v1


3️⃣ Active Service (Receives real traffic)

apiVersion: v1
kind: Service
metadata:
name: myapp-active
spec:
selector:
app: myapp
ports:
- port: 80
  targetPort: 8080


4️⃣ Preview Service (Used to verify Green)

apiVersion: v1
kind: Service
metadata:
name: myapp-preview
spec:
selector:
app: myapp
ports:
- port: 80
  targetPort: 8080


Argo Rollouts automatically labels Active / Preview pods differently, and the Services match them accordingly.

🚀 Release Flow (Typical)

1. image: v1 → deploy → Active = v1
2. Change image in Git → v2
3. Argo CD syncs → Rollout creates Preview (v2)
4. Test preview (via myapp-preview service / ingress)
5. Argo CD UI → Click Promote → Traffic switches → v2 becomes Active
6. Old ReplicaSet is kept for instant rollback

🎯 Concern Argo Rollouts + Argo CD

Blue/Green ✅ Native Support

GitOps ✅ Perfect

Manual Approval ✅

Auto Rollback ✅

Cross-Namespace Blue/Green ❌ (Requires Istio / Gateway API)

Here is the translation of our previous two conversations into English.

***

### Part 1: "We have Argo CD"
**(Context: You confirmed you are using Argo CD.)**

**User:** We have Argo CD.

**Assistant:**
That makes it an excellent fit 👍  
**Having Argo CD + Argo Rollouts for Blue/Green is the standard recommended combo (GitOps + Progressive Delivery).**

---

## ✅ Why Argo Rollouts is almost mandatory once you have Argo CD

- Argo CD **automatically syncs the Rollout CRD**
- Rollout status (`Progressing` / `Healthy` / `Degraded`) **shows directly in the Argo CD UI**
- You can see in Argo CD:
    - Which version is Active (Blue)
    - Which version is Preview (Green)
    - Whether it is waiting for Manual Promotion
- Rollback = `git revert` → Argo CD sync → Automatic rollback ✅

---

## 🧱 What you need (Minimum Setup)

### 1️⃣ Install Argo Rollouts (One-time)
```bash
kubectl apply -f https://github.com/argoproj/argo-rollouts/releases/latest/download/install.yaml
```
(Or put the install YAML into Git and let Argo CD manage it.)

---

### 2️⃣ Rollout (Replaces Deployment)
```yaml
apiVersion: argoproj.io/v1alpha1
kind: Rollout
metadata:
  name: myapp
spec:
  replicas: 3
  strategy:
    blueGreen:
      activeService: myapp-active
      previewService: myapp-preview
      autoPromotionEnabled: false   # <- Manual Promote button
  selector:
    matchLabels:
      app: myapp
  template:
    metadata:
      labels:
        app: myapp
    spec:
      containers:
      - name: myapp
        image: myrepo/myapp:v1
```

---

### 3️⃣ Active Service (Receives real traffic)
```yaml
apiVersion: v1
kind: Service
metadata:
  name: myapp-active
spec:
  selector:
    app: myapp
  ports:
  - port: 80
    targetPort: 8080
```

### 4️⃣ Preview Service (Used to verify Green)
```yaml
apiVersion: v1
kind: Service
metadata:
  name: myapp-preview
spec:
  selector:
    app: myapp
  ports:
  - port: 80
    targetPort: 8080
```

> Argo Rollouts automatically labels **Active / Preview pods differently**, and the Services match them accordingly.

---

## 🚀 Release Flow (Typical)

1. `image: v1` → deploy → Active = v1
2. Change image in Git → `v2`
3. Argo CD syncs → Rollout creates **Preview (v2)**
4. Test preview (via `myapp-preview` service / ingress)
5. **Argo CD UI → Click Promote** → Traffic switches → v2 becomes Active
6. Old ReplicaSet is kept for instant rollback

---

## 🎯 Does this fit your previous requirements?

| Concern | Argo Rollouts + Argo CD |
|---|---|
| Blue/Green | ✅ Native Support |
| GitOps | ✅ Perfect |
| Manual Approval | ✅ |
| Auto Rollback | ✅ |
| Cross-Namespace Blue/Green | ❌ (Requires Istio / Gateway API) |

---

## ✅ Conclusion
> **With Argo CD → Strongly recommend using Argo Rollouts for Blue/Green.**  
> No need to manually maintain two Deployments and patch Services anymore.

Next, I can help you:
- 🔹 Convert your existing Deployment YAML to a Rollout
- 🔹 Add Ingress so Preview can be accessed separately
- 🔹 Demo Promote / Rollback inside the Argo CD UI

Just tell me if you are using **plain YAML or Helm** 😄

***

### Part 2: "Deployment + Service"
**(Context: You confirmed you currently use Deployment + Service.)**

**User:** Deployment + Service

**Assistant:**
Perfect 👍  
**Migrating from Deployment + Service to Argo Rollouts is very smooth** and does not require major structural changes.

Below, I will replace your current setup step-by-step without introducing Istio or Gateway API.

---

## 1️⃣ Your Current Structure (Assumed)

```text
Deployment (myapp)
   ↓
Service (myapp-svc)
```

---

## 2️⃣ Target Blue/Green Structure (Argo Rollouts)

```text
Rollout (myapp)
   ↓
Active Service   → Real Traffic
Preview Service  → New Version Verification
```

---

## 3️⃣ Specific YAMLs (Ready to use)

### 1️⃣ Rollout (Replaces Deployment)

```yaml
apiVersion: argoproj.io/v1alpha1
kind: Rollout
metadata:
  name: myapp
spec:
  replicas: 3
  selector:
    matchLabels:
      app: myapp
  template:
    metadata:
      labels:
        app: myapp
    spec:
      containers:
      - name: myapp
        image: nginx:1.25   # Only change this line for upgrades
        ports:
        - containerPort: 80
  strategy:
    blueGreen:
      activeService: myapp-active
      previewService: myapp-preview
      autoPromotionEnabled: false   # Manual Promote
```

✅ **Delete the old Deployment**  
✅ Future upgrades only require changing the `image` tag.

---

### 2️⃣ Active Service (The one receiving traffic)
```yaml
apiVersion: v1
kind: Service
metadata:
  name: myapp-active
spec:
  selector:
    app: myapp
  ports:
  - port: 80
    targetPort: 80
```

👉 Your **Ingress / Consumers** should now point to this Service.

---

### 3️⃣ Preview Service (For verifying Green)
```yaml
apiVersion: v1
kind: Service
metadata:
  name: myapp-preview
spec:
  selector:
    app: myapp
  ports:
  - port: 80
    targetPort: 80
```

You can:
- Expose it via a separate Ingress, or
- Simply use `kubectl port-forward svc/myapp-preview 8080:80`

---

## 4️⃣ Release Process (Your New Workflow)

### ✅ First Release
```bash
git add .
git commit -m "add rollout"
git push
```
Argo CD syncs → v1 starts (Active)

---

### ✅ Upgrade to v2
Change this line:
```yaml
image: nginx:1.26
```

Argo CD syncs →
- Creates **Preview (v2)**
- Active remains v1
- Verify preview

👉 Argo CD UI → **Promote**  
→ Traffic instantly switches to v2

---

### ✅ Rollback
```bash
git revert <commit>
git push
```
Argo CD syncs → automatically rolls back to v1 ✅

---

## 5️⃣ Comparison: Before vs After

| Item | Before | After |
|---|---|---|
| Deployment | 1 | ❌ Replaced by Rollout |
| Service | 1 | ✅ 2 (active / preview) |
| Upgrade Method | Change image | ✅ Change image |
| Rollback | Manual/Painful | ✅ git revert |
| Blue/Green | Manual patch | ✅ Automated |
| Argo CD Integration | ❌ | ✅ Native |

---

## 6️⃣ Important Note (Regarding your earlier questions)

⚠️ **This solution does NOT support cross-namespace.**  
If in the future you need:
- Blue in one namespace
- Green in another namespace

Then you must use:
- ✅ Istio **OR**
- ✅ Gateway API

But for now, this version is:
✅ **Simplest**
✅ **Most stable**
✅ **Best fit for Argo CD users**

---

I can help you next with:
- 🔹 Directly converting your existing Deployment YAML to a Rollout
- 🔹 Adding Ingress so Preview has a separate domain
- 🔹 Demonstrating Promote / Rollback operations in the Argo CD UI

Feel free to paste your current **Deployment + Service YAML** 👍

helm upgrade --install fakehost .   -n dev --create-namespace

Release "fakehost" does not exist. Installing it now.
Error: create: failed to create: namespaces "dev" not found