Feature:
  Scenario:
    Given The browser is opened
    When The "Dubai Marina" is typed as location
    Then the "sale" option is selected
    When the search button is pressed
    And the list of articles is retrieved and check if all contains "Dubai Marina"
