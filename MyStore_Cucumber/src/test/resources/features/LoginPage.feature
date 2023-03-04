@all 
Feature: login page features 

@pagetitle 
Scenario: page title 
	Given user is on the login page 
	When user gets the page title 
	Then page title should be "Login - My Store" 
	
@forgotpassword 
Scenario: forgot password link 
	Given user is on the login page 
	Then forgot password link should be visible 
	
@validlogin 
Scenario: login with valid credentials 
	Given user is on the login page 
	When user enters the username "vishal+1@sevenbits.in" 
	And user enters the password "123456" 
	And user clicks the submit button 
	And user gets the page title 
	Then page title should be "My account - My Store" 
	
	#Scenario Outline: login with invalid credentials
	#	Given user is on the login page
	#	When user enters the username "<UserName>"
	#	And user enters the password "<PassWord>"
	#	And user clicks the submit button
	#	Then login will be failed and error msg will be shown
	#	
	#	Examples:
	#	|UserName|PassWord|
	#	|            |        |
	#	|kbc@gmailcom|invalidPassword|
	#	|kbcgmail.com|kbc3107|
	#	|kbc26@gmail.com|kbc3107|