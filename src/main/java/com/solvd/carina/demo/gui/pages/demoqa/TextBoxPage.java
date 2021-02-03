package com.solvd.carina.demo.gui.pages.demoqa;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.pages.demoqa.constant.ElementsConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TextBoxPage extends AbstractPage {

    @FindBy(className = "main-header")
    private ExtendedWebElement title;

    @FindBy(id = "submit")
    private ExtendedWebElement submitButton;

    @FindBy(id = "userName")
    private ExtendedWebElement userNameField;

    @FindBy(id = "userEmail")
    private ExtendedWebElement userEmailField;

    @FindBy(id = "currentAddress")
    private ExtendedWebElement currentAddressField;

    @FindBy(id = "permanentAddress")
    private ExtendedWebElement permanentAddressField;

    public TextBoxPage(WebDriver driver) {
        super(driver);
        setPageURL("/text-box");
    }

    public String getTitle() {
        return title.getText();
    }

    public void typeFullName(String fullName) {
        userNameField.type(fullName);
    }

    public void typeCurrentAddress(String currentAddress) {
        currentAddressField.type(currentAddress);
    }

    public void typePermanentAddress(String permanentAddress) {
        permanentAddressField.type(permanentAddress);
    }

    public void typeEmail(String email) {
        userEmailField.type(email);
    }

    public void submit() {
        submitButton.click();
    }

    public String getInfo() {
        StringBuffer infoBuffer = new StringBuffer();
        List<ExtendedWebElement> infoFields =
                findExtendedWebElements(ElementsConstant.RESULT_INFO_FIELDS);
        infoFields.stream().map(ExtendedWebElement::getText).forEach(el -> infoBuffer.append(el + "\n"));
        return infoBuffer.toString();
    }
}
