Feature: Tutorialsninja website common actions

  @Register
  Scenario: Registering at website
    Given I visit tutorialsninja.com register page from scratch
    When I fill following fields below with following data in table
      | name        | Test                 |
      | surname     | Tester               |
      | email       | atakejimmy@gmail.com |
      | phone       | +1111111111111111    |
      | pass        | Test123$             |
      | passconfirm | Test123$             |
    And I tick privacy policy checkbox
    And I click continue button
    Then I get registered account on website
