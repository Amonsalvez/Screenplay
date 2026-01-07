@loggin
Feature: login test

  Scenario Outline: testing the successful login
    Given the user is on the serenity demo page
    When attempts to log in
      | user   | pass   |
      | <user> | <pass> |
    Then validate the text on screen <title>
    And the url should be <expectedUrl>
    Examples:
      | user        | pass         | title    | expectedUrl                             |
      | visual_user | secret_sauce | Products | https://www.saucedemo.com/inventory.html |
