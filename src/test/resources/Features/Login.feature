Feature: NopCommerce Login
  Background:
    Given User able to open Browser
    And Enter an Url


  Scenario: Nopcommerce Valid Login Test
    When User click on Login Link
    And User on Login Page and Verify Login page Title
    Then User enter Username and Password and Click on login button
    Then User navigates to my account page

