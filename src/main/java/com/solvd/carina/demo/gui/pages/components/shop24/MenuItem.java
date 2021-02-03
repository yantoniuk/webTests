package com.solvd.carina.demo.gui.pages.components.shop24;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.demo.gui.pages.components.shop24.constant.LocatorsConstants;
import com.solvd.carina.demo.gui.pages.shop24.BasketPage;
import com.solvd.carina.demo.gui.pages.shop24.SearchPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenuItem extends AbstractUIObject {

    @FindBy(className = "catalog-btn__txt")
    private ExtendedWebElement catalogMenu;

    @FindBy(xpath = ".//div[@class='top-search__input-block']/input")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//ul[@class='cat_nav inner-cat-nav']/li/a")
    private List<ExtendedWebElement> catalogItems;

    @FindBy(xpath = "//span[@class='page-header-bottom-btn__txt']")
    private ExtendedWebElement basketButton;

    public MenuItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public BasketPage showBasket() {
        basketButton.click();
        findExtendedWebElement(LocatorsConstants.BASKET_BUTTON).click();
        return new BasketPage(this.driver);
    }

    public SearchPage searchProductBySearchField(String name) {
        searchField.type(name);
        searchField.sendKeys(Keys.ENTER);
        return new SearchPage(this.driver);
    }

    public SearchPage searchProductByCatalog(String type) {
        catalogMenu.click();
        catalogItems.stream().filter(elem-> elem.getAttribute("text").equals(type)).findAny().get().click();
        return new SearchPage(this.driver);
    }
}
