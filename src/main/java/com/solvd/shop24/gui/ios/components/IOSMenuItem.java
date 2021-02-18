package com.solvd.shop24.gui.ios.components;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.shop24.gui.common.components.MenuItemBase;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.pages.news.NewsPageBase;
import com.solvd.shop24.gui.common.pages.profile.AuthenticationPageBase;
import com.solvd.shop24.gui.common.pages.purchase.BasketPageBase;
import com.solvd.shop24.gui.common.pages.purchase.ProductsCatalogPageBase;
import com.solvd.shop24.gui.common.pages.purchase.SearchPageBase;
import com.solvd.shop24.gui.desktop.components.constant.ComponentLocatorsConstants;
import com.solvd.shop24.gui.ios.constants.IOSLocatorConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import utils.MobileContextUtils;

import java.util.List;

public class IOSMenuItem extends AbstractUIObject implements MenuItemBase, ICustomTypePageFactory, IMobileUtils {

    @ExtendedFindBy(iosPredicate = "name = 'КАТАЛОГ'")
    private ExtendedWebElement catalogMenu;

    @FindBy(css = "button.top-search-mobile__btn")
    private ExtendedWebElement searchIcon;

    @FindBy(css="div.small-basket-holder > a")
    private ExtendedWebElement basketButton;

    @FindBy(name = "q")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "name = 'Меню'")
    @Predicate
    private ExtendedWebElement menuLink;

    @FindBy(xpath = "type = 'XCUIElementTypeLink' AND name = 'Новости'")
    @Predicate
    public ExtendedWebElement newsLink;

    public IOSMenuItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public IOSMenuItem(WebDriver driver) {
        super(driver);
    }

    @Override
    public AuthenticationPageBase navigateToAuthenticationPage() {
        findExtendedWebElement(IOSLocatorConstants.SIGN_IN_LINK).click();
        return initPage(this.driver, AuthenticationPageBase.class);
    }

    @Override
    public boolean isUIObjectPresent() {
        return menuLink.isPresent();
    }

    @Override
    public BasketPageBase showBasket() {
        new MobileContextUtils().switchMobileContext(MobileContextUtils.View.WEB);
        basketButton.click();
        findExtendedWebElement(ComponentLocatorsConstants.BASKET_BUTTON).click();
        return initPage(this.driver, BasketPageBase.class);
    }

    public SearchPageBase searchProductBySearchField(String name) {
        new MobileContextUtils().switchMobileContext(MobileContextUtils.View.WEB);
        searchIcon.click();
        searchField.type(name);
        searchField.sendKeys(Keys.ENTER);
        return initPage(this.driver, SearchPageBase.class);
    }

    @Override
    public ProductsCatalogPageBase searchProductByCatalog(String type, String subType) {
       this.driver.findElements(By.cssSelector(IOSLocatorConstants.CATALOG_ITEMS))
                .stream().filter(elem-> elem.getText().equals(type)).findAny().get().click();
        findExtendedWebElement(By.linkText(subType)).click();
        return initPage(this.driver, ProductsCatalogPageBase.class);
    }

    @Override
    public int catalogItemsCount() {
        catalogMenu.hover();
        new MobileContextUtils().switchMobileContext(MobileContextUtils.View.WEB);
        return this.driver.findElements(By.cssSelector(IOSLocatorConstants.CATALOG_ITEMS)).size();
    }

    @Override
    public String getSearchInputFieldText() {
        new MobileContextUtils().switchMobileContext(MobileContextUtils.View.WEB);
        searchIcon.click();
        return searchField.getAttribute("value");
    }

    @Override
    public NewsPageBase openNews() {
        menuLink.hover();
        newsLink.click();
        return initPage(this.driver, NewsPageBase.class);
    }
}
