Feature: login features

Scenario: page title
	Given user is on the login page
	When user gets the page title
	Then the page title should be "Account Login"
	
Scenario: valid login
	Given user is on the login page
	When user enters the username "vishal+1@sevenbits.in"
	And user enters the password "Vishal@26"
	And user clicks the submit button
	And user gets the page title
	Then the page title should be "My Account"