Exploratory testing [![Build Status](https://magnum.travis-ci.com/private-pilot/exploratory-testing.svg?token=VcNtC8P2kZyxV3pM2rAy&branch=develop)](https://magnum.travis-ci.com/private-pilot/exploratory-testing)
===================



*Exploratory testing* is different that most of the tests out there. It cannot be automated like unit testing and has to be done manually. - Testing Jenkins push again


##Index
-------
- [Objective](#objective)
- [Step 1](#step-1)
- [Tools](#tools)
- [TODO](#todo)

---

###Objective
------------

We're trying to create a bowling application as a way to teach exploratory testing. The goal is to let testers learn exploratory testing by finding bugs that we intentionally hid in the bowling game. Bugs can be hidden in any parts of the system like the

* Scoring system. For example:
	- bug in adding scores. If they get a strike, just add 1 to their overall point. Then let them find the bug in our code and change it. Increase the difficulty from there?


---


###Tools
--------
The only tools that are required to be installed for the building process are:
- java 8
- apache tomcat 8
- maven

The toolstack used for the application is shown below:
- java 8
- apache tomcat 8
- selenium 2.46.0
- spring framework 4.1.6
- hibernate 
- mockito 
- jbehave
- MySQL 5.6 (database)
- git (revision control)



---

#### Manually building
----------------------
1. Go to the root folder to build the application. Selenium tests should be
   skipped until the application is deployed. So:  


```
$ mvn install 
```

2. Copy the generated war file to tomcat's `webapp` directory.
```
$ cp target/Exploration.war {tomcat-directory}/webapps/
```

3. To setup mysql, start the mysql server and run the shell script provided
```
$ sh setupdb.sh
```

4. Run tomcat
```
$ sh {tomcat-directory}/bin/catalina.sh start
```

#### Eclipse
Import the project. Right click > maven > update project  
Then deploy using tomcat server from eclipse.

---


### BDD
---------

Following the best practices, we're using Test Driven Development(TDD) to write our program. To put simply, TDD is where you add test cases first, then write production code. This will make sure the code is testable, and simple. To come up with test cases is difficult when starting out so, we're using *Behavior Driven Development(BDD)* to come up with test cases.
	
Behavior Driven Development(BDD) uses *user stories* to come up with test cases. User stories are useful because developers, clients and Managers can all be on the same page on what features the program is supposed to have. Tools like jbehave can easily translate user stories written in plain english to be used as logic in programming languages like java directly. 


---


