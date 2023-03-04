@all
Feature: invalid login

@invalidLogin
Scenario Outline: Invalid login
	Given user is on login page
	When enter the username "<UserName>"
	And enter the password "<PassWord>"
	And press the submit button
	Then login failed and the error message will be shown.
	
	Examples:
	|UserName|PassWord|
	|invalidusername|invalidpassword|
	|kbc@gmailcom|123456|
	|kbcgmail.com|123456|
	|kbc@gmail.com|kbc@3107|