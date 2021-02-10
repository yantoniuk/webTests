package com.solvd.shop24.gui.android.pages.profile;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.solvd.shop24.gui.common.pages.profile.AuthenticationPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AuthenticationPageBase.class)
public class AuthenticationPage extends AuthenticationPageBase implements IMobileUtils {

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typePhoneNumber(String phoneNumber) {
        for (char ch: phoneNumber.toCharArray()) {
            phoneNumberField.getElement().sendKeys(String.valueOf(ch));
        }
        hideKeyboard();
    }

    @Override
    public void typePassword(String pass) {
        passField.type(pass);
        hideKeyboard();
    }
}
