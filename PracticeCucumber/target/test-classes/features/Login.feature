@all
Feature: verify the login

@validLogin
Scenario: login with valid credentials
	Given user navigates to the site
	And user click on the Sign In button

	When user enters the username "vishal+1@sevenbits.in"
	And user enters the password "123456"
	And user clicks the login button

	Then user successfully logged in and gets the accounts page title
	And the title should be "My account - My Store"