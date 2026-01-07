@add
Feature: Add products to cart

  Background:
    Given the user is logged in
      | user          | pass         |
      | standard_user | secret_sauce |

  Scenario: Add Sauce Labs Backpack
    When the user adds the product "Sauce Labs Backpack"
    Then the shopping cart badge should display 1


