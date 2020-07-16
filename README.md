# Dependencies Finder


This program accepts information contained in a file about
the class dependencies in a Java program and creates a directed graph from that information. From the directed
graph, it produces two different kinds of displays of those dependency relationships.

## Sample
### Input
```$xslt
ClassA      ClassC ClassE ClassJ
ClassB      ClassD ClassG
ClassC      ClassA
ClassE      ClassB ClassF ClassH
ClassJ      ClassB
ClassI      ClassC
```
*The first name of each line of the file is a Java class upon which other classes depend. The remaining names are
 the classes that depend upon the first class on that line. The first line of the above file, for example, indicates
 that ClassA has three classes that depend upon it, ClassC , ClassE and ClassJ .*

### Output

***Format A:***
```$xslt
ClassA
	ClassC *
	ClassE
		ClassB
			ClassD
			ClassG
		ClassF
		ClassH
	ClassJ
		ClassB	
			ClassD
			ClassG
```
*The asterisk after ClassC results from the fact that ClassC depends upon ClassA and ClassC depends upon
 ClassA .*

***Format B:***
```$xslt
( ClassA ( ClassC * ClassE ( ClassB ( ClassD ClassG ) ClassF ClassH ) ClassJ (
ClassB ( ClassD ClassG ))))
```
