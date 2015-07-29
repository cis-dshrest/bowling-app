Exploratory testing
===================

*Exploratory testing* is different that most of the tests out there. It cannot be automated like unit testing and has to be done manually.


##Index
-------
- [Objective](#objective)
- [Step 1](#step-1)
- [Tools](#tools)
- [TODO](#todo)

---

###Objective
------------

We're trying to create a bowling application as a way to teach exploratory testing. The goal is to let testers learn exploratory testing by finding bugs that we intentionally hid in the bowling game. Bugs can be hidden in any parts of the system from 

---
*Not creating a game*
---------------------
* The game itself. For example:
	- bug that never lets the ball go straight. (Always gutter to start with)

---

* The scoring system. For example:
	- bug in adding scores. If they get a strike, just add 1 to their overall point. Then let them find the bug in our code and change it. Increase the difficulty from there?



---


###Tools
--------
The tools that we're using are given below:
- java 8
- apache tomcat 8
- selenium 2.46.0
- spring framework 4.1.6
- mockito 
- jbehave
- MySQL (database)
- git (revision control)


---


###Step 1
---------

Following the best practices, we're using Test Driven Development(TDD) to write our program. To put simply, TDD is where you add test cases first, then write production code. This will make sure the code is testable, and simple. To come up with test cases is difficult when starting out so, we're using *Behavior Driven Development(BDD)* to come up with test cases.
	
Behavior Driven Development(BDD) uses *user stories* to come up with test cases. User stories are useful because developers, clients and Managers can all be on the same page on what features the program is supposed to have. Tools like jbehave can easily translate user stories written in plain english to be used as logic in programming languages like java directly. 


---

###TODO
---------

A checklist of what we need to accomplish:

1. **Create a servlet to host the web application**

	1.1. A rudementary web application has been implemented. It needs to be tested with jbehave (smoke/behavior testing?)  


2. **Automate the dependencies and jars**  
	
	2.1 Started researching into maven  


3. Add content to the jsp pages.  
	
	3.1 Setup login page.  

4. Complete a GET request from the help.jsp page to it's controller and return string as a message.
   To accomplish this, send page title to help.jsp on click of the + sign.



4. Add users into a database.


---


###Scoring System
-----------------


Logic:

Basically you add the number of pins knocked down.

For special cases:

a. Strike

	- 10 points awarded for knocking down all pins.
	- 
