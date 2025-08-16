JAVAC = javac
JAVA = java

.PHONY: ativ1 ativ2 ativ3 ativ4 ativ5 clean

ativ1:
	$(JAVAC) ativ1/eleicao/src/*.java -d out
	$(JAVA) -cp out App

ativ2:
	$(JAVAC) ativ2/bubblesort/src/App.java -d out
	$(JAVA) -cp out App

ativ3:
	$(JAVAC) ativ3/fatorial/src/App.java -d out
	$(JAVA) -cp out App

ativ4:
	$(JAVAC) ativ4/multiplos/src/App.java -d out
	$(JAVA) -cp out App

ativ5:
	cd ativ5 && mvn spring-boot:run

clean:
	rm -rf out