
## The comparison of using native K8s and argo rollouts

| Capability | Native K8s                                     | Argo Rollouts |
|---|------------------------------------------------|---|
| Automated Blue/Green lifecycle | ❌ Manual                                       | ✅ Built-in |
| Traffic switch coordination | ❌ Patch Service                                | ✅ Native |
| Automatic rollback | ❌                                              | ✅ |
| Health checks & readiness gates | ⚠️ Basic                                       | ✅ Advanced |
| Manual promotion approval | ❌                                              | ✅ |
| GitOps-friendly (Argo CD) | ❌                                              | ✅ Perfect |
| Progressive delivery support | ❌ (workaround is to manually write the script) | ✅ Canary + Blue/Green |

---

##  How Argo Rollouts Does Blue/Green

1. We define **one Rollout resource**
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

if we use native K8s (two Deployments + one Service) and run kubectl apply/patch manually from the terminal, we are completely bypassing Argo CD.

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

| Aspect | With Argo CD | Manual kubectl                           |
|---|---|------------------------------------------|
| Sync from Git | ✅ Auto | ❌ We do it                               |
| Audit trail | ✅ Git commit history | ❌ (unless we track YAML in Git manually) |
| Rollback | ✅ `git revert` | ❌ Manual undo / re-apply                 |
| UI visibility | ✅ Argo CD dashboard | ❌ None                                   |
| Drift detection | ✅ | ❌                                        |


What will show up in Argo CD:

1. Argo CD will complain/fight  
   If the app was already managed by Argo CD and we kubectl patch the Service → Argo CD may show it as OutOfSync or auto-revert it on next sync (depending on the selfHeal setting).

   ✅ Solution: Either
   • Don't manage that app in Argo CD, OR

   • Disable auto-sync / mark it as external

2. No built-in safety net  
   No health checks, no promotion gate, no auto-rollback — it's all manual.

✅ Summary

Yes — using two Deployments + kubectl commands skips Argo CD entirely.

It works fine for basic Blue/Green, just be aware we lose GitOps benefits.


✅ Why Argo Rollouts is almost mandatory once we have Argo CD

• Argo CD automatically syncs the Rollout CRD

• Rollout status (Progressing / Healthy / Degraded) shows directly in the Argo CD UI

• we can see in Argo CD:

• Which version is Active (Blue)

• Which version is Preview (Green)

• Whether it is waiting for Manual Promotion

• Rollback = git revert → Argo CD sync → Automatic rollback ✅

🧱 What we need (Minimum Setup)

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


Migrating from Deployment + Service to Argo Rollouts is very smooth and does not require major structural changes.

1️⃣ The Current Structure

Deployment (myapp)
↓
Service (myapp-svc)


2️⃣ Target Blue/Green Structure (Argo Rollouts)

Rollout (myapp)
↓
Active Service   → Real Traffic
Preview Service  → New Version Verification

5️⃣ Comparison: Before vs After

| Item | Before | After |
|---|---|---|
| Deployment | 1 | ❌ Replaced by Rollout |
| Service | 1 | ✅ 2 (active / preview) |
| Upgrade Method | Change image | ✅ Change image |
| Rollback | Manual/Painful | ✅ git revert |
| Blue/Green | Manual patch | ✅ Automated |
| Argo CD Integration | ❌ | ✅ Native |

5️⃣ Comparison: With or without Istio

| Feature | Without Istio | With Istio |
|---|---|---|
| Instant traffic switch (Service selector) | ✅ | ✅ |
| Weighted canary (5%→95%) | ❌ | ✅ |
| Header / cookie based routing | ❌ | ✅ |
| Traffic mirroring | ❌ | ✅ |
| Cross-namespace blue/green | ❌ | ✅ |
| mTLS | ❌ | ✅ |

cookie/header‑based routing is the standard way to make a Canary version accessible ONLY to QA/internal users.

✅ Conclusion
Argo CD + Argo Rollouts alone is fully sufficient for in-namespace Blue/Green deployment.

With Argo CD → Strongly recommend using Argo Rollouts for Blue/Green.

No need to manually maintain two Deployments and patch Services anymore.

This solution does NOT support cross-namespace.  
If in the future we need:
• Blue in one namespace
• Green in another namespace

Then we must use:
• ✅ Istio OR

• ✅ Gateway API

