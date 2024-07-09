Feature: Book store application automation of DemoToolsQA application

  Background: 
    Given user on the homepage and clicks on Book store menu option

  #Before running this scenario change password for new user registration and needed manaul intervention for recaptcha
  Scenario: Create a new user using new user button
    Given user clicks login menu and clicks new user button
    When user enters the following details for registration
      | Fields     | Values     |
      | First Name | saniya     |
      | Last Name  | Patel      |
      | UserName   | saniya     |
      | Password   | Saniya267* |
    And user check recaptcha option and clicks register button
    Then user registered alert displayed and clicks ok

  Scenario: Validate positive login case
    Given user clicks login option
    When user enters the following details for login
      | Fields   | Values     |
      | UserName | saniya     |
      | Password | Saniya123* |
    And user clicks login button
    Then user redirected to profile page and validate logged in username
