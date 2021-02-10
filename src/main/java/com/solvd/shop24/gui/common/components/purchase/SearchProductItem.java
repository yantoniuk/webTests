package com.solvd.shop24.gui.common.components.purchase;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.shop24.gui.common.pages.purchase.ProductPageBase;
import com.solvd.shop24.gui.desktop.pages.purchase.ProductPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchProductItem extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = ".//span[@class='main_lnk']")
    private ExtendedWebElement title;

    @FindBy(xpath = ".//div[@class='price']/span")
    private ExtendedWebElement price;

    @FindBy(xpath = ".//a[@class='pseudo-link']")
    private ExtendedWebElement openProductLink;

    public SearchProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public ProductPageBase openItem() {
        openProductLink.click();
        return initPage(this.driver, ProductPageBase.class);
    }
}
