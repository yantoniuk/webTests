package com.solvd.carina.demo.gui.pages.shop24;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.pages.components.shop24.ProductItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='td_overlay td_overlay--md']")
    private List<ProductItem> products;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage selectProduct(int index) {
        return products.get(index).openProductItem();
    }

    public List<ProductItem> getProducts() {
        return products;
    }

    public void getProductsInfo() {
        for (ProductItem el: products) {
            System.out.println(el.getType() + "\n" + el.getDescription() + "\n" + el.getPrice() + "\n");
        }
    }
}
