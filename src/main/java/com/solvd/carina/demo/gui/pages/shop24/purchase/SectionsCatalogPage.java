package com.solvd.carina.demo.gui.pages.shop24.purchase;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.gui.pages.shop24.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SectionsCatalogPage extends HomePage {

    @FindBy(xpath = "//div[@class='list-block js-accordion__body']//span")
    private List<ExtendedWebElement> catalogItems;

    @FindBy(className = "page-main__title")
    private ExtendedWebElement title;

    public SectionsCatalogPage(WebDriver driver) {
        super(driver);
    }

    public ProductsCatalogPage openCatalogItem(String name) {
        catalogItems.stream().filter(el -> el.getText().equals(name)).findAny().get().click();
        return new ProductsCatalogPage(this.driver);
    }

    public String getTitle() {
        return title.getText();
    }
}
