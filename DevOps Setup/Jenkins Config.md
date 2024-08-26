# Jenkins details

## Github access token
**NOTE**: I don't recommend you create an access token for your project jenkins instance, just including these notes so you know how you can give your Jenkins permissions to interact with your repositories
- go to developer settings
- go to personal access tokens
- create a classic token
    - careful with this, gives access to your account based on permissions you set
- save the credentials using Jenkins username and password credentials manager

## Github WebHooks
```bash
https://api.github.com/meta
```
- get the "hooks" ip addresses
- add them to your security groups
    - port for jenkins
    - https & http requests