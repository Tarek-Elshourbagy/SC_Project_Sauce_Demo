@smoke
Feature: Sorting all items by price
  Scenario Outline: Sorting all items by price
    Given Navigate To URL website
    When enter email and password "<username>" "<password>"
    And click on login icon
    And Login successfully to home page
    Then sorting the items from lower price
    And sorting the items from Highest price
    Examples:
      |username|                        | password  |
      | standard_user              |    | secret_sauce  |