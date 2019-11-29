Feature: iOS Search Product in the app
  I want to search the product in the app
  To know the options available for online shopping

  Scenario: iOS Search Product
    Given I open the App
    When I click Search textbox
    Then I enter the term "Rings"
    And I click the results to view the products
