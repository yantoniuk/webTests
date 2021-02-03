package com.solvd.carina.demo.gui.pages.shop24;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.pages.components.shop24.MenuItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//span[text()='Вход']")
    private ExtendedWebElement authLink;

    @FindBy(className = "page-nav")
    private MenuItem menu;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://24shop.by/");
    }

    public AuthorizationPage authorization(String phoneNumber, String pass) {
        authLink.click();
        AuthorizationPage authorizationPage = new AuthorizationPage(this.driver);
        authorizationPage.typePhoneNumber(phoneNumber);
        authorizationPage.typePassword(pass);
        authorizationPage.submit();
        return authorizationPage;
    }

    public BasketPage showBasket() {
        return menu.showBasket();
    }

    public SearchPage searchProductInSearchField(String name) {
        return menu.searchProductBySearchField(name);
    }

    public SearchPage searchProductInCatalog(String section) {
        return menu.searchProductByCatalog(section);
    }
}
