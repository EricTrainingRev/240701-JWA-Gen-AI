# Git Help

### Making a new repository on Github

1. on the home screen click the green "new" button

2. give your repository a name, and add a description if you want

3. Add a readme and gitignore file, the git ignore file will change depending on the programming language you are working with (ignore python if working with python, java if working with java, etc)

4. create the repository

5. You now have a repository on Github ready for use!

### Clone a Github repository to your local computer
1. In your repository click the green code button

2. Copy the HTTPS link

3. Open git bash in the location where you want to copy the github repo (it will copy into a folder)

4. use the clone command to clone the repo
```cli
git clone HTTP-link
```

5. You now have a local version of the github repo!

### Making a new git repository locally
1. make a folder for the repository
```cli
mkdir folder-name
```
2. change your active directory to the new folder you created
```cli
cd folder-name
```
3. initialize the new repository
```cli
git init
```
4. You now have a working git repository on your local system.

### pushing locally made repository to github repo
(this requires you to have made a repository in Github)
1. Make sure your local repo is up to date

2. add an origin (remote repo) to your local repo using the HTTPS link from your github repo
```cli
git remote add origin HTTPS-Link
```
3. you can use the command git remote -v to check that your local repo is correctly connected to the remote repo
```cli
git remote -v
```
4. pull from the remote repo to make sure the two repos are aligned in content (add the allow-unrelated-histories or the merge will fail). You may need to make a commit message when this happens
```cli
git pull origin master --allow-unrelated-histories
```
5. You will need to set the remote repo as the upstream branch when you are ready to push your changes
```cli
git push --set-upstream origin master
```
6. now you can make a merge request in your github repo!

### Adding and committing files to your local repository
1. move the files you wish to track into staging. Use * if you want to add everything
```cli
git add files, go, here
```
2. commit the changes you made so they are persisted
```cli
git commit -m "message should give a brief explanation of what you added to the repository"
```
3. Your branch is now up to date and (if it is not the main branch) it can be merged

### merging 
1. checkout the branch you want to merge into
```cli
git checkout branch-to-merge-into
```
2. use the merge command to merge the contents of a second branch into your current branch
```cli
git merge branch-to-merge-into-current-branch
```
3. the contents should now be merged into your current branch

### reverting to old files
1. get the records of previous commits. Adding --oneline to the end makes it easier to work with
```cli
git log --oneline
```
2. use the checkout command to get a version of an older file and replace it in the current branch
```cli
git checkout id-for-old-commit file_name.extension
```
3. the old version of the file is now current, and it is automatically placed into staging. You can commit it or work on it anew

### Pushing changes you've made locally to your github repo
1. It is good practice to first pull from the repo you are going to push to. This helps prevent merge errors
```cli
git pull origin branch-you-are-going-to-push-to
```

2. make sure you add and commit your changes. Deal with any merge conflicts

3. once you are ready, push the content
```
git push
```