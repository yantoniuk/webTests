package com.solvd.carina.demo.gui.pages.shop24;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends HomePage {

    @FindBy(xpath = "//span[text()='В корзину']")
    private ExtendedWebElement basketButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToBasket() {
        basketButton.click();
    }
}
