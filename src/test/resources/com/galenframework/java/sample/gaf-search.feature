Feature: GAF search scenarios

  Scenario: Search results have related content (keyword is present in each result)
    Given an open browser with GAF base url
    When user searched for roof in search panel
    Then all results products title and description should contain roof
    Then all results pages title and description should contain roof

