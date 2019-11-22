Feature: GAF page layout verification

  @RunTest
  Scenario Outline: Verification of layout on the EN
    Given open local browser with url:
      | locale     | EN              |
      | url        | student-council |
      | domain     | MAIN            |
      | resolution | <resolution>    |
    Then layout suite rules is satisfied:
      | device | <device>      |
      | spec   | studRada_main |
    Examples:
      | resolution | device  |
      | 450x800    | mobile  |
      | 750x800    | tablet  |
      | 1280x800   | desktop |

  @RunTest
  Scenario Outline: Verification of layout on the UA
    Given open local browser with url:
      | locale     | UA              |
      | url        | studentska-rada |
      | domain     | MAIN            |
      | resolution | <resolution>    |
    Then layout suite rules is satisfied:
      | device | <device>      |
      | spec   | studRada_main |
    Examples:
      | resolution | device  |
      | 450x800    | mobile  |
      | 750x800    | tablet  |
      | 1280x800   | desktop |