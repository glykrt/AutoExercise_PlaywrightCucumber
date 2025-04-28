Feature: Login Functionality

  Background:
    Given The user clicks on the Signup-Login button

  @positive
  Scenario: Valid login and logout
    When The user logs in with valid credentials
    Then Logged in as username should be visible
    When User clicks on Logout button
    Then Signup-Login button should be visible again

  @positive
  Scenario Outline: Valid login and delete account
    When User enters email "<email>" and password "<password>"
    Then Logged in as username should be visible
    When User clicks on delete account button
    Then Signup-Login button should be visible again
    Examples:
      | email         | password |
      | a.s@gmail.com | as12345  |

  @negative
  Scenario Outline: Browser native popup validation
    When User enters email "<email>" and password "<password>"
    Then Browser validation message for field "<field>" should be "<expectedMessage>"
    Examples:
      | email            | password  | field    | expectedMessage                                                                        |
      |                  | test12345 | email    | Lütfen bu alanı doldurun.                                                              |
      | test@example.com |           | password | Lütfen bu alanı doldurun.                                                              |
      |                  |           | email    | Lütfen bu alanı doldurun.                                                              |
      | invalid          | test12345 | email    | Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"invalid\" adresinde \"@\" eksik.  |
      | invalid@         | test12345 | email    | Lütfen \"@\" işaretinden sonra gelen kısmı ekleyin. \"invalid@\", tam bir adres değil. |
      | !%&+/()=         | test12345 | email    | Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"!%&+/()=\" adresinde \"@\" eksik. |
      | EMPTY_SPACE      | test12345 | email    | Lütfen bu alanı doldurun.                                                              |

  @negative  @login
  Scenario Outline: Invalid login attempts
    When User enters email "<email>" and password "<password>"
    Then Error message "Your email or password is incorrect!" should be visible
    Examples:
      | email            | password    |
      | test@example.com | test12345   |
      | test@example.com | EMPTY_SPACE |

