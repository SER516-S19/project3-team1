# Project 3 Team 1: QuizApp  

## Members
 - Janice Abraham
 - Krishna Chandu Akula
 - John Alden(Scrum master)
 - Janani Anand
 - Shefali Anand
 - Suraj Atmakuri
 - Pallavi Bahl
 - Mayank Batra
 - Ankita Shivanand Bhandari
 - Pradeep Ambalam Jawaharlal(Product Owner)

## Building

To build the student Application:
1. Navigate to the project root folder(project3-team1) in terminal
2. Execute the command `mvn package -am -pl student` 


To build the professor Application: 
1. Navigate to the project root folder(project3-team1) in terminal
2. Execute the command `mvn package -am -pl professor` 
          

## Running

The jar files are located in `target/` in each sub-project directory after compilation.
To launch the respective applications, Go to the project root folder in terminal and execute the following commands-

Student: `java -jar student/target/StudentApp.jar`  
Professor: `java -jar professor/target/ProfessorApp.jar`  

Quizzes should be placed in the `Resources/` directory in the root of the project.  
