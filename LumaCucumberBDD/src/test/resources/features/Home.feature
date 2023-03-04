@all 
Feature: home page features 

Background: 
	Given user is on homepage 
	
@logo 
Scenario: verify the logo 
	Given the logo should be visible 
	#	When logo width should be "768px"
	#	And logo height should be "1.42857143" 
	
@menubar 
Scenario: verify the menubar 
	Given menubar should be visible 
	When menubar section should contain 
		|What's New|
		|Women|
		|Men|
		|Gear|
		|Training|
		|Sale|
	Then section count should be 6 
	
@searchbar 
Scenario: verify search bar 
	Given search bar should be visible 
	When enter some text it should show search suggestions 
	And shopping cart should be visible 