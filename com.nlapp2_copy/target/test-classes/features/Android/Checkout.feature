Feature: Checkout journey
  As a registered / guest user
  I want to shop online and complete the checkout process by paying either by credit card, WH money card or PartPay.

  #Scenario Outline: Registered User Checkout Journey
  #Given I login using "<email>" and "<password>"
  #And I look for "Watches"
  #When I select "Watches" from the appropriate category
  #And I select to add one of the items to the cart
  #And I go to cart
  #And I select "<delivery method>"
  #And I click Checkout
  #Then I add the delivery details
  #And I select the "<Payment Method>"
  #And I Click Payment button to enter the card details and "<Card Number>"
  #And successful payment displays the order number
  #
  #Examples:
  #| email                | password | delivery method | Payment Method       | Card Number         |
  #| crashfix@gmail.com   | test123  | Home Delivery   | Credit Card          | 4111 1111 1111 1111 |
  #| sampletest@gmail.com | test123  | Home Delivery   | Warehouse Money Card | 4065 9301 0900 0002 |
  #
  ###########################################################################################################################################################################################################################
  #Scenario Outline: Guest User Checkout Journey
  #Given I launch Red App
  #And I look for "Watches"
  #When I select "Watches" from the appropriate category
  #And I select to add one of the items to the cart
  #And I go to cart
  #And I select "<delivery method>"
  #And I click Checkout
  #And I proceed as a "<Mode>" user
  #Then I add the delivery details
  #And I select the "<Payment Method>"
  #And I Click Payment button to enter the card details and "<Card Number>"
  #And successful payment displays the order number
  #
  #Examples:
  #| Mode    	| delivery method | Payment Method       | Card Number         |
  #| Guest    | Home Delivery   | Credit Card          | 4111 1111 1111 1111 |
  #| Guest    | Home Delivery   | Warehouse Money Card | 4065 9301 0900 0002 |
  #
  ###########################################################################################################################################################################################################################
  #Scenario Outline: Registered User Part Pay Checkout Journey
  #Given I login using "<email>" and "<password>"
  #And I look for "R2126917"
  #When I select "R2126917" from the appropriate category
  #And I select to add one of the items to the cart
  #And I go to cart
  #And I select "<delivery method>"
  #And I click Checkout
  #Then I add the delivery details
  #And I select the "<Payment Method>"
  #And I Click Payment button to enter the PartPay "<PartPayEmail>" and "<PartPayPassword>"
  #And successful payment displays the order number
  #
  #Examples:
  #| email              | password | delivery method | Payment Method | PartPayEmail                    | PartPayPassword |
  #| crashfix@gmail.com | test123  | Home Delivery   | PartPay        | buddhika.don@thewarehouse.co.nz | PartPay123      |
  ###########################################################################################################################################################################################################################
  Scenario Outline: Guest User Part Pay Checkout Journey
    Given I launch Red App
    And I look for "R2126917"
    When I select "R2126917" from the appropriate category
    And I select to add one of the items to the cart
    And I go to cart
    And I select "<delivery method>"
    And I click Checkout
    And I proceed as a "<Mode>" user
    Then I add the delivery details
    And I select the "<Payment Method>"
    And I Click Payment button to enter the PartPay "<PartPayEmail>" and "<PartPayPassword>"
    And successful payment displays the order number

    Examples: 
      | Mode  | delivery method | Payment Method | PartPayEmail                    | PartPayPassword |
      | Guest | Home Delivery   | Zip        | buddhika.don@thewarehouse.co.nz | PartPay123      |
