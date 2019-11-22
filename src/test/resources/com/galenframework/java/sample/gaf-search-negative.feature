Feature: GAF search negative scenarios

  Scenario: Search button is not active for empty query
    Given an open browser with GAF base url
    When search panel is opened
    Then the Search button is not active

  Scenario: No results message is shown for senseless query
    Given an open browser with GAF base url
    When user searched for asdqweasdqwe in search panel
    Then message that there are no results should be shown

