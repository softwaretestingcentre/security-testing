Feature: Juice Shop is susceptible to XSS attacks

  Scenario: Haxxor injects HTML into the search input
    Given Haxxor goes to the Juice Shop
    When she injects HTML into the search input
    Then she sees an alert message containing "xss"
    And she sees she has solved the "DOM XSS" challenge