Feature: My first feature
  Scenario: I want to create new pet
    Given I have pet details
    When I create pet
    Then Pet is created

  Scenario Outline: I want to get the pet with status as "<status>"
    Given pets are available
    When I get the pet with status as "<status>"
    Then I get the list of pets with the status as "<status>"

    Examples:
    |status|
    |sold  |
    |available|