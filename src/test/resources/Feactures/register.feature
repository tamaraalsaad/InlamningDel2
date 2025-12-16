Feature: User registration

  Scenario Outline: When I fill in the registration form with
    Given I open the register page in <browser>
    When  I fill in the register page form with"<datOfBirth>" "<firstName>" "<lastName>" "<email>" "<confirmEmail>""<password>" "<confirmPassword>" "<acceptTerms>"
    And  I accept the Account Confirmation
    And  I red and accept to (applies to all Members)
    And I submit the registration form
    And I confirm and join
    Then  I should see a success message "A104955"
    Examples:
      | browser | datOfBirth | firstName | lastName | email                | confirmEmail         | password | confirmPassword | acceptTerms |
      | chrome  | 09/01/1978 | Tamra     | Alsaad   | tamara@test.se       | tamara@test.se       | 123456   | 123456          | true        |
      | edge    | 19/05/2012 | Josef     | Ataiwi   | josef.ataiwi@test.se | josef.ataiwi@test.se | 120519   | 120519          | true        |

  Scenario: missing_lastname

    And I submit the registration form
    Then I should see an error message "Last name is required"

  Scenario:password_mismatch

    And I submit the registration form
    Then  I should see an error message "Passwords do not match"

  Scenario: not_accepted

    And I submit the registration form
    Then I should see an error message "You must accept terms and conditions"