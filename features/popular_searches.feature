Feature:
  Scenario Outline:
    Given The browser is opened
    When The user scrolls down to popular searches
    Then the popular searches are visible to the user
    When the user clicks on rent button
    And the popular searches are expanded
    When the user clicks on the <linkName> search link
    And the list of articles is retrieved and check if all contains <expectedName>
    Then the browser is closed

    Examples:
    |linkName                       |expectedName                     |
    |"Dubai Marina"                 |"Dubai Marina"                   |
    |"Jumeirah Village Circle"      |"Jumeirah Village Circle"        |
    |"Jumeirah Lake Towers"         |"Jumeirah Lake Towers"           |
    |"Downtown Dubai"               |"Downtown Dubai"                 |
    |"Business Bay"                 |"Business Bay"                   |
    |"Palm Jumeirah"                |"Palm Jumeirah"                  |
    |"Dubai Sports City"            |"Dubai Sports City"              |
    |"Jumeirah Beach Residence"     |"Jumeirah Beach Residence"       |
    |"The Greens"                   |"The Greens"                     |
    |"Dubai Silicon Oasis"          |"Dubai Silicon Oasis"            |
    |"Motor City"                   |"Motor City"                     |
    |"Green Community"              |"Green Community"                |
    |"Dubai Production City - IMPZ" |"Dubai Production City (IMPZ)"   |