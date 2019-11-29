Feature: Click and Collect Scenarios
  I want to perform Click and Collect journey either as a registered user or as a guest user.

Background: User is Logged In
		Given I launch Red App
    When I click Hamburger/Account
    And I click Login/Signin
    
Scenario Outline: Registered User C&C Checkout Journey
		Then I enter an "<email>" and "<password>"
		And I click Sign In
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
      | sampletest@gmail.com | test123  | Click & Collect | Credit Card | 4111 1111 1111 1111 | Test | 123 |
      | sampletest@gmail.com | test123  | Click & Collect | Warehouse Money Card | 4065 9301 0900 0002 | Test | 123 |


