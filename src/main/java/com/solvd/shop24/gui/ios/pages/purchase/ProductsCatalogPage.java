package com.solvd.shop24.gui.ios.pages.purchase;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.shop24.gui.common.pages.purchase.ProductPageBase;
import com.solvd.shop24.gui.common.pages.purchase.ProductsCatalogPageBase;
import org.openqa.selenium.WebDriver;
import utils.MobileContextUtils;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductsCatalogPageBase.class)
public class ProductsCatalogPage extends ProductsCatalogPageBase {

    public ProductsCatalogPage(WebDriver driver) {
        super(driver);
        new MobileContextUtils().switchMobileContext(MobileContextUtils.View.WEB);
    }
}
