Feature: To Test the SignUp functionality
Scenario Outline: To Test the positive flow of Sign up functionality
Given User opens the Web Application
When User navigates to Login Page
And User clicks on Sign up button
And User provides first name "<firstName>" last name "<lastName>" Birth Date "<birthDate>" gender "<gender>" mobile number "<mobileNumber>" email "<email>" country code "<countryCode>" password "<password>"
And clicks on Sign up and continue button
Then user lands to Book your slot web page "<bookYourSlot>"
And user logout to web Application
Examples:
|firstName|lastName|birthDate|gender|mobileNumber|email|countryCode|password|bookYourSlot|
|lokesh|chinta|5-AUG-1988|Male|9999999991|abcd@gmail.com|IND|abc12ABC|Book your slot| 
