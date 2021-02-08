package com.solvd.shop24.gui.pages.purchase;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.shop24.gui.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SectionsCatalogPage extends HomePage {

    @FindBy(css = "div.list-block>ul>li>a>span")
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
