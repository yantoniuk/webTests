package com.solvd.shop24.gui.common.pages.profile;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AuthenticationPageBase extends HomePageBase {

    @FindBy(xpath = "//input[@type='submit']")
    protected ExtendedWebElement submitButton;

    @FindBy(xpath = "//input[@type='tel']")
    protected ExtendedWebElement phoneNumberField;

    @FindBy(xpath = "//input[@type='password']")
    protected ExtendedWebElement passField;

    public AuthenticationPageBase(WebDriver driver) {
        super(driver);
        setPageURL("/personal/auth.php");
    }

    public abstract void typePhoneNumber(String phoneNumber);

    public abstract void typePassword(String pass);

    public ProfilePageBase authentication(String phoneNumber, String pass) {
        typePhoneNumber(phoneNumber);
        typePassword(pass);
        submitButton.click();
        return initPage(this.driver, ProfilePageBase.class);
    }
}
