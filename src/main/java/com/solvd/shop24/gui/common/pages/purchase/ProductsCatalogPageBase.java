package com.solvd.shop24.gui.common.pages.purchase;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.shop24.gui.common.components.MenuItem;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.components.purchase.CatalogProductItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class ProductsCatalogPageBase extends HomePageBase {

    @FindBy(xpath = "//div[@class='td_overlay']")
    private List<CatalogProductItem> products;

    @FindBy(className = "page-main__title")
    private ExtendedWebElement title;

    public ProductsCatalogPageBase(WebDriver driver) {
        super(driver);
    }

    public CatalogProductItem getProduct(int index) {
        return products.get(index);
    }

    public List<CatalogProductItem> getProducts() {
        return products;
    }

    public String getTitle() {
        return title.getText();
    }
}
