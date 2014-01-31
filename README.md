COMP310: Data Structures
========================

This course will cover all major [data structures](http://www.cs.usfca.edu/~galles/visualization/Algorithms.html), their [space/time complexity](http://bigocheatsheet.com/), and their [relevance to programming](http://cstheory.stackexchange.com/questions/19759/core-algorithms-deployed/19773#19773). If you're looking for a textbook, check out [Open Data Structures](http://opendatastructures.org/ods-java/).

Agendas
-------

* [January 8](SyllabusCOMP310Lawrance.docx) Introducing ourselves, [Birthday paradox](http://en.wikipedia.org/wiki/Birthday_problem) 
* [January 9](Setup.md) Set up course software and git repositories.
* [January 10](agendas/01-10.md) Add Gradle to your PATH, Abstract Data Types (ADTs), Introducing big O notation.
* [January 13](agendas/01-13.md) Load the workspace into Eclipse, More data structure examples.
* [January 15](agendas/01-15.md) Big O and trees.
* [January 16](agendas/01-16.md) Lab 1.
* [January 30](agendas/01-30.md) Lab 2.
* [January 31](agendas/01-31.md) Binary search trees, and balancing them (AVL trees).

Common Eclipse errors (and their solutions)
-------------------------------------------

### This may solve most problems.

Try opening up Git Extensions, go to Git Bash, and then do:

	cd workspace/Examples
	gradle eclipse

Then, click on the project and hit F5 (or right click and Refresh).

### Unsupported major.minor version 51.0 Error

Click on the project, then do:

    Project -> Properties -> Java Compiler

Click Enable project specific settings, click OK and try again.
