package com.solvd.shop24.gui.ios.pages.profile;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.shop24.gui.common.pages.profile.AuthenticationPageBase;
import com.solvd.shop24.gui.common.pages.profile.ProfilePageBase;
import com.solvd.shop24.gui.ios.components.IOSMenuItem;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.MobileContextUtils;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AuthenticationPageBase.class)
public class AuthenticationPage extends AuthenticationPageBase implements IMobileUtils {

    @FindBy(xpath = "type = 'XCUIElementTypeTextField'")
    @Predicate
    private ExtendedWebElement phoneNumberField;

    @FindBy(xpath = "type = 'XCUIElementTypeSecureTextField'")
    @Predicate
    private ExtendedWebElement passField;

    @ExtendedFindBy(iosPredicate = "name = 'Войти'")
    private ExtendedWebElement submitButton;

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

    @Override
    public ProfilePageBase authentication(String phoneNumber, String pass) {
        typePhoneNumber(phoneNumber);
        typePassword(pass);
        submitButton.click();
        return initPage(getDriver(), ProfilePageBase.class);
    }
}
