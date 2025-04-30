Feature: Contact Us Form Functionality

  Background:
    Given User clicks on Contact Us button

    @positive @contactUs
  Scenario Outline: Submit contact form with different user inputs
    When User fills the contact form with "<name>", "<email>", "<subject>", "<message>" and uploads "<filepath>" then submits
    Then Verify success message "Success! Your details have been submitted successfully." is visible

    Examples:
      | name  | email             | subject       | message           | filepath     |
      | Maria | maria@example.com | Product Issue | Hello I am Maria. | testfile.txt |

