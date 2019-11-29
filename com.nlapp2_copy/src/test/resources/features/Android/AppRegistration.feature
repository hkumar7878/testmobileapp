Feature: Registration Red App
  I want to register myself in the app as a first time user.

  #Scenario Outline: New User Registration
    #Given I launch the AUT
    #When I click Hamburger menu
    #And I click Register button
    #Then I land on the registration page
    #And I enter <Firstname> and <Lastname> and <Email> and <Password>
    #Then I click Register button
    #And I see the logged in email at Hamburger menu

    #Examples: 
     # | Firstname  | Lastname | Email  | Password |
      #| firsttime | user  | firsttime@gmail.com | test123 |
      
  #Scenario: New User Registration
  #  Given I launch the AUT
   # When I click Hamburger menu
    #And I click Register button
    #Then I land on the registration page
    #And I enter "FirstTime" and "User" and "FirstTime@gmail.com" and "test123"
    #Then I click Register button
    #And I see the logged in "FirstTime@gmail.com" at Hamburger menu
    
  Scenario: New User Registration
    Given I launch the AUT
    When I click Hamburger/Account
    And I click Register button
    Then I land on the registration page
    And I enter all required details for registration
    Then I click Register button
    And I see the Registration Confirmation
    
    
    
    
    