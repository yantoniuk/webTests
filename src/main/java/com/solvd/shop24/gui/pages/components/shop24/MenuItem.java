package com.solvd.shop24.gui.pages.components.shop24;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.shop24.gui.pages.components.shop24.constant.LocatorsConstants;
import com.solvd.shop24.gui.pages.shop24.news.NewsPage;
import com.solvd.shop24.gui.pages.shop24.profile.AuthorizationPage;
import com.solvd.shop24.gui.pages.shop24.profile.ProfilePage;
import com.solvd.shop24.gui.pages.shop24.purchase.BasketPage;
import com.solvd.shop24.gui.pages.shop24.purchase.SearchPage;
import com.solvd.shop24.gui.pages.shop24.purchase.SectionsCatalogPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenuItem extends AbstractUIObject {

    @FindBy(xpath = "//span[text()='Вход']")
    private ExtendedWebElement authLink;

    @FindBy(className = "catalog-btn__txt")
    private ExtendedWebElement catalogMenu;

    @FindBy(xpath = ".//div[@class='top-search__input-block']/input")
    private ExtendedWebElement searchInputField;

    @FindBy(css = "ul.cat_nav > li > a")
    private List<ExtendedWebElement> catalogItems;

    @FindBy(xpath = "//span[@class='page-header-bottom-btn__txt']")
    private ExtendedWebElement basketMenuButton;

    @FindBy(linkText = "Новости")
    private ExtendedWebElement newsLink;

    public MenuItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public BasketPage showBasket() {
        basketMenuButton.click();
        findExtendedWebElement(LocatorsConstants.BASKET_BUTTON).click();
        return new BasketPage(this.driver);
    }

    public SearchPage searchProductBySearchField(String name) {
        searchInputField.type(name);
        searchInputField.sendKeys(Keys.ENTER);
        return new SearchPage(this.driver);
    }

    public void openCatalogMenu() {
        catalogMenu.click();
    }

    public SectionsCatalogPage searchProductByCatalog(String type) {
        catalogItems.stream().filter(elem-> elem.getAttribute("text").equals(type)).findAny().get().click();
        return new SectionsCatalogPage(this.driver);
    }

    public int catalogItemsCount() {
        return catalogItems.size();
    }

    public String getSearchInputFieldText() {
        return searchInputField.getAttribute("value");
    }

    public NewsPage openNews() {
        newsLink.click();
        return new NewsPage(this.driver);
    }

    public ProfilePage authorization(String phoneNumber, String pass) {
        authLink.click();
        AuthorizationPage authorizationPage = new AuthorizationPage(this.driver);
        authorizationPage.typePhoneNumber(phoneNumber);
        authorizationPage.typePassword(pass);
        return authorizationPage.submit();
    }

    public boolean isCatalogMenuOpened() {
        return findExtendedWebElement(LocatorsConstants.OPENED_CATALOG_MENU).isPresent();
    }
}
