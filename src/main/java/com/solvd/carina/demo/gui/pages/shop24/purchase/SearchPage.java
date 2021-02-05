package com.solvd.carina.demo.gui.pages.shop24.purchase;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.gui.pages.components.shop24.SearchProductItem;
import com.solvd.carina.demo.gui.pages.shop24.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends HomePage {

    @FindBy(xpath = "//div[@class='td_overlay td_overlay--md']")
    private List<SearchProductItem> products;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage selectProduct(int index) {
        return products.get(index).openItem();
    }

    public SearchProductItem getItem(int index) {
        return products.get(index);
    }

    public ProductPage selectProduct(SearchProductItem item) {
        return item.openItem();
    }

    public int getProductsCount() {
        return products.size();
    }
}
