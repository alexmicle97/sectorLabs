Feature:
  Scenario Outline:
    Given The browser is opened
    When The user scrolls down to popular searches
    Then the popular searches are visible to the user
    When the user clicks on rent button
    When the user clicks on the <linkName> search link
    And the list of articles is retrieved and check if all contains <expectedName>
    Then the browser is closed

    Examples:
    |linkName                         |expectedName                     |
    |"Dubai Marina"                   |"Dubai Marina"                   |
    |"Jumeirah Village Circle"        |"Jumeirah Village Circle"        |
    |"Al Raha Gardens"                |"Al Raha Gardens"                |
    |"Ajman"                          |"Ajman"                          |
    |"Abu Dhabi properties for rent"  |"Abu Dhabi "                      |