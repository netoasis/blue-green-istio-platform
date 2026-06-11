Start-Process powershell -ArgumentList "kubectl port-forward svc/argocd-server -n argocd 8080:443"
Start-Process powershell -ArgumentList "kubectl port-forward svc/grafana -n monitoring 3000:80"
Start-Process powershell -ArgumentList "kubectl port-forward svc/fakehost-gateway-nginx -n dev 18080:80"
