Feature: DemoQA Forms

  Background: 
    Given user on the homepage

  @StudentRegistrationForm
  Scenario: User submits the form with valid data
    Given the user is on DemoQA element page click on Forms tab
    When the user enters "Aishwarya" in the First Name field
    And the user enters "Ganweer" in the Last Name field
    And the user enters "aishwaryag@gmail.com" in the Email field
    And the user selects Female from the radio button
    And the user enters "0123456789" in the Mobile Number field
    And the user clicks the Submit button
    Then the user should see a success message 
