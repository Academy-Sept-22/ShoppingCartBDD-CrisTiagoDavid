Feature: Add product

  Scenario: First product
    Given There is no Shopping basket yet
    When I add a product to the Shopping basket
    Then I should create the Shopping basket