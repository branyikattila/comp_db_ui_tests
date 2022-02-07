package uk.co.acme.pages;

import io.magentys.cinnamon.webdriver.collections.PageElementCollection;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import io.magentys.cinnamon.webdriver.support.FindByKey;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;

public class LandingPage {

    @FindBy(xpath = "/html/body/header/h1/a")
    public PageElement logoTop;

    @FindBy(id = "add")
    public PageElement addButton;

    @FindBy(id = "searchbox")
    public PageElement searchInput;

    @FindBy(id = "searchsubmit")
    public PageElement searchSubmit;

    @FindBy(xpath = "//*[@id=\"main\"]/table/tbody")
    public PageElementCollection resultTable;

    @FindBy(xpath = "//*[@id=\"main\"]/table/tbody/tr[1]/td[1]/a")
    public PageElement firstCompName;

    @FindBy(xpath = "//*[@id=\"main\"]/table/tbody/tr[2]/td[1]/a")
    public PageElement secondCompName;

    @FindBy(xpath = "//*[@id=\"main\"]/table/tbody/tr[3]/td[1]/a")
    public PageElement thirdCompName;

    @FindBy(xpath = "//*[@id=\"main\"]/table/tbody/tr[4]/td[1]/a")
    public PageElement fourthCompName;

    @FindBy(xpath = "//*[@id=\"main\"]/table/tbody/tr[5]/td[1]/a")
    public PageElement fifthCompName;

    @FindBy(xpath = "//*[@id=\"main\"]/table/tbody/tr[6]/td[1]/a")
    public PageElement sixthCompName;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]")
    public PageElement message;

    public String getMessage() {
        return message.waitUntil(displayed).getText();
    }

    public LandingPage fillInSearchInput(String name) {
        searchInput.waitUntil(displayed.and(enabled)).fillIn(name);
        return this;
    }

    public LandingPage clickSearchSubmit() {
        searchSubmit.waitUntil(displayed.and(enabled)).click();
        return this;
    }

    public LandingPage clickAddButton() {
        addButton.waitUntil(displayed.and(enabled)).click();
        return this;
    }

}