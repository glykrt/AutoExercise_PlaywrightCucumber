Feature: User Registration and Account Deletion

  As a user, I should be able to login, so I can see my dashboard

  Background:
    Given The user clicks on the Signup-Login button

  @positive
  Scenario: Successfully register with a new email address
    When The user registers with the following information:
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
      | country   | United States       |
      | state     | California          |
      | city      | Los Angeles         |
      | zipcode   | 90001               |
      | mobile    | 1234567890          |
    Then The account should be created successfully


  @negative @reg
  Scenario: Prevent registration with an already registered email address
    When The user registers with existing information:
      | name      | Sara Smith          |
      | email     | s.smith@example.com |
    Then The user should see the error message
