package com.solvd.shop24.gui.common.pages.purchase;

import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.desktop.pages.constant.PageLocatorsConstants;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends HomePageBase {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getTitle();

    public abstract String getPrice();

    public abstract String getDescription();

    public abstract void addToBasket();

    public abstract boolean isItemAddedToBasket();
}
