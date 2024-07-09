Feature: Home page automation of DemoToolsQA application

  Scenario: Navigate to DemoToolsQA web application
    Given user go to DemoToolsQA web application
    And user see the title of the page
    Then close browser
