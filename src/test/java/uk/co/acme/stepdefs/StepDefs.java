package uk.co.acme.stepdefs;

import javax.inject.Inject;

import cucumber.api.java.en.When;
import uk.co.acme.mission.LandingPageMissions;
import uk.co.acme.pages.AddACompPage;
import uk.co.acme.pages.EditCompPage;
import uk.co.acme.pages.LandingPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import cucumber.api.java.en.Then;
import uk.co.acme.testData.TestData;

public class StepDefs {

    private final LandingPage landingPage;
    private final AddACompPage addACompPage;
    private final EditCompPage editCompPage;
    private final TestData testData;
    private final LandingPageMissions landingPageMissions;


    @Inject
    public StepDefs(final LandingPage landingPage,
                    final AddACompPage addACompPage,
                    final TestData testData,
                    final LandingPageMissions landingPageMissions,
                    final EditCompPage editCompPage) {
        this.landingPage = landingPage;
        this.addACompPage = addACompPage;
        this.testData = testData;
        this.landingPageMissions = landingPageMissions;
        this.editCompPage = editCompPage;
    }

    @When("^I add a new entry$")
    public void i_add_a_new_entry() throws Throwable {
        landingPage.clickAddButton();
        addACompPage.fillInCreateForm(testData.getTestDataByFieldName(testData.test_data1));

        //TODO: REmove from final
        //addACompPage.clickCancelButon();

        addACompPage.clickCreateButton();
    }

    @When("I search for existing entry")
    public void i_search_for_existing_entry() {
        String name = testData.getTestDataByFieldName(testData.test_data2).get("Name");
        landingPageMissions.filterByName(name).selectByNameFromResult(name);
    }

    @When("I update the entry")
    public void i_update_the_entry() {
        addACompPage.fillInCreateForm(testData.getTestDataByFieldName(testData.test_data3));
        addACompPage.clickCreateButton();
    }

    @When("I delete the entry")
    public void i_delete_the_entry() {
        editCompPage.clickDeleteBtn();
        System.out.println(" wasdbwf ");
    }

    @Then("I see delete entry was successful")
    public void i_see_delete_entry_was_successful() {
        assertThat("The update of the entry failed.", landingPage.getMessage(),
                equalTo("Done ! Computer " +
                        testData.getTestDataByFieldName(testData.test_data2).get("Name") + " has been deleted"));
    }

    @Then("I can see the entry changed")
    public void i_can_see_the_entry_changed() {
        assertThat("The update of the entry failed.", landingPage.getMessage(),
                equalTo("Done ! Computer " +
                        testData.getTestDataByFieldName(testData.test_data3).get("Name") + " has been updated"));
    }

    @Then("^I should see the successful message$")
    public void i_should_see_the_successful_message() throws Throwable {
        assertThat("The creation of the entry failed.", landingPage.getMessage(),
                equalTo("Done ! Computer " +
                testData.getTestDataByFieldName(testData.test_data1).get("Name") + " has been created"));
    }

}