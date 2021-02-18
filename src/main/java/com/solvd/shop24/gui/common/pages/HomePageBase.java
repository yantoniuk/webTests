package com.solvd.shop24.gui.common.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.shop24.gui.common.components.MenuItem;
import com.solvd.shop24.gui.common.components.MenuItemBase;
import com.solvd.shop24.gui.ios.components.IOSMenuItem;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.MobileContextUtils;

import java.net.MalformedURLException;
import java.net.URL;


public abstract class HomePageBase extends AbstractPage {

    @FindBy(className = "page-nav")
    private MenuItem menu;

    @FindBy(xpath="//*[@name='banner']")
    private IOSMenuItem iosMenu;

    public HomePageBase(WebDriver driver) {
        super(driver);
        if (R.CONFIG.get("platform").equals("iOS")) {
            new MobileContextUtils().switchMobileContext(MobileContextUtils.View.NATIVE);
        }
    }

    public MenuItemBase getMenu() {
        if (R.CONFIG.get("platform").equals("iOS")) {
            return iosMenu;
        }
        return this.menu;
    }

    @Override
    public boolean isPageOpened() {
        return getMenu().isUIObjectPresent();
    }
}
