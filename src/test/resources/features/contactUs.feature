Feature: Contact Us Form Functionality

  Background:
    Given User clicks on Contact Us button

  @positive
  Scenario Outline: Submit contact form with different user inputs
    When User fills the contact form with "<name>", "<email>", "<subject>", "<message>" and uploads "<filepath>" then submits
    Then Verify success message "Success! Your details have been submitted successfully." is visible
    Examples:
      | name  | email             | subject       | message           | filepath     |
      | Maria | maria@example.com | Product Issue | Hello I am Maria. | testfile.txt |


  @negative @contactUs
  Scenario Outline: Invalid email formats should trigger specific validation messages
    When User submits the contact form with invalid email "<email>"
    Then Browser validation message for email field should be "<expectedMessage>"
    Examples:
      | email            | expectedMessage                                                                            |
      |                  | Lütfen bu alanı doldurun.                                                                  |
      | EMPTY_SPACE      | Lütfen bu alanı doldurun.                                                                  |
      | @gmail.com       | Lütfen başına \"@\" ekleyin. \"@gmail.com\" adresi eksik.                                  |
      | spaces@gmail.com | Lütfen başına \"@\" ekleyin. \"@gmail.com\" adresi eksik.                                  |
      | as.gmail.com     | Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"as.gmail.com\" adresinde \"@\" eksik. |
      | as@@gmail.com    | Başında \"@\" bulunan kısımda \"@\" simgesi bulunmamalıdır.                                |
      | @@gmail.com      | Lütfen başına \"@\" ekleyin. \"@@gmail.com\" adresi eksik.                                 |
      | test@ gmail.com  | Başında \"@\" bulunan kısımda \" \" simgesi bulunmamalıdır.                                |
      | test @gmail.com  | Başında \"@\" bulunan kısımda \" \" simgesi bulunmamalıdır.                                |
      | test@gmail.      | \".\", \"gmail.\" adı içinde yanlış bir konumda kullanılmış.                               |


  @positive @subscription
  Scenario: Subscribe with a valid email address
    When User enters a valid email "test@example.com" into the subscription box and submits
    Then Success message "You have been successfully subscribed!" should be visible


  @negative @subscription
  Scenario Outline: Invalid email formats should trigger specific validation messages
    When User enters "<email>" into the subscription box and submits
    Then Browser validation message should be "<expectedMessage>"
    Examples:
      | email            | expectedMessage                                                                            |
      |                  | Lütfen bu alanı doldurun.                                                                  |
      | EMPTY_SPACE      | Lütfen bu alanı doldurun.                                                                  |
      | @gmail.com       | Lütfen başına \"@\" ekleyin. \"@gmail.com\" adresi eksik.                                  |
      | spaces@gmail.com | Lütfen başına \"@\" ekleyin. \"@gmail.com\" adresi eksik.                                  |
      | as.gmail.com     | Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"as.gmail.com\" adresinde \"@\" eksik. |
      | as@@gmail.com    | Başında \"@\" bulunan kısımda \"@\" simgesi bulunmamalıdır.                                |
      | @@gmail.com      | Lütfen başına \"@\" ekleyin. \"@@gmail.com\" adresi eksik.                                 |
      | test@ gmail.com  | Başında \"@\" bulunan kısımda \" \" simgesi bulunmamalıdır.                                |
      | test @gmail.com  | Başında \"@\" bulunan kısımda \" \" simgesi bulunmamalıdır.                                |
      | test@gmail.      | \".\", \"gmail.\" adı içinde yanlış bir konumda kullanılmış.                               |
