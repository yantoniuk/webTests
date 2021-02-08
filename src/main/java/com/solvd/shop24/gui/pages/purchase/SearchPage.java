package com.solvd.shop24.gui.pages.purchase;

import com.solvd.shop24.gui.components.purchase.SearchProductItem;
import com.solvd.shop24.gui.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends HomePage {

    @FindBy(xpath = "//div[@class='catalog_table__item']/div")
    private List<SearchProductItem> products;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchProductItem getItem(int index) {
        return products.get(index);
    }

    public List<SearchProductItem> getProducts() {
        return products;
    }
}
