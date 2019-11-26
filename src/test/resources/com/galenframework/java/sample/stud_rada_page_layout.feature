Feature: page stud rada local layout verification

  @RunTest
  Scenario Outline: Verification of layout stud rada EN
    Given open local browser with url:
      | locale     | EN              |
      | url        | student-council |
      | domain     | MAIN            |
      | resolution | <resolution>    |
    Then stud rada header is visible
    And layout suite rules is satisfied:
      | device | <device>      |
      | spec   | studRada_main |
    Examples:
      | resolution | device  |
      | 450x800    | mobile  |
      | 750x800    | tablet  |
      | 1280x800   | desktop |

  @RunTest
  Scenario Outline: Verification of layout stud rada UA
    Given open local browser with url:
      | locale     | UA              |
      | url        | studentska-rada |
      | domain     | MAIN            |
      | resolution | <resolution>    |
    Then stud rada header is visible
    And layout suite rules is satisfied:
      | device | <device>      |
      | spec   | studRada_main |
    Examples:
      | resolution | device  |
      | 450x800    | mobile  |
      | 750x800    | tablet  |
      | 1280x800   | desktop |