# Project 3 Team 1: QuizApp  

## Members
 - Janice Abraham
 - Krishna Chandu Akula
 - John Alden
 - Janani Anand
 - Shefali Anand
 - Suraj Atmakuri
 - Pallavi Bahl
 - Mayank Batra
 - Ankita Shivanand Bhandari
 - Pradeep Ambalam Jawaharlal

## Building

To build the student Application: `mvn package -am -pl student`  
To build the professor Application: `mvn package -am -pl professor`  

## Running

The jar files are located in `target/` in each sub-project directory after compilation.  
Student: `java -jar student/target/StudentApp.jar`  
Professor: `java -jar professor/target/ProfessorApp.jar`  

Quizzes should be placed in the `Resources/` directory in the root of the project.  