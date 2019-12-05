# HomeSuppliesManagementSystem

**1. Manifest for the projects, all sub-modules and libraries** </br>

Manifest-Version: 1.0 </br>
Created-By : SSDI Group-2 </br>
Package-Name : demo </br>
Main-Class: DemoApplication.java </br>

 Front-end development includes the use of following technologies: </br>
  1. HyperText Markup Language </br>
  2. Cascading Style Sheets </br>
  3. ANGULAR JS </br>
  
 The required dependencies for the project are as follows: </br>

implementation 'org.springframework.boot:spring-boot-starter-data-jpa' </br>
	implementation 'org.springframework.boot:spring-boot-starter-web' </br>
	compileOnly 'org.projectlombok:lombok:1.18.10' </br>
	annotationProcessor 'org.projectlombok:lombok:1.18.10' </br>
	compile group: 'org.slf4j', name: 'slf4j-api', version: '1.7.25' </br>
	compile("org.webjars:angularjs:1.6.9") </br>
	compile('org.webjars:bootstrap:3.3.7-1') </br>
	compile group: 'com.fasterxml.jackson.core', name: 'jackson-core', version: '2.10.1' </br>
  	

**2. Descriptions of the projects, all sub-modules and libraries**

**API documentation:**
</br>Endpoint: localhost:9080//user?userName=johndoe [GET]
</br>1. Endpoint: localhost:9080//addItem [POST]
</br>Samples request-body: 
</br>{
</br>	"userName" : "johndoe",
</br>	"itemDescription" : "cake"
</br>}
</br>2. Endpoint: localhost:9080//addItem [POST]
</br>Samples request-body: 
</br>{
</br>	"userName" : "johndoe",
</br>	"itemDescription" : "cake"
</br>}

</br>3. Endpoint: localhost:9080//updateItem [POST]
</br>Samples request-body:
</br>{
</br>	"userName" : "johndoe",
</br>	"oldItemDescription" : "cake",
</br>	"newItemDescription" : "frosting"
</br>}
</br>4. Endpoint: localhost:9080//getItems?userName=johndoe [GET]

</br>5. Endpoint: localhost:9080//deleteItem [POST]
</br>Samples request-body:
</br>{
</br>	"userName" : "johndoe",
</br>	"itemDescription" : " frosting "
</br>}

</br>6. Endpoint: localhost:9080/api/enterAmount [POST]
</br>Samples request-body:
</br>{"amount": "10.0",
</br>"groupId" : "1",
</br>"paidBy" : "1"}

</br>7. Endpoint: localhost:9080/api/settleAmount [POST]
</br>Samples request-body:
</br>{"groupId" : 1}

</br>8. Endpoint: localhost:9080/api/getUnsettledTransactions/{groupId} [GET]


**Description of used libraries:** </br>
lombok:1.18.10: It automatically generates getter, setters.
angularjs:1.6.9 and bootstrap:3.3.7-1: This libraries help to develop frontend faster and easier
jackson: This helps to map java objects to JSON and vice versa.
slf4j: This library helps to do the loggings. 
spring-boot-starter-data-jpa and spring-boot-starter-web: These libraries give functionality of spring-boot.


**3. Instructions to install, configure, and run the programs:** </br>
  Things that you need to download:</br>
    1. JDK https://www.oracle.com/technetwork/java/javase/downloads/index.html </br>
    2. MySQL Communty server https://dev.mysql.com/downloads/mysql/ </br>
    3. MySQL workbench https://dev.mysql.com/downloads/workbench/ </br>
    4. Intilij community https://www.jetbrains.com/idea/download/ </br>
 </br>
 **Steps:** 
  1. First download and install jdk 13</br>
  2. Download and install MySQL community server. While installing use the username: root and pass: root123456 (if You use 
  any other username and password you have to change it in application.properties file) </br>
  3. Download and install MySQL workbench. </br>
  4. Download and configure Gradle. Run the command: "gradle wrapper"
  4. Connect to the database using mysql workbench and create a database called "demo_db" </br>
  5. Fetch the code from github. </br>
  6. For opening the project in intilij , install it and run intilij. Then go to File>open and browse to the project folder downloaded
  from github and select build.gradle file. It will open the project. </br>
  7. Start intilij , go to Settings>Plugin. Then search for "lombok" plugin and add it.
  8. For running the project, open terminal or cmd and go to the project root folder. </br>
  9. run "./gradlew bootrun" command. It will start the server at 9080 port. </br>
  10. Open MySQL workbench. Make sure MySQL workbench is configured to run Update and Delete command. In order to do so, go to MySQL workbench -> preferences -> SQL Editor -> Untick Safe Update. Now MySQL workbench is ready to execute data.sql. Execute data.sql. This will populate data.
  11. For building the jar file run "./gradlew clean build". It will build the jar file.</br>
  12. The Jar file would be in build/lib folder.
 
 **Artifact exection and use instructions:**
 1. Prerequisit: Create the Schema as mentioned earlier. 
 2. Launch terminal and run command: java -jar demo-0.0.1-SNAPSHOT.jar (you will find the jar file in project home directory and in build/lib folder)
 3. Open MySQL workbench. Make sure MySQL workbench is configured to run Update and Delete command. In order to do so, go to MySQL workbench -> preferences -> SQL Editor -> Untick Safe Update. Now MySQL workbench is ready to execute data.sql. Execute data.sql. This will populate data.
 4. Launch browser and hit http://localhost:9080/Login/login.html
 5. username: aditiro and password: aditiro

**Developed features:**
1. Enter Amount for Split
2. Settle the balance
3. Populate Shopping List
4. Create or Edit Shopping List
 
**4. All Known Bugs**
