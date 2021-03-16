#CODING PARK RANGERS

##Project Setup
Clone the repo
```shell
git clone https://github.com/Klkrieg/coding-park-rangers.git
```

*If using IntelliJ be sure to open the project from the pom.xml as a project*

##Starting in on a new task
Create and Checkout a new branch
```shell
git checkout -B <branch name> 
```

##When you are ready to push your changes
```shell
git add -A
&& git commit -m <Your message as a "String">
&& git push -u origin <branch name>
```

Then you will need to go to github and create a Pull Request to merge your newly
pushed branch to the `development` branch

After making a PR you can request review from one of us or all of us!

This is **optional** but good practice for all of us to look over eachother's changes in the codebase!

##Updating your local code
First make sure you have a local `development` branch

Ex.
```shell
git checkout -B development
git pull origin development
```
To do this 