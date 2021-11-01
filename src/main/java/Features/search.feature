Feature: Search in Wikipedia

@SmokeTest @RegressionTest
Scenario: Search for Nalanda in Wikipedia

Given user is logged in to Wikipedia
When search string is entered
Then validate search results
