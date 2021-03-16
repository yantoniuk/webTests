package com.solvd.shop24.gui.desktop.pages.purchase;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.shop24.gui.common.components.purchase.BasketItem;
import com.solvd.shop24.gui.common.components.purchase.BasketItemBase;
import com.solvd.shop24.gui.common.pages.purchase.BasketPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BasketPageBase.class)
public class BasketPage extends BasketPageBase {

    @FindBy(xpath = "//div[@class='basket-items']//div[@class='basket-block-main']")
    private List<BasketItem> products;
    public BasketPage(WebDriver driver) {
        super(driver);
    }
    public List<BasketItem> getProducts() {
        return products;
    }
}
