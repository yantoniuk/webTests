package com.solvd.shop24.gui.common.components;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.shop24.gui.common.components.MenuItemBase;
import com.solvd.shop24.gui.common.constants.LocatorConstants;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.pages.news.NewsPageBase;
import com.solvd.shop24.gui.common.pages.profile.AuthenticationPageBase;
import com.solvd.shop24.gui.common.pages.purchase.BasketPageBase;
import com.solvd.shop24.gui.common.pages.purchase.ProductsCatalogPageBase;
import com.solvd.shop24.gui.common.pages.purchase.SearchPageBase;
import com.solvd.shop24.gui.desktop.components.constant.ComponentLocatorsConstants;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenuItem extends AbstractUIObject implements ICustomTypePageFactory, MenuItemBase {

    @FindBy(className = "catalog-btn__txt")
    private ExtendedWebElement catalogMenu;

    @FindBy(css = "ul.cat_nav > li > a")
    private List<ExtendedWebElement> catalogItems;

    @FindBy(xpath = "//div[contains(@class, 'small-basket-holder')]/a")
    private ExtendedWebElement basketMenuButton;

    @FindBy(xpath = "//span[text()='Меню']")
    private ExtendedWebElement menuLink;

    public MenuItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public MenuItem(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isUIObjectPresent() {
        return basketMenuButton.isClickable() && catalogMenu.isPresent();
    }

    public BasketPageBase showBasket() {
        basketMenuButton.click();
        findExtendedWebElement(ComponentLocatorsConstants.BASKET_BUTTON).click();
        return initPage(this.driver, BasketPageBase.class);
    }

    public SearchPageBase searchProductBySearchField(String name) {
        if (R.CONFIG.get("platform").equals("android")) {
            findExtendedWebElement(LocatorConstants.SEARCH_ICON).click();
        }
        findExtendedWebElement(LocatorConstants.SEARCH_INPUT).type(name + Keys.ENTER);
        return initPage(this.driver, SearchPageBase.class);
    }

    public ProductsCatalogPageBase searchProductByCatalog(String type, String subType) {
        if (R.CONFIG.get("platform").equals("android")) {
            catalogMenu.click();
            catalogItems.stream().filter(elem-> elem.getAttribute("text").equals(type)).findAny().get().click();
        } else {
            catalogMenu.hover();
            catalogItems.stream().filter(elem -> elem.getAttribute("text").equals(type)).findAny().get().hover();
        }
        findExtendedWebElement(new By.ByLinkText(subType)).click();
        return initPage(this.driver, ProductsCatalogPageBase.class);
    }

    public int catalogItemsCount() {
        return catalogItems.size();
    }

    public String getSearchInputFieldText() {
        return findExtendedWebElement(LocatorConstants.SEARCH_INPUT).getAttribute("value");
    }

    public NewsPageBase openNews() {
        if (R.CONFIG.get("platform").equals("android")) {
            menuLink.click();
            findExtendedWebElement(LocatorConstants.NEWS_LINK).click();
        }
        else {
            findExtendedWebElement(new By.ByLinkText("Новости")).click();
        }
        return initPage(this.driver, NewsPageBase.class);
    }

    public AuthenticationPageBase navigateToAuthenticationPage() {
        findExtendedWebElement(ComponentLocatorsConstants.LOG_IN_LINK).click();
        return initPage(this.driver, AuthenticationPageBase.class);
    }
}
