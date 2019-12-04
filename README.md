# HomeSuppliesManagementSystem

**1. Manifest for the projects, all sub-modules and libraries**
Front-end development includes the use of following technologies:
  HyperText Markup Language
  Cascading Style Sheets
  ANGULAR JS
  
The required dependencies for the project are as follows:

  implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok:1.18.10'
	annotationProcessor 'org.projectlombok:lombok:1.18.10'
	compile group: 'org.slf4j', name: 'slf4j-api', version: '1.7.25'
	compile("org.webjars:angularjs:1.6.9")
	compile('org.webjars:bootstrap:3.3.7-1')
	compile group: 'com.fasterxml.jackson.core', name: 'jackson-core', version: '2.10.1'

**2. Descriptions of the projects, all sub-modules and libraries**

**3. Instructions to install, configure, and run the programs:** </br>
  Things that you need to download:</br>
    1. JDK https://www.oracle.com/technetwork/java/javase/downloads/index.html </br>
    2. MySQL Communty server https://dev.mysql.com/downloads/mysql/ </br>
    3. MySQL workbench https://dev.mysql.com/downloads/workbench/ </br>
    4. Intilij community https://www.jetbrains.com/idea/download/ </br>
 </br>
 Steps: 
  1. First download and install jdk </br>
  2. Download and install MySQL community server. While installing use the username: root and pass: root123456 (if You use 
  any other username and password you have to change it in application.properties file) </br>
  3. Download and install MySQL workbench. </br>
  4. Download and configure Gradle. Run the command: "gradle wrapper"
  4. Connect to the database using mysql workbench and create a database called "demo_db" </br>
  5. Fetch the code from github. </br>
  6. Open MySQL workbench. Make sure MySQL workbench is configured to run Update and Delete command. In order to do so, go to MySQL workbench -> preferences -> SQL Editor -> Untick Safe Update. Now MySQL workbench is ready to execute data.sql. Execute data.sql. This will populate data.
  7. For opening the project in intilij , install it and run intilij. Then go to File>open and browse to the project folder downloaded
  from github and select build.gradle file. It will open the project. </br>
  8. For running the project, open terminal or cmd and go to the project root folder. </br>
  9. run "./gradlew bootrun" command. It will start the server at 9080 port. </br>
  10. For building the jar file run "./gradlew clean build". It will build the jar file.</br>
  11. Start intilij , go to Settings>Plugin. Then search for "lombok" plugin and add it.
  

Developed features:
1. Enter Amount for Split
2. Settle the balance
3. Populate Shopping List
4. Create or Edit Shopping List
 


**4. All Known Bugs**
