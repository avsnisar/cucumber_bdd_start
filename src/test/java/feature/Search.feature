#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Background: List of steps run before each of the scenarios
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for steps table
#Given: Some precondition step
#When: Some key actions
#And,But: To enumerate more Given,When,Then steps
#Then: To observe outcomes or validation
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
#Feature: Title of your feature
  #I want to use this template for my feature file
#
  #@tag1
  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes
#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
Feature: Search of products within https://www.amazon.com/ using menu

Background: Opening browser and navigating to website
Given I visit website as unregistered user

@books
Scenario: Unregistered serfer should be able to search books in selected category
When I select the Books option from the categories dropdown
And I clik on search icon option
Then I should see the books main page having heading as Best sellers
But I should not see other categories products

@baby @~ignore
Scenario: Unregistered serfer should be able to search baby products in selected category
When I select the Baby option from the categories dropdown
And I clik on search icon option
Then I should see the baby products main page having heading as The Baby Store
But I should not see other categories products