package com.solvd.shop24.gui.ios.pages;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }
}