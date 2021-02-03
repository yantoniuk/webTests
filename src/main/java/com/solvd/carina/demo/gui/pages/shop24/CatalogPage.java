package com.solvd.carina.demo.gui.pages.shop24;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends HomePage {

    @FindBy(xpath = "//div[@class='list-block js-accordion__body']//span")
    private List<ExtendedWebElement> catalogItems;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }
}
