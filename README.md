# QuestionBank
#In question-bank-servlet.xml, you need to replace the DB name.
<property name="jdbcUrl" "jdbc:mysql://localhost:3306/{YOUR DB name}"/>
 User and password should be replaced by your DB username and password
#The question bank file to be uploaded must have extension .properties

#And the content inside properties file should follow below format
#key is of 3 parts type-TypeNumber-questionNumber. i.e;Assignment-AssignmentNumber-questionNumber or Test-TestNumber-questionNumber
#Value is the actual question
assignment-1-1=write a program to print 10 consecutive prime numbers
test-1-1=write a program to print factorial of a number
assignment-1-2=write a program to print multiplication table
test-2-1=write a program to add 2 numbers

#To run the project first u need to add project to tomcat server and then start the server

# After the server is started go to browser and type "http://localhost:8085/Assignments/"in address bar to access the application.