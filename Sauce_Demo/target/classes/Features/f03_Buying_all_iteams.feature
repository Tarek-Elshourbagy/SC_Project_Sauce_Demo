@smoke
Feature: Positive flow of buying all items
  Scenario Outline: Positive flow of buying all items
    Given Navigate to URL Website
    When Enter Email and Password "<username>" "<password>"
    And Click on Login icon
    Then login Successfully to home page
    When choose the items by clicking on add to card
    Then check the items is added to the card
    And we clicking on the shopping icon
    And clicking on checkout to move to anther page and enter the valid data
    And after clicking finished a success message appeared
    Examples:
      |username|                        | password  |
      | standard_user              |    | secret_sauce  |
#      | locked_out_user            |    | secret_sauce  |
#      | problem_user               |    | secret_sauce  | error due to thr pereformance
      | performance_glitch_user    |    | secret_sauce  |
#      | error_user                 |    | secret_sauce  | An error defect displayed when i used this user
      | visual_user                |    | secret_sauce  |
