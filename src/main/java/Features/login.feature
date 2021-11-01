Feature: Login to Wikipedia

@SmokeTest
Scenario: Login to Wikipedia

Given Wikipedia application is opened
When user entered credentials
Then login button is clicked
Then validation should be done



