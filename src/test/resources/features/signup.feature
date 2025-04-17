Feature: User Registration and Account Deletion

  As a user, I should be able to login, so I can see my dashboard

  @reg
  Scenario: Register a new user successfully
    Given The user clicks on the Signup-Login button
    And The user registers with the following information:
      | name      | Sara Smith          |
      | email     | s.smith@example.com |
      | title     | Mrs                 |
      | password  | Password123         |
      | day       | 10                  |
      | month     | May                 |
      | year      | 1990                |
      | firstName | Sarah               |
      | lastName  | Simth               |
      | address   | 123 Main St         |
      | state     | California          |
      | city      | Los Angeles         |
      | zipcode   | 90001               |
      | mobile    | 1234567890          |
    Then The account should be created successfully