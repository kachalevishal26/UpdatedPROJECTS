@all
Feature: accounts page feature 

Background:
	Given user should be already logged in to the app
	|username|password|
	|vishal+1@sevenbits.in|123456|
	
@accTitle
Scenario: page title
	Given user is on the accounts page
	When user gets the page title 
	Then page title should be "My account - My Store"

@accountFeatures
Scenario: account section features
	Given user is on the accounts page
	When user gets the accounts section
	|ORDER HISTORY AND DETAILS|
	|MY CREDIT SLIPS|
	|MY ADDRESSES|
	|MY PERSONAL INFORMATION|
	|MY WISHLISTS|
	|Home|
	Then account section count should be 6