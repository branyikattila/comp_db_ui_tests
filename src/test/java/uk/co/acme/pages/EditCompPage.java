package uk.co.acme.pages;

import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.support.FindBy;

import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;

public class EditCompPage {


    @FindBy(xpath = "//*[@id=\"main\"]/form[2]/input")
    public PageElement deleteBtn;


    public EditCompPage clickDeleteBtn () {
        deleteBtn.waitUntil(displayed.and(enabled)).click();
        return this;
    }



}
