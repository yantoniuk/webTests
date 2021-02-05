package com.solvd.carina.demo.gui.pages.shop24;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.pages.components.shop24.MenuItem;
import com.solvd.carina.demo.gui.pages.shop24.profile.AuthorizationPage;
import com.solvd.carina.demo.gui.pages.shop24.profile.ProfilePage;
import com.solvd.carina.demo.gui.pages.shop24.purchase.BasketPage;
import com.solvd.carina.demo.gui.pages.shop24.purchase.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(className = "page-nav")
    private MenuItem menu;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://24shop.by/");
    }

    public MenuItem getMenu() {
        return menu;
    }
}
