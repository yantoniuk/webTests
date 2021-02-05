package com.solvd.carina.demo.gui.pages.components.shop24;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.demo.gui.pages.shop24.purchase.ProductPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchProductItem extends AbstractUIObject {

    @FindBy(xpath = ".//div[@class='deskr_box']/span[@class='main_lnk']")
    private ExtendedWebElement title;

    @FindBy(xpath = ".//div[@class='price']/span")
    private ExtendedWebElement price;

    public SearchProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public ProductPage openItem() {
        title.click();
        return new ProductPage(this.driver);
    }
}
