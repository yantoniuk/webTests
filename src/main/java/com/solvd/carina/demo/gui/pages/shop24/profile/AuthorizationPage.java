package com.solvd.carina.demo.gui.pages.shop24.profile;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends AbstractPage {

    @FindBy(name = "Login")
    private ExtendedWebElement submitButton;

    @FindBy(name = "phone")
    private ExtendedWebElement phoneNumberField;

    @FindBy(name = "USER_PASSWORD")
    private ExtendedWebElement passField;

    public AuthorizationPage(WebDriver driver) {
        super(driver);
        setPageURL("/personal/register.php");
    }

    public void typePhoneNumber(String phoneNumber) {
        phoneNumberField.type(phoneNumber);
    }

    public void typePassword(String pass) {
        passField.type(pass);
    }

    public ProfilePage submit() {
        submitButton.click();
        return new ProfilePage(this.driver);
    }
}
