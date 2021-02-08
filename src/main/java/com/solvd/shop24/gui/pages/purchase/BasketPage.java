package com.solvd.shop24.gui.pages.purchase;

import com.solvd.shop24.gui.components.purchase.BasketItem;
import com.solvd.shop24.gui.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends HomePage {

    @FindBy(xpath = "//div[@class='basket-items']//div[@class='basket-block-main']")
    private List<BasketItem> products;

    public BasketPage(WebDriver driver) {
        super(driver);
        setPageURL("/personal/basket.php");
    }

    public List<BasketItem> getProducts() {
        return products;
    }
}
