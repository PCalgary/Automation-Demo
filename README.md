"# Automation-Demo" 

This project is developed to execute Login Test Scenario using Selenium/Java and Written i BDD with Cucumber/Gherkin

STEPS TO RUN THIS PROJECT:
1. Clone the project from Github to your local
2. Run "mvn clean install"
3. Update the Test Tag in "src\main\java\MyRunner\TestRunner.java" to "@SmokeTest" or "@RegressionTest"
4. Run "mvn test"
5. Find the reports here: "target\cucumber-reports\cucumber-pretty\index.html"