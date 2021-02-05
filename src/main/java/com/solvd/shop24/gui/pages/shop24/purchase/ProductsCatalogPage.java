package com.solvd.shop24.gui.pages.shop24.purchase;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.shop24.gui.pages.components.shop24.purchase.CatalogProductItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsCatalogPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='td_overlay']")
    private List<CatalogProductItem> products;

    @FindBy(className = "page-main__title")
    private ExtendedWebElement title;

    public ProductsCatalogPage(WebDriver driver) {
        super(driver);
    }

    public CatalogProductItem getProduct(int index) {
        return products.get(index);
    }

    public int ProductsCount() {
        return products.size();
    }

    public String getTitle() {
        return title.getText();
    }

    public ProductPage openProduct(CatalogProductItem item) {
        return item.openItem();
    }
}
