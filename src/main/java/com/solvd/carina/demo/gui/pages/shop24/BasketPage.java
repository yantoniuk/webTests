package com.solvd.carina.demo.gui.pages.shop24;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.pages.components.shop24.MenuItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends HomePage {

    public BasketPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://24shop.by/personal/basket.php");
    }
}
