@openPage
Feature: CRUD functions - Gatling Comp DB

  @complete @deleteEntryData1
  Scenario: Create entry
    When I add a new entry "1"
    Then I should see the successful message for profile "1"

  @complete
  Scenario: Update entry
    When I search for existing entry "3"
    And I update the entry with profile "4"
    Then I can see the entry changed for profile "4"

  @complete
  Scenario: Delete entry
    When I search for existing entry "3"
    And I delete the entry
    Then I see delete entry was successful for profile "3"