Feature: GAF page comparator


  # GAFSTCR-2519
  # Create tests to make navigation in GAF website UAT and compare that with GAF website on PRODUCTION
  Scenario Outline: The text on websites and Production environment is the same
    Given an open browser with GAF base url
    Then all text on the '<pageLink>' page is the same as on page on Production
    Examples:
      | pageLink                                   |
      | /#                                         |
      | /for-homeowners                            |
      | /commercial-roofing/professional-resources |
      | /residential-roofing/decotech              |
      | /our-company                               |

  # GAFSTCR-2519
  Scenario Outline: The links on websites and Production environment is the same
    Given an open browser with GAF base url
    Then all links on the '<pageLink>' page is the same as on page on Production
    Examples:
      | pageLink                                   |
      | /#                                         |
      | /for-homeowners                            |
      | /commercial-roofing/professional-resources |
      | /residential-roofing/decotech              |
      | /our-company                               |
