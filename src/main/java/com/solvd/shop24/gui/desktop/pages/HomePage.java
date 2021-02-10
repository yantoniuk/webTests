package com.solvd.shop24.gui.desktop.pages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.components.MenuItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(className = "page-nav")
    private MenuItem menu;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL("/");
    }

    @Override
    public boolean isPageOpened() {
        return getMenu().isUIObjectPresent();
    }
}
