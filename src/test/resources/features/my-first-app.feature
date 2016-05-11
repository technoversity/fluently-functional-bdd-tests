Feature: Search for a query on Google home page

  Scenario Outline: As a user I can search for cucumber JVM and get to cucumber home page
    Given I am on Google home page
    When I enter the query <TEXT> and submit page
    And I click the first link on the results page
    Then I see the cucumber home page with title <PAGE_TITLE>

    Examples:
      | TEXT         | PAGE_TITLE |
      | cucumber bdd | Cucumber   |


