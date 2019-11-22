Feature: GAF search filtering scenarios

  Scenario: Search categories contain results
    Given an open browser with GAF base url
    When user searched for roof in search panel
    Then amount of results in each filter is > 0
      | products     |
      | documents    |
      | contractors  |
      | distributors |

  Scenario: Search categories contain results one by one
    Given an open browser with GAF base url
    When user searched for roof in search panel
    Then amount of results in filter products is > 0
    Then amount of results in filter documents is > 0
    Then amount of results in filter contractors is > 0
    Then amount of results in filter distributors is > 0
