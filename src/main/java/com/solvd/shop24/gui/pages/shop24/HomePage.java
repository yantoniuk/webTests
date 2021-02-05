package com.solvd.shop24.gui.pages.shop24;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.shop24.gui.pages.components.shop24.MenuItem;
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
