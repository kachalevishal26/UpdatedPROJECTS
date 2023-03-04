@all 
Feature: accounts features 

Background: 
	Given  user is on the login page 
	When  user enters the email "vishal@sbt.com" 
	And  user enters the password "Vishal@26" 
	And  user clicks the Sign In button 
	
@title 
Scenario: account page title 
	Given  user is on the accounts page 
	When  user gets the page title 
	Then  page title should be "My Account Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites" 
	
@accountPage 
Scenario: account page section count 
	Given  user is on the accounts page 
	When  user gets the accounts section 
		|My Account|
		|My Orders|
		|My Downloadable Products|
		|My Wish List|
		|Address Book|
		|Account Information|
		|Stored Payment Methods|
		|My Product Reviews|
		|Newsletter Subscriptions|
	Then  the section count should be 9