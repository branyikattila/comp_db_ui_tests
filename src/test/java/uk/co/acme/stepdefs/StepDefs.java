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
import uk.co.acme.utils.Utils;

public class StepDefs {

    private final LandingPage landingPage;
    private final AddACompPage addACompPage;
    private final EditCompPage editCompPage;
    private final LandingPageMissions landingPageMissions;
    private final Utils utils;


    @Inject
    public StepDefs(final LandingPage landingPage,
                    final AddACompPage addACompPage,
                    final LandingPageMissions landingPageMissions,
                    final EditCompPage editCompPage,
                    final Utils utils) {
        this.landingPage = landingPage;
        this.addACompPage = addACompPage;
        this.landingPageMissions = landingPageMissions;
        this.editCompPage = editCompPage;
        this.utils = utils;
    }

    @When("I add a new entry {string}")
    public void i_add_a_new_entry(String profile) throws Throwable {
        landingPage.clickAddButton();
        addACompPage.fillInCreateForm(utils.getTestDataById(profile));
        addACompPage.clickCreateButton();
    }


    @When("I search for existing entry {string}")
    public void i_search_for_existing_entry(String profile) throws Throwable {
        String name = utils.getTestDataById(profile).getName();
        landingPageMissions.filterByName(name).selectByNameFromResult(name);
    }

    @When("I update the entry with profile {string}")
    public void i_update_the_entry_with_profile(String profile) throws Throwable {
        addACompPage.fillInCreateForm(utils.getTestDataById("4"));
        addACompPage.clickCreateButton();
    }


    @When("I delete the entry")
    public void i_delete_the_entry() {
        editCompPage.clickDeleteBtn();
    }

    @Then("I see delete entry was successful for profile {string}")
    public void i_see_delete_entry_was_successful_for_profile(String profile) throws Throwable {
        assertThat("The update of the entry failed.", landingPage.getMessage(),
                equalTo("Done ! Computer " +
                        utils.getTestDataById(profile).getName() + " has been deleted"));
    }


    @Then("I can see the entry changed for profile {string}")
    public void i_can_see_the_entry_changed_for_profile(String profile) throws Throwable {
        assertThat("The update of the entry failed.", landingPage.getMessage(),
                equalTo("Done ! Computer " +
                        utils.getTestDataById(profile).getName() + " has been updated"));
    }

    @Then("^I should see the successful message$")
    public void i_should_see_the_successful_message() throws Throwable {
        assertThat("The creation of the entry failed.", landingPage.getMessage(),
                equalTo("Done ! Computer " +
                        utils.getTestDataById("1").getName()+ " has been created"));
    }
    @Then("I should see the successful message for profile {string}")
    public void i_should_see_the_successful_message_for_profile(String profile) throws Throwable {
        assertThat("The creation of the entry failed.", landingPage.getMessage(),
                equalTo("Done ! Computer " +
                        utils.getTestDataById(profile).getName()+ " has been created"));
    }


}