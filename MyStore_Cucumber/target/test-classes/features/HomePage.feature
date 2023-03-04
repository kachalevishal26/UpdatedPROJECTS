@all
Feature: Home page features

@logo
Scenario: verify the logo visibility and its width and height
	Given user is on the home page
	When the logo should be visible
	Then width and height of logo should be "350" and "99"
	
@category
Scenario Outline: verify the category section and its count
	Given user is on the home page
	When user gets the category "<product>" section
	Then the category count should be 3
	
	Examples:
	|product|
	|WOMEN|
	|DRESSES|
	|T-SHIRTS|

@searchProduct
Scenario: Search product
	Given user is on the home page
	When tap on search button and enter "T-shirts" on it and select the suggested text
	Then print the name of the product