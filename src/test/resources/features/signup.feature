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


  @negative
  Scenario: Prevent registration with an already registered email address
    When The user registers with existing information:
      | name  | Sara Smith          |
      | email | s.smith@example.com |
    Then The user should see the error message

  @negative
  Scenario Outline: Validate browser native popups on registration form
    When The user enters name "<name>" and email "<email>"
    Then Browser validation message for registration field "<field>" should be "<expectedMessage>"
    Examples:
      | name  | email            | field        | expectedMessage                                                                        |
      | Sarah |                  | signup-email | Lütfen bu alanı doldurun.                                                              |
      |       | s.smith@mail.com | signup-name  | Lütfen bu alanı doldurun.                                                              |
      |       |                  | signup-name  | Lütfen bu alanı doldurun.                                                              |
      | Sarah | invalid          | signup-email | Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"invalid\" adresinde \"@\" eksik.  |
      | Sarah | invalid@         | signup-email | Lütfen \"@\" işaretinden sonra gelen kısmı ekleyin. \"invalid@\", tam bir adres değil. |
      | Sarah | @example.com     | signup-email | Lütfen başına \"@\" ekleyin. \"@example.com\" adresi eksik.                            |
      | Sarah | !%&+/()=         | signup-email | Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"!%&+/()=\" adresinde \"@\" eksik. |

  @negative @reg
  Scenario Outline: Validate browser popup for first invalid field in address form
    When The user enters invalid data on signup form with password "<password>", first name "<firstName>", last name "<lastName>", address "<address>", state "<state>", city "<city>", zipcode "<zipcode>", mobile "<mobile>"
    Then Browser validation message for registration field "<field>" should be "<expectedMessage>"
    Examples:
      | password | firstName | lastName | address | state | city | zipcode | mobile    | field         | expectedMessage           |
      |          | John      | Doe      | Street  | NY    | NY   | 12345   | 123456789 | password      | Lütfen bu alanı doldurun. |
      | test123  |           | Doe      | Street  | NY    | NY   | 12345   | 123456789 | first_name    | Lütfen bu alanı doldurun. |
      | test123  | John      |          | Street  | NY    | NY   | 12345   | 123456789 | last_name     | Lütfen bu alanı doldurun. |
      | test123  | John      | Doe      |         | NY    | NY   | 12345   | 123456789 | address       | Lütfen bu alanı doldurun. |
      | test123  | John      | Doe      | Street  |       | NY   | 12345   | 123456789 | state         | Lütfen bu alanı doldurun. |
      | test123  | John      | Doe      | Street  | NY    |      | 12345   | 123456789 | city          | Lütfen bu alanı doldurun. |
      | test123  | John      | Doe      | Street  | NY    | NY   |         | 123456789 | zipcode       | Lütfen bu alanı doldurun. |
      | test123  | John      | Doe      | Street  | NY    | NY   | 12345   |           | mobile_number | Lütfen bu alanı doldurun. |

