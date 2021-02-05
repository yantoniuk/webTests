package com.solvd.shop24.gui.pages.components.shop24.purchase;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BasketItem extends AbstractUIObject {

    @FindBy(xpath = ".//a")
    private ExtendedWebElement title;

    public BasketItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        return title.getText();
    }
}
