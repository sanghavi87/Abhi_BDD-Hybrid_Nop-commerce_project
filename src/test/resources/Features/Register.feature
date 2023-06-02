Feature: NopCommerce Register
  Background:
    Given User able to open Browser
    And Enter an Url


  Scenario: NopCommerce Registration with valid details
    When User Click on Register btn on homePage
    Then User able to enter personal details
    Then click on Register btn submit
    Then User able to see confirmation message

