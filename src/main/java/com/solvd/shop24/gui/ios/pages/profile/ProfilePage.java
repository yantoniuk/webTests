package com.solvd.shop24.gui.ios.pages.profile;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.ClassChain;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.shop24.gui.common.pages.profile.ProfilePageBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.MobileContextUtils;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProfilePageBase.class)
public class ProfilePage extends ProfilePageBase implements IMobileUtils {

    @FindBy(xpath = "value MATCHES '3' AND type = 'XCUIElementTypeLink' AND label != '3'")
    @Predicate
    public ExtendedWebElement nameField;

    @FindBy(xpath = "name CONTAINS '+375' AND type = 'XCUIElementTypeStaticText'")
    @Predicate
    public ExtendedWebElement phoneNumberField;

    @FindBy(xpath = "name CONTAINS '@' AND type = 'XCUIElementTypeStaticText'")
    @Predicate
    public ExtendedWebElement emailField;

    public ProfilePage(WebDriver driver) {
        super(driver);
        setPageURL("/cabinet/settings/");
    }

    public String getName() {
        return nameField.getAttribute("label");
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPhoneNumber() {
        return phoneNumberField.getText();
    }
}
