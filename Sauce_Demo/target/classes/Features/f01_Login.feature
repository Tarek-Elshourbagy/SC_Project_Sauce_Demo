@smoke
Feature: Login with all user website provided
  Scenario Outline: Login with all user website provided
    Given Navigate to URL website
    When Enter email and password "<username>" "<password>"
    And Click on login icon
    Then login successfully to home page

    Examples:
      |username|                        | password  |
      | standard_user              |    | secret_sauce  |
      | problem_user               |    | secret_sauce  |
      | performance_glitch_user    |    | secret_sauce  |
      | error_user                 |    | secret_sauce  |
      | visual_user                |    | secret_sauce  |