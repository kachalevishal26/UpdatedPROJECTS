@all
Feature: homepage features

@logo
Scenario: Logo visibility
	Given navigate to the site
    When check logo is displayed or not
    Then width and height of logo should be "350" and "99"
    
@category
Scenario: Check the categories bar
    Given navigate to the site
    When check the categories section is visible
    Then verify that the categories should have following texts
    |WOMEN|
    |DRESSES|
    |T-SHIRTS|
    And the section count should be 3