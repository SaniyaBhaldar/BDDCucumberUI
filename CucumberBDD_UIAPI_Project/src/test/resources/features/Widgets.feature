Feature: Widgets automation of DemoToolsQA application

  Background: 
    Given user on the homepage and clicks on widgets Menu option

  Scenario: Validation for select menu option
    When user clicks on select menu option
    Then user see header text and title for first selection option
    When user select any value from select value dropdown
    Then validate selected value for first
    When user select any value from select one dropdown
    Then validate selected value for second
    When user select any value from old style select menu dropdown
    Then validate selected value for third
    When user select two values from multiselect dropdown
    Then validate selected values for fourth
    When user select two values from standard multiselect dropdown
    Then validate selected values for fifth
