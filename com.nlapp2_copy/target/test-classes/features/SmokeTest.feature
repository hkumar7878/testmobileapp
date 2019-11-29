Feature: Smoke Tests
  I want to use the below scenarios for my smoke pack
######################################################################################################################################## 
  Scenario: New Registration functionality
    Given I launch the AUT
    When I click Hamburger/Account
    And I click Register button
    Then I land on the registration page
    And I enter all required details for registration
    Then I click Register button
    And I see the Registration Confirmation
    
######################################################################################################################################## 
  Scenario Outline: Login functionality
    Given I launch Red App
    When I click Hamburger/Account
    And I click Login/Signin
    Then I enter an "<email>" and "<password>"
    And I click Sign In
    Then I see the logged in email at Hamburger/Account

    Examples: 
      | email                | password |
      | sampletest@gmail.com | test123  |
      | jothi2k9@gmail.com   | Test123  |
      
########################################################################################################################################    
  Scenario Outline: Search Functionality
    Given I launch the AUT
    When I click SearchButton
    Then I enter "<Looking For>"
    And I click the results to view the products

    Examples: 
      | Looking For  |
      | Living & Co | 
      | 4547410349467 |
      | R2377591 |
      | Mouse Disney Dress |
      | Orange |
      
########################################################################################################################################       
#Scenario: Guest User - Add and Remove an item to the cart
   #Given I launch Red App
    #And I look for "Watches"
    #When I select "Watches" from the appropriate category
    #And I select to add one of the items to the cart
    #And I go to cart
    #And I click the remove deletes the item from a cart
    #Then I will see the empty cart
    
#########################################################################################################################################         
#Scenario: My Account Functionality
   #	Given I login using "sampletest@gmail.com" and "test123"
   #	And I click Hamburger/Account
    #When I click My Account
    #Then I see list of options under My Account
    
#########################################################################################################################################     
Scenario Outline: Registered User C&C Checkout Journey
		Given I login using "<email>" and "<password>"
    And I look for "Watches"
    When I select "Watches" from the appropriate category
    And I select to add one of the items to the cart
    And I go to cart
    And I select "<delivery method>"
    And I click Checkout
    Then I add Click and Collect details
    And I select the "<Payment Method>"
    And I Click Payment button to enter "<CardNum>" and "<Name>" and "<SecurityCode>"
    And I Click Place order now
    And successful payment displays the order number
    
    Examples: 
      | email                | password | delivery method | Payment Method | CardNum | Name | SecurityCode |
      | regressiontest@gmail.com | test123  | Click & Collect | Credit Card | 4111 1111 1111 1111 | Test | 123 |
      
########################################################################################################################################  

Scenario Outline: Registered User Home Delivery Checkout Journey
		Given I login using "<email>" and "<password>"
    And I look for "Watches"
    When I select "Watches" from the appropriate category
    And I select to add one of the items to the cart
    And I go to cart
    And I select "<delivery method>"
    And I click Checkout
    Then I add the delivery details
    And I select the "<Payment Method>"
    And I Click Payment button to enter "<CardNum>" and "<Name>" and "<SecurityCode>"
    And I Click Place order now
    And successful payment displays the order number
    
    Examples: 
      | email                | password | delivery method | Payment Method | CardNum | Name | SecurityCode |
      | customerorder@gmail.com | test123  | Home Delivery | Warehouse Money Card | 4065 9301 0900 0002 | Test | 123 |
      
########################################################################################################################################  

   