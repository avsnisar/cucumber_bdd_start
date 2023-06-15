@HotlineAll
Feature: Feature of working as a shop at Hotline

  @ShopFormEmpty
  Scenario: Going to registration form for a new shop
    Given I visit hotline.ua main page
    When I navigate to hotline.ua form page
    And I click on form initiation button
    Then I should be taken to step 1 of the form
    And form fields should be blank except for radio buttons
    And submit button should be enabled

  @ShopEmptyTry
  Scenario: Filling registration form for a new shop
    Given I step 1 form page loaded
    When I do not fill all empty fields
    And I click on form submit button
    Then I should stay on the form
    And Validation errors should be displayed for invalidly filled fields
