Feature: Users can read the privacy policy

  Scenario: Haxxor reads the privacy policy
    Given Haxxor goes to the Juice Shop
    When she opens the Privacy Policy
    Then she sees she has solved the "Privacy Policy" challenge
