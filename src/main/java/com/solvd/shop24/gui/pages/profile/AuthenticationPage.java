package com.solvd.shop24.gui.pages.profile;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends AbstractPage {

    @FindBy(name = "Login")
    private ExtendedWebElement submitButton;

    @FindBy(name = "phone")
    private ExtendedWebElement phoneNumberField;

    @FindBy(name = "USER_PASSWORD")
    private ExtendedWebElement passField;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        setPageURL("/personal/auth.php");
    }

    public void typePhoneNumber(String phoneNumber) {
        phoneNumberField.type(phoneNumber);
    }

    public void typePassword(String pass) {
        passField.type(pass);
    }

    public ProfilePage authentication(String phoneNumber, String pass) {
        typePhoneNumber(phoneNumber);
        typePassword(pass);
        submitButton.click();
        return new ProfilePage(this.driver);
    }
}
