# pfe-gitops-demo helm repo

This repository hosts [Helm](https://helm.sh) charts.

## Add Helm repository

```bash
helm repo add pfe-gitops-helm-charts https://ahmedfourattouzri.github.io/pfe-gitops-demo/
helm repo update
```
## Install chart

```bash
helm upgrade --install app helm-charts/application
```
