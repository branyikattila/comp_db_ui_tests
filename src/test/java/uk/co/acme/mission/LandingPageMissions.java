package uk.co.acme.mission;

import io.magentys.cinnamon.webdriver.elements.PageElement;
import uk.co.acme.pages.LandingPage;
import uk.co.acme.testData.TestData;

import javax.inject.Inject;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;

public class LandingPageMissions {

    private final LandingPage landingPage;
    private final TestData testData;

    @Inject
    public LandingPageMissions(final LandingPage landingPage,
                               final TestData testData) {
        this.landingPage = landingPage;
        this.testData = testData;
    }

    public LandingPageMissions filterByName(String name) {
        landingPage.fillInSearchInput(name).clickSearchSubmit();
        return this;
    };

    public LandingPageMissions selectByNameFromResult(String name) {
        getElementByName(name).waitUntil(displayed.and(enabled)).click();
        return this;
    }


    public PageElement getElementByName(String name) {
        PageElement[] elements = new PageElement[]{landingPage.firstCompName, landingPage.secondCompName, landingPage.thirdCompName,
        landingPage.fourthCompName, landingPage.fifthCompName, landingPage.sixthCompName};
        PageElement result = null;
        for (PageElement element:  elements) {
            if (element.getText().equals(name)) {
                result = element;
            }
        }
        return result;
    }




}
