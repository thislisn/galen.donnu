Feature: GAF cbviewer parameter

  Scenario: cbviewer=none parameter hides navigation
    Given an open browser with GAF url
    When user add '?cbviewer=none' to url
    Then top navigation is not shown

  Scenario: cbviewer=123456 parameter shows navigation
    Given an open browser with GAF url
    When user add '?cbviewer=123456' to url
    Then top navigation is shown

  Scenario: FAILED TEST. Wrong expected conditions cbviewer=none parameter hides navigation
    Given an open browser with GAF url
    When user add '?cbviewer=none' to url
    Then top navigation is shown

  #Currently this test check all links (including external for ?cbviewer=xxx parameter)
  Scenario Outline: All links on the page has parameter inside
    Given an open browser with GAF url
    When user add '<urlParameter>' to url
    Then all links on the page has '<urlParameter>'
    Examples:
      | urlParameter     |
      | ?cbviewer=123456 |
      | ?cbviewer=none   |
