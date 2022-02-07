package uk.co.acme.hooks;

import javax.inject.Inject;

import cucumber.api.java.After;
import io.magentys.cinnamon.conf.Env;
import uk.co.acme.mission.LandingPageMissions;
import uk.co.acme.pages.EditCompPage;
import uk.co.acme.pages.LandingPage;
import cucumber.api.java.Before;
import uk.co.acme.utils.Utils;

import static io.magentys.cinnamon.webdriver.Browser.open;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class Hooks {

    private final Env env;
    private final LandingPage landingPage;
    private final LandingPageMissions landingPageMissions;
    private final EditCompPage editCompPage;
    private final Utils utils;
    @Inject
    public Hooks(final Env env, final LandingPage landingPage,
                 final LandingPageMissions landingPageMissions,
                 final EditCompPage editCompPage,
                 final Utils utils) {
        this.env = env;
        this.landingPage = landingPage;
        this.landingPageMissions = landingPageMissions;
        this.editCompPage = editCompPage;
        this.utils = utils;
    }

    @Before("@openPage")
    public void openWebSite() throws Throwable {
        open(env.config.getString("base-url"));
        assertThat("Cannot open the website", landingPage.logoTop.waitUntil(displayed).isPresent(), equalTo(true));
    }

}