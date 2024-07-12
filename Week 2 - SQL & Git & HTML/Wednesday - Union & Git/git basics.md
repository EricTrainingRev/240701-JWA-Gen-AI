# Git

## Intro 
Git is an incredibly popular version control software that helps developers collaborate on projects. Think of it as a central repository for the source code you are working on that many developers can work on simultaneously. The basic work flow for copying, modifying, and persisting the changes you make are as follows:
- Local Work
    1. git init
        - this will initialize the local repository
    2. git add
        - use a "." to add all untracked and changed content into staging
        - you can specify the files and directories of content you wan to move instead
    3. git commit -m "message here"
        - commit the changes in staging. Make sure your commit message is succinct and tells you exactly what changes are being committed
    4. rinse and repeat as necessary
    5. if you ever need to connect your local repository to a remote repository you can add a remote origin
        - git remote add origin git-url-here
    6. then you can push your changes and tell the remote repo what to call the newly created branch that matches your local branch
        - git push -u origin name_of_local_branch_to_create_in_remote
- Remote Work
    1. clone the repository you are going to be working with. If you have already done this you can skip to step 2
        - git clone repository_link_goes_here
    2. to update the repository with the most recent code use the pull command
        - git pull repository_link_goes_here
    3. to add your new work to staging use the add command
        - git add . (the period means add all new work to staging. Can also specify files and folders)
    4. to commit your work you need to use the commit command
        - git commit -m "brief description of commit" (-m means you are adding a message to the commit)
    5. when you are ready to push your new committed work to the repo you use the push command
        - git push

