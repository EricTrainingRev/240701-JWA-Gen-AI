# Creating a simple Jenkins job

## 1. check that your Build Executor is functional
If working in a free tier EC2 instance there is a good chance that your Build Executor (the tool Jenkins will use to actually run your Job) will start off disabled. to fix this:
- go to your Nodes management screen (can click on Build Executor Status to get there)
- click on configure node monitors
- Under Free Disk Space, Free Temp Space, and Response Time, check the "Don't mark agents temporarily offline" boxes. This will prevent jenkins from disabling your work nodes because of low system resources in the future
- go back to the node view and select the built in node that is marked offline (can skip the rest of this if it is not offline)
- click the bring this node back online button

## 2. Create a new job
On the main Jenkins dashboard you can either click the new item button or the create a job button, depending on whether you have any pre-existing jobs or not
- select freestyle project and give it a name before clicking ok

## 3. Build the job
Once you have a job you can start to customize the actions you want Jenkins to perform during the Job execution. This is where a lot of your experimenting will happen: you as a team will need to decide on what work you want Jenkins to automate vs what you want to trigger manually
- In the General section:
    - to save system space you can select discard old builds. If you leave the sub options blank then no previous build should be saved
    - add your github url (actual link to repo) to the project in the GitHub project section
- In the Source Code section
    - If you want Jenkins to manage cloning and moving the shell into the cloned repo you can provide the clone url (same you would use for the git clone command) and indicate what specific branch you want to clone (useful if you specifically want a dev branch)
    - If you use this option you will need to provide a username and access token (in the password section) via the Jenkins credentials manager. If you are not comfortable generating a token with limited privileges you can skip the source code management configuration and manually enter the git commands yourself in the build steps section
- In the Build Triggers section
    - leave this alone if you are manually triggering your jenkins job
    - if you are trying to set your job to trigger automatically via github check the github hook trigger gor GITScm polling option
        - you will need to let your trainer know you are setting this up because your instance security group will need to be updated to let github interact with your instance
- In the Build Environment section
    - again, to save space, you can check the delete workspace before build starts box to prevent a build up of cached information
- In the Build Steps section
    - this is where you enter the commands you want automated. An easy way to get started is to choose the Execute Shell option and enter your commands you want automated
- In the Post Build Actions section
    - there are some built in options that allow you to take the products of your Job build and publish them, whether that be via email, API call, etc. You will have to do some extra configurations to make many actions in this section work correctly