@smoke
Feature: Sorting all items by price
  Scenario Outline: Sorting all items by price
    Given Navigate To URL
    When enter email , password "<username>" "<password>"
    And click login icon
    And Login successfully to homepage
    Then sorting the items from A-Z price
    And sorting the items from Z-A price
    Examples:
      |username|                        | password  |
      | standard_user              |    | secret_sauce  |