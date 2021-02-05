package com.solvd.carina.demo.gui.pages.shop24.purchase;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.pages.components.shop24.BasketItem;
import com.solvd.carina.demo.gui.pages.components.shop24.MenuItem;
import com.solvd.carina.demo.gui.pages.shop24.HomePage;
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
