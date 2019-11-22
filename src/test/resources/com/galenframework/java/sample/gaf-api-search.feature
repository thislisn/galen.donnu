Feature: GAF search API

  Scenario: Search api results amount is 10 for 1 page
    Given an GAF base url with url to API services
    And request have the following parameters
      | ContentType | products |
      | SearchText  | roof     |
      | PageNo      | 1        |
    When method POST
    Then status 200
    And assert response 'Results.Items' length == 10


  Scenario: Search returns 10 items for products if pageNo parameter is absent
    Given an GAF base url with url to API services
    And request have the following parameters
      | ContentType | products |
      | SearchText  | roof     |
    When method POST
    Then status 200
    And assert response 'Results.Items' length == 10

  Scenario Outline: Each search api results has keyword in title
    Given an GAF base url with url to API services
    And request have the following parameters
      | ContentType | products  |
      | SearchText  | <keyword> |
    When method POST
    Then status 200
    And assert that each search response have '<keyword>' in '<responseCategory>'
    Examples:
      | keyword | responseCategory |
      | roof    | title            |
