package com.solvd.shop24.gui.ios.pages.purchase;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.shop24.gui.common.pages.purchase.BasketPageBase;
import com.solvd.shop24.gui.ios.components.IOSBasketItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import utils.MobileContextUtils;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BasketPageBase.class)
public class BasketPage extends BasketPageBase {

    @FindBy(xpath = "//div[@class='basket-items']//div[@class='basket-block-main']")
    private List<IOSBasketItem> products;

    public BasketPage(WebDriver driver) {
        super(driver);
        new MobileContextUtils().switchMobileContext(MobileContextUtils.View.WEB);
    }

    public List<IOSBasketItem> getProducts() {
        return products;
    }
}
