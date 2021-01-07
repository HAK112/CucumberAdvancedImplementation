Feature: Login functionality

  Background: Test the login functionality
    Given User navigates to the login page
    When User fills the login form with username and password 
    And Clicks on signin button to login
    Then User will be navigated to the accountpage

  Scenario: Test the redirected page when logged in
    Then page title of the page should have MyAccount

  Scenario: Test the logout button exist
    When user hovers on the navbar
    Then logout button will exist on the right side
