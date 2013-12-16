# Course setup overview

These instructions guide Windows users through installing all necessary course software and setting up a course repository for submitting work. 

Mac/Linux users, please see Setup-Mac.md or Setup-Linux.md.

You need a good internet connection and an hour or two to complete these instructions. All errors and omissions are mine. Feel free to share your improvements to these instructions (pull requests are welcome).

Overview of steps:

1. Install a package manager
2. Install packages
3. Configure Git
4. Create an account on a project host
5. Setup SSH keys
6. Create your local repository
7. Create your remote repository
8. Push to your remote repository
9. Share your repository with me and watch mine
10. Practice work submission

# Install a package manager

You need to download [Chocolatey](http://chocolatey.org/) by copying the following command, opening the Command Prompt (cmd.exe), and pasting by right clicking and selecting Paste (please do not try to type this in manually, I guarantee you will f**k it up).

    @powershell -NoProfile -ExecutionPolicy unrestricted -Command "iex ((new-object net.webclient).DownloadString('https://chocolatey.org/install.ps1'))" && SET PATH=%PATH%;%systemdrive%\chocolatey\bin

If you are using Windows 7 or earlier, you will also need to install [PowerShell 3](http://www.microsoft.com/en-us/download/details.aspx?id=34595) before you run Chocolatey, as Chocolatey depends on it.

# Install packages

In this course, you are welcome to choose among Java, C++ or Python for your projects. I intend to use each of these languages at least once in class, so you might as well install these packages now.

* Git for team collaboration and work submission.
* Git Extensions, a front-end for Git.
* Notepad++, a decent text editor.
* CMake, a Makefile generator for C++ projects.
* KDiff3, a Diff/Merge tool.
* Python, a decent programming language.
* Pip, a python package installer.
* Gradle, a nice Java build tool / package installer.

Use Chocolatey to install software.

1. Open cmd.exe and copy/paste the following:

    cinst Sudo

2. Close the command prompt, and reopen it. Copy/paste the following:

    sudo cinst git gitextensions cmake kdiff3 python pip gradle nuget notepadplusplus

3. If you are a CS major, you probably have Java and the JDK installed already. If not:

    sudo cinst javaruntime java.jdk

# Configure Git

1. Open Git Extensions. You will see a Checklist of issues the first time you run this program. (If you accidentally closed it out already, go to Tools -> Settings).
2. Unless you've already done this before, your user name and email address are not configured. Click Repair.
3. Enter your full name (e.g., John Smith) for your user name, and your Wentworth email as your User email. Click OK.

# Create an account on a project host

I don't use Blackboard or email for work submission. Instead, use git to push work to a remote repository on a project host.

1. Pick a project host. Bitbucket is easier to set up, whereas Github has a slicker interface. 
2. Create an account on either [Bitbucket](http://bitbucket.org) or [Github](http://github.com) using your *@wit.edu* email address and real name. You don't need to create accounts on both services.
3. [Complete this form](https://docs.google.com/forms/d/1lsSvVQVRlnIKl8qp5sSWwy-BgxyqnYGEvDzGLoQXV28/viewform) so that I know where to look for your work.
4. Set up a [Gravatar](http://en.gravatar.com/) with your *@wit.edu* email address if you want to help the professor associate your user name with your face.

# Setup SSH keys

You don't want to type in your password every time you submit work, do you? Of course not. You will need to generate an SSH public/private kepair ([what's that?](https://www.youtube.com/watch?v=3QnD2c4Xovk)), and share it with your project host.

## Generate your SSH public/private keypair

1. Open Git GUI (this is a separate program from Git Extensions).
2. Click Help -> Show SSH Key.
3. Click Generate Key if you haven't already done this before.
4. Press enter when prompted for a passphrase.
5. Click Copy to Clipboard.

## Share the public SSH key with the project host

1. [Github users go here](https://github.com/settings/ssh); Bitbucket users: navigate to your user (in the upper right corner) -> Manage account -> SSH keys.
2. The interface for Bitbucket and Github are pretty much the same at this point.
3. Click Add key, and then paste in your public SSH key into the key field. For the title, use a nickname for your machine (e.g., laptop).

# Create your local repository

You now need to create a Git repository on your machine to save (commit) your work and get material from me.

Open Git Extensions (it should already be open).

1. Click Create new repository (under Common Actions or Start).
2. Click Browse.
3. In the file selector, click your name, click Make New Folder and type in `comp310`. Click OK.
4. Leave the repository type alone, it should be Personal Repository as selected by default. Click Initialize.
5. Click Repository -> Remote repositories...
6. In the dialog box, for name, enter: `professor`; for URL, enter: `https://github.com/lawrancej/comp310.git`. Click Save changes. Click Yes, and follow any prompts. Close the Remote repositories dialog box.
7. Click the Down arrow button to pull from the professor. You don't need to play with any of the options, just click Pull.

# Create your remote repository

Now create a place to submit your work, called a remote repository. **You need to ensure that your remote repository is private, otherwise I cannot post feedback to you for legal reasons (FERPA).** 

## Bitbucket users

1. [Create a new, empty private repository](https://bitbucket.org/repo/create), called **comp310**. Don't play with the other settings, just go with the defaults (DO NOT initialize the repository with a README).

2. Once created, you will see your new remote repository. Bookmark this page in your browser, so you can get back to it later.

## Github users

1. [Request private repositories for educational purposes as a student](http://github.com/edu)Github's turn around time is short; however, the start of a semester is the busiest time for this, and an actual person reviews all requests from students.

2. [Create a new, empty public repository](https://github.com/new), called **comp310**. Don't play around with the other settings, just go with the defaults (DO NOT initialize the repository with a README).

3. Once created, you will see your new remote repository. Bookmark this page in your browser, so you can get back to it later.

4.  When Github confirms that you are a student, make the repository you created private by clicking on the wrench and screwdriver icon (it's **Settings**, not **Account settings**) and scroll down to the **Danger Zone** and click **Make private**. 

# Push to your remote repository

So far, you have created a remote repository, but haven't submitted (pushed) anything to it yet.

## Bitbucket users

Click I'm starting from scratch. Select the SSH URL appearing after `git remote add origin` (it should look something like: `ssh://git@bitbucket.org/yourUserNameHere/comp310.git`; not: `https://bitbucket.org/yourUserNameHere/comp310.git`). Please copy the SSH URL only, not the entire line.

## Github users

Under Quick Setup, select and copy the SSH URL to the clipboard (It should look something like: `git@github.com:yourUserNameHere/comp310.git`, not: `https://github.com/lawrancej/comp310.git`).

## All users

1. In Git Extensions, click Repository -> Remote repositories...
2. Click New. Under Details, enter `origin` for the name, and paste the URL you copied earlier from Bitbucket or Github.
3. Click Save Changes and then click Close.
4. Click the Up arrow (Push). Click Push.
5. Reload your Bitbucket or Github repository page. If all went well, you will see **COMP310: Data Structures**. 

# Share your repository with me and watch mine

Right now, nobody but you can see your remote repository; you need to add me as a collaborator so that I can see the work you submit. Also, I will make updates frequently during the semester, and I won't email you when I make changes, so you'll want to watch my repository to receive change notifications.

## Bitbucket users

1. Click the gear icon to administrate your repository.
2. Select **Access management**.
3. Under Users, enter `lawrancej`, and click Add.
4. [Go to my repository](https://bitbucket.org/lawrancej/comp310), and click the eye icon to watch it for changes.

## Github users

1. Click the wrench and screwdriver icon on the right side of the page (If you hover your mouse over it, it's **Settings**, not **Account settings**).
2. Click **Collaborators**
3. Enter `lawrancej`, and click Add.
4. [Go to my repository](https://github.com/lawrancej/comp310), and click the eye icon to watch it for changes.

Now we can see each other's stuff.

# Practice work submission

Submit work to wrap this up.

1. Open Git Extensions (it should already be open).
2. Create a new text document in your git repository. To do this, click Repository -> File Explorer. Right click in the folder, select New -> Text Document. Double click to open it in a text editor.
3. Enter your name and something interesting about yourself. Save it and close.
4. Go back to Git Extensions, and click Commit.
5. Select the New Text Document.txt (or whatever you renamed it to out of habit), and click the single down arrow Stage button.
6. Type in a commit message (e.g., My first commit), and click Commit & push.
7. Just say Yes to anything it asks about.
8. At some point you will see a push dialog box. The default remote is `origin`, and you should push to `origin`, not to `professor`. Click Push.
8. If all went well, you will see the commit on your project when you reload the page.

# References

* [Atlassian Git Tutorials](http://www.atlassian.com/git/)
* [Pro Git](http://git-scm.com/book)
* [Git Reference](http://gitref.org/)
* [Git Immersion](http://gitimmersion.com/)
* [Try Git](http://try.github.com/)
* [Git Branching](http://pcottle.github.io/learnGitBranching/?demo)
