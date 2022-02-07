package uk.co.acme.pages;

import io.magentys.cinnamon.webdriver.elements.PageElement;
import io.magentys.cinnamon.webdriver.support.FindByKey;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;

public class AddACompPage {

        @FindBy(id = "name")
        public PageElement compName;

        @FindBy(id = "introduced")
        public PageElement introduced;

        @FindBy(id = "discontinued")
        public PageElement discontinued;

        @FindBy(id = "company")
        public PageElement company;

        @FindBy(xpath = "//*[@id=\"main\"]/form/div/input")
        public PageElement createButton;

        @FindBy(xpath = "//*[@id=\"main\"]/form/div/a")
        public PageElement cancelButton;

        public AddACompPage clickCancelButon ()  {
            cancelButton.waitUntil(displayed.and(enabled)).click();
            return this;
        }

        public AddACompPage clickCreateButton () {
            createButton.waitUntil(displayed.and(enabled)).click();
            return this;
        }

        public AddACompPage fillInCreateForm(HashMap<String, String> data) {
            compName.waitUntil(displayed.and(enabled)).clear();
            compName.fillIn(data.get("Name"));
            introduced.waitUntil(displayed.and(enabled)).clear();
            introduced.fillIn(data.get("Introduced"));
            discontinued.waitUntil(displayed.and(enabled)).clear();
            discontinued.fillIn(data.get("Discontinued"));
            company.select().byVisibleText(data.get("Company"));
            return this;
        }
}
