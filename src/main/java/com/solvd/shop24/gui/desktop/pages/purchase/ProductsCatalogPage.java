package com.solvd.shop24.gui.desktop.pages.purchase;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.shop24.gui.common.pages.purchase.ProductsCatalogPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductsCatalogPageBase.class)
public class ProductsCatalogPage extends ProductsCatalogPageBase {

    public ProductsCatalogPage(WebDriver driver) {
        super(driver);
    }
}
