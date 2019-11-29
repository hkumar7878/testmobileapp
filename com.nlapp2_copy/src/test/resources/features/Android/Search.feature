Feature: Search Product in the app
  I want to search the product in the app
  To know the various options available for online shopping

  Scenario: Search Product
    Given I launch the AUT
    When I click SearchButton
    Then I enter "Rings"
    And I click the results to view the products
