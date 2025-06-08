JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = HexGame.java Game.java Driver.java

default: classes

classes: $(CLASSES:.java=.class)
	java Driver

clean:
	$(RM) *.class
