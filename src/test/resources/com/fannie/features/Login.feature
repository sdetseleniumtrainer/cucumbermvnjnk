Feature: Test Login functionality of SdetTraining.com website

@ddt    
Scenario Outline: positive testing sdettraining login with username and password
    Given user is on sdettraining homepage
    When user clicks on top right hand Log in button
    And user enters "<User>" in email field
    And user enters "<Pwd>" in password field
    And user clicks on Login button
    Then user is displayed "Welcome back!" message
    
    
     Examples:
      | User                   | Pwd         |
      | irfan@sdettraining.com | Password    |
      | test@test.com          | Abc123      |
      | alex.good@gmail.com    | Alex123     | 
