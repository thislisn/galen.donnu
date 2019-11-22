Feature: GAF header and footer

  #GAFSTCR-2518
  # Create tests to verify that header is shown and have correct links (Logo, Main menu links, Search icon)
  Scenario: Website header has logo on the top
    Given an open browser with GAF base url
    Then header has logo shown

  Scenario: Website header has search button on the top
    Given an open browser with GAF base url
    Then header has search button shown

  Scenario Outline: Header has correct links
    Given an open browser with GAF base url
    Then header has '<menuItemTitle>' that link to '<url>'
    Examples:
      | menuItemTitle     | url                                              |
      | Roofing Products  | #                                                |
      | For Homeowners    | /en-us/for-homeowners                            |
      | For Professionals | /en-us/commercial-roofing/professional-resources |
      | Solar             | /en-us/residential-roofing/decotech              |
      | Our Company       | /en-us/our-company                               |


# Create tests to verify that footer is shown and have correct links (Roofing Products... Careers;
# Press & Media... Privacy Policy)
  Scenario Outline: Footer has correct links
    Given an open browser with GAF base url
    Then footer has '<menuItemTitle>' that link to '<url>'
    Examples:
      | menuItemTitle     | url                                                 |
      | Roofing Products  | /en-us                                              |
      | For Homeowners    | /en-us/for-homeowners                               |
      | For Professionals | /en-us/commercial-roofing/professional-resources    |
      | Roof Design       | /en-us/roof-design/style-guide                      |
      | Our Company       | /en-us/our-company                                  |
      | Careers           | /en-us/our-company/careers                          |
      | Press & Media     | /en-us/our-company/news-and-press-releases          |
      | Terms Of Use      | /en-us/our-company/privacy-and-legal/terms-of-use   |
      | Privacy Policy    | /en-us/our-company/privacy-and-legal/privacy-policy |