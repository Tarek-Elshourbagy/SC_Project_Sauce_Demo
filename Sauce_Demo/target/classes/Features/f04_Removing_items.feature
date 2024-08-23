@smoke
Feature: Positive flow of removing all items after add to card
  Scenario Outline: Positive flow of buying all items
    Given navigate to URL Website
    When enter Email and Password "<username>" "<password>"
    And click on Login icon
    Then Login Successfully to home page
    When Choose the items by clicking on add to card
    Then Check the items is added to the card
    And We clicking on the shopping icon
    And Removing all items
    Examples:
      |username|                        | password  |
      | standard_user              |    | secret_sauce  |