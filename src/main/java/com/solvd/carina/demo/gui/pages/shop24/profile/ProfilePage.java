package com.solvd.carina.demo.gui.pages.shop24.profile;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.gui.pages.shop24.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends HomePage {

    @FindBy(xpath = "//dt[text() = 'Имя:']/following::dd[1]")
    private ExtendedWebElement nameField;

    @FindBy(xpath = "//dt[text() = 'Мобильный телефон:']/following::dd[1]")
    private ExtendedWebElement phoneNumberField;

    @FindBy(xpath = "//dt[text() = 'E-mail:']/following::dd[1]")
    private ExtendedWebElement emailField;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getName() {
        return nameField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPhoneNumber() {
        return phoneNumberField.getText();
    }
}
