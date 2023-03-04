Feature: accounts page features 

Background: 
	Given user is already logged in to site 
	|username|password|
	|vishal+1@sevenbits.in|123456|
		
Scenario: page title 
	Given user is on the accounts page 
	When user gets the page title 
	Then the page title should be "Account Login" 
	
Scenario: my account section 
	Given user is on the accounts page 
	When user gets the my account section 
		|My Account|
		|Edit Account|
		|Password|
		|Address Book|
		|Wish List|
		|Order History|
		|Downloads|
		|Recurring payments|
		|Reward Points|
		|Returns|
		|Transactions|
		|Newsletter|
		|Logout|
	Then account section count should be 13 
