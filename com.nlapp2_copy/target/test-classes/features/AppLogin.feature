@smoke 
Feature: Login NL App
  As a user with valid credentials
  I want to able to log in to the NL app
  So that I can shop online, add items in wishlist, track orders and so on
  
  #Scenario: Valid User Login to the RedApp
    #Given I launch Red App
    #And I set up Applitools
    #When I click Hamburger/Account
    #And I Capture the screen
    #And I click Login/Signin
    #And I Capture the screen
    #Then I enter an "jothi2k9@gmail.com" and "test123"
    #And I click Sign In
    #And I Capture the screen
    #Then I see the logged in email at Hamburger/Account
    #And I Capture the screen
    #And I tear down Applitools
  
  Scenario: Valid User Login to the RedApp
    Given I launch Red App
    When I click Hamburger/Account
    And I click Login/Signin
    Then I enter an "jothi2k9@gmail.com" and "test123"
    And I click Sign In
    Then I see the logged in email at Hamburger/Account
   
  Scenario: Invalid User Login to the RedApp
    Given I launch Red App
    When I click Hamburger/Account
    And I click Login/Signin
    Then I enter an "jothi2k9@gmail.com" and "Test123"
    And I click Sign In
    Then I see the Login failed Message
