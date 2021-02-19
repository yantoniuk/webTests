package com.solvd.shop24.gui.common.pages.purchase;

import com.solvd.shop24.gui.common.components.MenuItem;
import com.solvd.shop24.gui.common.components.purchase.BasketItemBase;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.components.purchase.BasketItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class BasketPageBase extends HomePageBase {

    @FindBy(className = "page-nav")
    private MenuItem menu;

    @FindBy(xpath = "//div[@class='basket-items']//div[@class='basket-block-main']")
    private List<? extends BasketItemBase> products;

    public BasketPageBase(WebDriver driver) {
        super(driver);
        setPageURL("/personal/basket.php");
    }

    public List<? extends BasketItemBase> getProducts() {
        return products;
    }
}
