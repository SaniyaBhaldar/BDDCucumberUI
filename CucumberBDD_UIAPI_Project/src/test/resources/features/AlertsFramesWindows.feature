Feature: Alerts, frames and windows automation of DemoToolsQA application

  Background: 
    Given user on the homepage and clicks on Alerts, Frame and Windows Menu option

  Scenario: Validation for browser window
    Given user clicks on browser windows option
    When user clicks on new tab option
    Then user can see new opened tab and message
    When user clicks on new window option
    Then user can see new opened window and message
    When user clicks on new window message option
    Then user can see new opened window and detailed message

  Scenario: Validation for alerts
    Given user clicks on alerts option
    When user clicks on first click me button
    Then user can see simple alert window and clicks ok
    When user clicks on second click me button
    Then user can see alert window after five seconds
    When user clicks on third click me button
    Then user can see confirm box and clicks cancel
    Then user can see selected option value
    When user clicks on fourth click me button
    Then user can see pop-up box and enters name
    Then user can see entered value

  Scenario: Validation for modal dialogs
    Given user clicks on modal dialogs option
    Then user can see header text and the text to do action
    When user clicks on small modal button
    Then user can see opened small modal and message
    And user clicks on close button
    When user clicks on large modal button
    Then user can see opened large modal and message
    And user clicks on cross button option and see header text

  Scenario: Verify Nested Frame Text
    When Click on the Nested Frames sub menu
    And user switch to frame1
    And user switch to frame2
    Then the text "Nested frame body" is display
    When Switch back to the default content
    Then Verify the text "Nested frames" is displayed
