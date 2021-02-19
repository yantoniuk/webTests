package com.solvd.shop24.gui.ios.pages.purchase;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.pages.purchase.ProductPageBase;
import com.solvd.shop24.gui.common.pages.purchase.SearchPageBase;
import com.solvd.shop24.gui.desktop.pages.constant.PageLocatorsConstants;
import com.sun.jersey.core.impl.provider.entity.XMLRootObjectProvider;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import utils.MobileContextUtils;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    public ProductPage(WebDriver driver) {
        super(driver);
        new MobileContextUtils().switchMobileContext(MobileContextUtils.View.WEB);
    }
}
