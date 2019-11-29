Feature: iOS Checkout journey
  As a registered/guest user
  I want to shop online and complete the checkout process by paying either by credit card, WH money card or Part pay card.
    
    Scenario Outline: iOS Registered User Checkout Journey
    Given I login using "<email>" and "<password>"
    And I look for "Watches"
    When I select "Watches" from the appropriate category
    And I select to add one of the items to the cart
    And I go to cart
    And I select "<delivery method>"
    And I click Checkout
    Then I add the delivery details
    And I select the "<Payment Method>"
    And I Click Payment button to enter the card details
    And successful payment displays the order number
    
    Examples: 
      | email                | password | delivery method | Payment Method |
      | crashfix@gmail.com   | test123  | Home Delivery   | Credit Card  |
			| sampletest@gmail.com   | test123  | Home Delivery   | Warehouse Money Card  |