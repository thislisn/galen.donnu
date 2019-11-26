Feature: page science about local layout verification

  @RunTest
  Scenario Outline: Verification of layout science about EN
    Given open local browser with url:
      | locale     | EN           |
      | url        | about-donnu  |
      | domain     | SCIENCE      |
      | resolution | <resolution> |
    Then about science header is visible
    And layout suite rules is satisfied:
      | device | <device>      |
      | spec   | about_science |
    Examples:
      | resolution | device  |
      | 450x800    | mobile  |
      | 750x800    | tablet  |
      | 1280x800   | desktop |

  @RunTest
  Scenario Outline: Verification of layout sciemce about UA
    Given open local browser with url:
      | locale     | UA           |
      | url        | pro-donnu    |
      | domain     | SCIENCE      |
      | resolution | <resolution> |
    Then about science header is visible
    And layout suite rules is satisfied:
      | device | <device>      |
      | spec   | about_science |
    Examples:
      | resolution | device  |
      | 450x800    | mobile  |
      | 750x800    | tablet  |
      | 1280x800   | desktop |