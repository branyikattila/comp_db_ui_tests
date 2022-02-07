@openPage
Feature: CRUD functions - Gatling Comp DB

  @complete @deleteEntryData1
  Scenario: Create entry
    When I add a new entry
    Then I should see the successful message

  @complete
  Scenario: Update entry
    When I search for existing entry
    And I update the entry
    Then I can see the entry changed

  @complete
  Scenario: Delete entry
    When I search for existing entry
    And I delete the entry
    Then I see delete entry was successful