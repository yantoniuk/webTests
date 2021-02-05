package com.solvd.shop24.gui.pages.shop24.purchase;

import com.solvd.shop24.gui.pages.components.shop24.purchase.BasketItem;
import com.solvd.shop24.gui.pages.shop24.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends HomePage {

    @FindBy(xpath = "//div[@class='basket-items']//div[@class='basket-block-main']")
    private List<BasketItem> products;

    public BasketPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://24shop.by/personal/basket.php");
    }

    public List<BasketItem> getProducts() {
        return products;
    }
}
