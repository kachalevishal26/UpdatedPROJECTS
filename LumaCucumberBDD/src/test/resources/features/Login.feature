@all 
Feature: login features 

@title 
Scenario: verify the page title 
	Given user is on the login page 
	When user gets the page title 
	Then page title should be "Customer Login Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites" 
	
@forgotPassword 
Scenario: verify the forgot password and create account options 
	Given user is on the login page 
	Then forgot password button should be displayed 
	And create account button should be displayed 
	
@login 
Scenario: verify login 
	Given user is on the login page 
	When user enters the email "vishal@sbt.com" 
	And user enters the password "Vishal@26" 
	And user clicks the Sign In button 
	And user gets the page title 
	Then page title should be "My Account Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites" 
	
	#	Examples: 
	#		|email|password|
	#		|vishal@sbt.com|Vishal@26|
	#		|rita@sbt.com|rita@123|
	#		|test@sbt.com|test@123|