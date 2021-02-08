package com.solvd.shop24.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.shop24.gui.components.MenuItem;
import com.solvd.shop24.gui.components.constant.ComponentLocatorsConstants;
import com.solvd.shop24.gui.pages.profile.AuthenticationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(className = "page-nav")
    private MenuItem menu;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageURL("/");
    }

    @Override
    public boolean isPageOpened() {
        return menu.isUIObjectPresent();
    }

    public MenuItem getMenu() {
        return menu;
    }

    public AuthenticationPage navigateToAuthentificationPage() {
        findExtendedWebElement(ComponentLocatorsConstants.LOG_IN_LINK).click();
        return new AuthenticationPage(this.driver);
    }
}
