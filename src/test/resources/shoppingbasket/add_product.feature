Feature: Add product

  Scenario: First product
    Given I am user "Tiago"
      And There is no Shopping basket yet for user "Tiago"
    When I add 1 item of product "Cheese" to the Shopping basket
    Then I should have a Shopping basket created
      And My basket should have 1 item of product "Cheese"

  Scenario: Second product
    Given I am user "Tiago"
    When I add 1 item of product "Cheese" to the Shopping basket
      And I add 1 item of product "Apple" to the Shopping basket
    Then I should have 2 products in the Shopping basket
      And My basket should have 1 item of product "Cheese"
      And My basket should have 1 item of product "Apple"

  Scenario: Separated basket
    Given I am user "Tiago"
      And There is no Shopping basket yet for user "Tiago"
     When I add 1 item of product "Cheese" to the Shopping basket
     Then I should have a Shopping basket created
      And There is no Shopping basket yet for user "Cris"

#  Scenario: Basket is persisted
#    Given I am user "Tiago"
#    And There is no Shopping basket yet for user "Tiago"
#    When I add 1 item of product "Cheese" to the Shopping basket
#    And I close the store and reopen it
#    Then I should have a Shopping basket created
#    And My basket should have 1 item of product "Cheese"