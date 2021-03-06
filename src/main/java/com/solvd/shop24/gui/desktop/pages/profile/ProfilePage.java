package com.solvd.shop24.gui.desktop.pages.profile;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.shop24.gui.common.pages.profile.AuthenticationPageBase;
import com.solvd.shop24.gui.common.pages.profile.ProfilePageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
}
