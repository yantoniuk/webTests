package com.solvd.carina.demo.gui.pages.demoqa;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DynamicPropertiesPage extends AbstractPage {

    @FindBy(id="enableAfter")
    private ExtendedWebElement enableAfterButton;

    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
        setPageURL("/dynamic-properties");
    }

    public void clickButton() {
        enableAfterButton.click(10);
    }
}
