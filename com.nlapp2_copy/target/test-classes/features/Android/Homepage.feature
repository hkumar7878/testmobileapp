@tag
Feature: Homepage
  I want to check the menus on homepage hambuger menu, browse tab, Specials tab and scan, wishlist tabs

  Scenario Outline: Hambuger menus - Guest mode
    Given I launch Red App
    When I click Hamburger/Account
    Then I see the below "<menus>"
    
    Examples: 
      | menus |
      | Home |
      | Browse Categories |
      | Specials |
      | Price Scanner |
      | Wish List |
      | Order History |
      | Store Finder |
      | Notification Preferences |
      | Call Customer Support |
      | Email Customer Support |
      | App Feedback |
      | About |

  Scenario Outline: Hambuger menus - Login mode
    Given I launch Red App
    When I login using "regressiontest@gmail.com" and "test123"
    And  I click Hamburger/Account
    Then I see the below "<menus>"

   Examples: 
      | menus |
      | Home |
      | Browse Categories |
      | Specials |
      | Price Scanner |
      | Wish List |
      | Order History |
      | My Account |
      | Store Finder |
      | Notification Preferences |
      | Call Customer Support |
      | Email Customer Support |
      | App Feedback |
      | About |
      
    Scenario Outline: Hambuger menus - Login mode
    Given I launch Red App
    And I see the below "<tabs>"

   Examples: 
      | tabs |
      | Home |
      | Browse |
      | Specials |
      | Scan |
      | Wish List |
