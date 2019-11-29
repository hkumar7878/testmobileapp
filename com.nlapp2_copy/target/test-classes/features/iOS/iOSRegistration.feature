Feature: iOS Registration Red App
  I want to register myself in the app as a first time user.
    
  Scenario: New User Registration - iOS
    Given I open the App
    When I click Account tab
    And I click Register button on Account Page
    Then I landed on the registration page
    And I enter mandatory details for the registration
    Then I click REGISTER button
    And I see the user is logged in
    
    
    
    
    