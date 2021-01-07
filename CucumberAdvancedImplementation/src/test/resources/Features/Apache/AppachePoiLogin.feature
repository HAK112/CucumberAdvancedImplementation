Feature: Login functionality

  Scenario Outline: Test the login functionality with different set of data
    Given User navigates to the login page
    When User fills the form from given sheetname "<sheetname>" and <rownumber>
    And Clicks on signin button to login
    Then User will be navigated to the home page

    Examples: 
      | sheetname | rownumber |
      | Sheet1    |         0 |
      | Sheet1    |         1 |
    
    
