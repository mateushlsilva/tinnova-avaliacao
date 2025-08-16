JAVAC = javac
JAVA = java
MYSQL_USER = root
MYSQL_PASSWORD = root
MYSQL_DB = spring

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

ativ5-run:
	mysql -u$(MYSQL_USER) -p$(MYSQL_PASSWORD) $(MYSQL_DB) < ativ5/docker/mysql-init/DDL.sql
	cd ativ5 && mvn spring-boot:run

ativ5-docker:
	cd ativ5
	sudo docker-compose up --build

clean:
	rm -rf out