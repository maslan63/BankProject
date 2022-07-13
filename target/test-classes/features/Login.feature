Feature: Login to website


  Scenario: Login with valid credentials
    Given user on the home page
    And user logs in with valid credentials
    Then user will be on the Personal Banking page


    Scenario: Login with invalid credentials
      Given user on the home page
      And user logs in with invalid credentials
      Then user will be seeing error message


      Scenario: Login with blank credentials
        Given user on the home page
        And user clicks login button
        Then user will be seeing error message