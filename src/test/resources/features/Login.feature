@Login
Feature: Login
  User wants to log in to the website Sauce Demo

  @TC1
  Scenario: User logs in with valid credentials
    Given User is already on the login page
    When User inputs "standard_user" as the username
    And User inputs "secret_sauce" as the password
    And User clicks the login button
    Then User will be redirected to the inventory page

  @TC2
  Scenario: User logs in with valid credentials
    Given User is already on the login page
    When User inputs "standard_user" as the username and "secret_sauce" as the password
    Then User will be redirected to the inventory page

  @TC3
  Scenario Outline: User logs in with invalid credentials
    Given User is already on the login page
    When User inputs "<userName>" as the username and "<password>" as the password
    Then User will see an error message "<errorText>" on the login page
    Examples:
      | userName      | password     | errorText                                                   |
      |               | secret_sauce | Epic sadface: Username is required                          |
      | standard_user |              | Epic sadface: Password is required                          |
      | user123       | password123  | Epic sadface: Username and password do not match any user in this service |
      |               |              | Epic sadface: Username is required                          |
