@all
Feature: invalid logins

@negativeLogins
Scenario Outline: 
	Given user is on login page
	When user enters the username "<username>" and password "<password>"
	Then login failed and error message should be shown
	
	Examples:
	|username|password|
	|        |        |
	|abcdefgh|abcdefgh|
	|12345|4561204|
	|1|0|
	|kbc31@gmailcom|kbc3107|
	|kbc31gmail.com|123|
	|vishal+1@sevenbits.in| |
	|  |123456|