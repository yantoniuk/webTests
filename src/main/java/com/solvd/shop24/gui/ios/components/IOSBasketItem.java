package com.solvd.shop24.gui.ios.components;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.shop24.gui.common.components.purchase.BasketItemBase;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class IOSBasketItem extends AbstractUIObject implements BasketItemBase {

    @FindBy(xpath = ".//a")
    private ExtendedWebElement title;

    public IOSBasketItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getTitle() {
        return title.getText();
    }
}
