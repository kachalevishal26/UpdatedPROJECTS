@all
Feature: Accounts page features

Background: 
	Given user is already logged in
	|username|password|
	|vishal+1@sevenbits.in|123456|

@title
Scenario: Accounts page title
	Given user is on the accounts page
	When user gets the title of the page
	Then page title should be "My account - My Store"

@accountsFeatures
Scenario: Accounts page section count
	Given user is on the accounts page
	Then user gets the accounts section
	|ORDER HISTORY AND DETAILS|
	|MY CREDIT SLIPS|
	|MY ADDRESSES|
	|MY PERSONAL INFORMATION|
	|MY WISHLISTS|
	|Home|
	And the accounts section counts should be 6