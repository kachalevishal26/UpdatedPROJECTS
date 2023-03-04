Feature: Login feature

Scenario: Login page title
	Given user is on login page
	When user gets the title of the page
	Then page title should be "Login - My Store"

Scenario: Forgot password link
	Given user is on login page
	Then forgot your password link should be displayed

Scenario: Login with correct credentials
	Given user is on login page
	When user enters username "vishal+1@sevenbits.in"
	And user enters password "123456"
	And user clicks on Login button
	When user gets the title of the page
	And page title should be "My account - My Store"