# CICD Pipeline
When doing DevOps there are various practices for implementing the methodology:
- **Continuous Integration**
    - taking work done locally an pushing it to a remote repository
    - remote repo almost always has a form of version control software
    - local source code is almost always managed by a form of version control software
- **Continuous Delivery**
    - this is the practice of automating one or more steps between pushing your code to a shared remote repository and getting that code to the production environment
        - this can be one step, it can be most of the steps, but Continuous Delivery is NOT automating all of the DevOps steps
- **Continuous Deployment**
    - this is the full automation of your DevOps pipeline
    - all steps after the intial push to the remote repository are handled by automated software: all you have to do as the DevOps engineer is read whatever report is generated after the DevOps process (often called a Job) is finished to know whether it succeeded, and therefore you don't have any further work, or it failed and there is something that needs to be fixed