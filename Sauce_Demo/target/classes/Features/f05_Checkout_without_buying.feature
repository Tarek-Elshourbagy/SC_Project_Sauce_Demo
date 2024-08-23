@smoke
Feature: Positive flow of removing all items after add to card
  Scenario Outline: Positive flow of buying all items
    Given navigate To URL Website
    When enter Email And Password "<username>" "<password>"
    And click on Login Icon
    Then Login Successfully to home Page
    And We clicking on the shopping Icon
    And Cleck on checkout without buying
    And validate that no expenses
    Examples:
      |username|                        | password  |
      | standard_user              |    | secret_sauce  |