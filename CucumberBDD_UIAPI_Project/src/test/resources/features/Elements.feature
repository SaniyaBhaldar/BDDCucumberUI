Feature: Elements menu automation of DemoToolsQA application

  Background: 
    Given user on the homepage

  Scenario: Create a new user using textbox option
    When user enters the following details
      | Fields            | Values               |
      | Full Name         | saniya faiyyaj patel |
      | Email             | saniya96@gmail.com   |
      | Current address   | wakad, pune          |
      | Permanant address | wakad, pune          |
    And user clicks submit button
    Then entered user information displayed below in a text area

  Scenario: Validation for radio button option
    When clicks on radio button option
    And user can see question with selection of radio buttons
    When user clicks on yes radio button
    Then selected radio button information displayed below in a text area

	@smoke
  Scenario: Click on check box option
    When user click on check box option
    Then click on check box button
