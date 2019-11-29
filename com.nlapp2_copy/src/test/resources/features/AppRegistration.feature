@smoke
Feature: Registration Red App
  I want to register myself in the app as a first time user.

    
  Scenario: New User Registration
    Given I launch the AUT
    When I click Hamburger/Account
    And I click Register button
    Then I land on the registration page
    And I enter all required details for registration
    Then I click Register button
    And I see the Registration Confirmation
    
    
    
    
    