package com.solvd.shop24.gui.common.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.shop24.gui.common.components.MenuItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public abstract class HomePageBase extends AbstractPage {

    @FindBy(className = "page-nav")
    private MenuItem menu;

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public MenuItem getMenu() {
        return this.menu;
    }
}
