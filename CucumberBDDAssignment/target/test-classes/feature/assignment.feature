@All
Feature: Cucumber BDD Assignment

  Background: 
    Given User Launch url

  @RedirectionPage
  Scenario: E-Commerce First Page
    Then User gets redirected URL "http://automationpractice.com/index.php"

  @Logo @Img
  Scenario: Logo Visibility
    When After launching Check logo is displayed or not
    Then Logo  having width is "350" and height is "99"

  @ProductCategories
  Scenario Outline: Product categories
    When After Launching url categories of the product count is 3
    Then Displayed "<product>" the product categories

    Examples: 
      | product  |
      | WOMEN    |
      | DRESSES  |
      | T-SHIRTS |

  @Search
  Scenario: Search Product
    When User Enters Items "Faded"
    Then Get suggestion to user with entered Items i.e "Faded"

  @Twitter
  Scenario: Social Account Name
    When User Click on twitter link
    And It navigated to new window url contains "seleniumfrmwrk"
    Then User gets account name is "Selenium Framework"
