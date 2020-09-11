# The Bidding System

I used Spring framework 5 and springboot 2.3.3.RELEASE Latest stable release.
The reason for choosing spring is i am more familiar and faster way of developing such rest endpoint based application.
Springboot you dont need any external application container it support embedded containers

# Run this application on any environment with prerequisite JAVA 8 and Maven installed .

mvn spring-boot:run -Dspring-boot.run.profiles=dev

or 

#From Root folder location
mvn clean package
java -jar -Dspring.profiles.active=dev target/auction-0.0.1-SNAPSHOT.jar

#enable the com.cars24.auction.config.loader component for postman testing it will create default user with user-test password- test  and auction

