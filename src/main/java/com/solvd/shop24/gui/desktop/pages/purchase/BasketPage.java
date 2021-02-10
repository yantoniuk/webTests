package com.solvd.shop24.gui.desktop.pages.purchase;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.shop24.gui.common.pages.purchase.BasketPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BasketPageBase.class)
public class BasketPage extends BasketPageBase {

    public BasketPage(WebDriver driver) {
        super(driver);
        setPageURL("/personal/basket.php");
    }
}
