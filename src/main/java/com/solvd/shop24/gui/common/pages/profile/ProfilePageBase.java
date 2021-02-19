package com.solvd.shop24.gui.common.pages.profile;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProfilePageBase extends HomePageBase {

    @FindBy(xpath = "//dt[text() = 'Имя:']/following::dd[1]")
    private ExtendedWebElement nameField;

    @FindBy(xpath = "//dt[text() = 'Мобильный телефон:']/following::dd[1]")
    private ExtendedWebElement phoneNumberField;

    @FindBy(xpath = "//dt[text() = 'E-mail:']/following::dd[1]")
    private ExtendedWebElement emailField;

    public ProfilePageBase(WebDriver driver) {
        super(driver);
        setPageURL("/cabinet/settings/");
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
