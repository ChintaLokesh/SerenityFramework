Feature: To Test the Login functionality
Scenario Outline: To Test the positive flow of Login functionality
Given User opens the Web Application
When User navigates to Login Page
And User clicks on Login Using Password Link
Then user login to Application using email "<email>" and password "<password>"
And user lands to Book your slot web page "<bookYourSlot>"
And user logout to web Application
Examples:
|email|password|bookYourSlot|
|abcd@gmail.com|abc12ABC|Book your slot| 