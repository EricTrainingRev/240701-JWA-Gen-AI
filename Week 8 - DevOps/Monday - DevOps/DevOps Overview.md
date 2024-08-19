# DevOps Overview
Historically you would have at least two teams working on a project:
- Development Team
    - Testers are grouped in here
- Operations Team

It used to be that the Dev team would build an application, and then the Operations team would deploy and monitor the application. In modern times, these goals/actions have been combined into a single methodology: DevOps

# DevOps Methodology
1. **Source Code Control**
    - This involves working on code, committing the work with your preferred version control software, then pushing your work to a remote repository
    - often **unit testing** is performed before pushing any work, but is not necessary due to next step
2. **Building and Testing Automation**
    - instead of manually executing your automated tests (think clicking a run test button in your IDE) you let your DevOps tools execute your tests when you push code into your remote repository (automating the process of executing your automated tests)
    - **unit and integration** tests can easily be run at this stage
3. **Deploying to Staging**
    - move the product to an environment that is production-like in order to perform **System tests**
        - this can be functional & non-functional
4. **Acceptance Testing**
    - typically same environment that your System tests are performed
    - typically non UAT **Acceptance Testing** is performed here
        - Operational Acceptance Testing
        - Regulatory Acceptance Testing
5. **Deployment of Build**
    - actually deploying the product