Feature: Logging in to website applications
  
  More description goes here
  Here too

  #Scenario was converted to an outline with test data
  #Scenario: User should only be able to log in with valid credentials
  @baby
  Scenario Outline: User should only be able to log in with valid credentials
    Given I navigate to omayo blogsport website
    When I enter username as "<username>" and password as <password>
    And I click on login button
    Then User should login based on expected "<login>" status

    Examples: 
      | username      | password | login   |
      | wtf           |          | failure |
      | SeleniumByAru | Test143$ | success |
