package com.solvd.shop24.gui.desktop.pages.profile;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.shop24.gui.common.pages.profile.AuthenticationPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AuthenticationPageBase.class)
public class AuthenticationPage extends AuthenticationPageBase {

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typePhoneNumber(String phoneNumber) {
        phoneNumberField.type(phoneNumber);
    }

    @Override
    public void typePassword(String pass) {
        passField.type(pass);
    }
}
