package com.solvd.carina.demo.gui.pages.components.shop24;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.demo.gui.pages.shop24.ProductPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItem extends AbstractUIObject {

    @FindBy(xpath = "./div[@class='razdel_lnk']/a")
    private ExtendedWebElement type;

    @FindBy(className = "main_lnk")
    private ExtendedWebElement description;

    @FindBy(xpath = ".//div[@class='price']/span")
    private ExtendedWebElement price;

    public ProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getPrice() {
        return price.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getType() {
        return type.getText();
    }

    public ProductPage openProductItem() {
        description.click();
        return new ProductPage(this.driver);
    }
}
