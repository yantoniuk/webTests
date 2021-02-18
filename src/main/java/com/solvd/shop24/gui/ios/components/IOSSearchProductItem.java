package com.solvd.shop24.gui.ios.components;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.shop24.gui.common.components.purchase.SearchProductItemBase;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.pages.purchase.ProductPageBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import utils.MobileContextUtils;

public class IOSSearchProductItem extends AbstractUIObject implements SearchProductItemBase, ICustomTypePageFactory {

    @FindBy(xpath = ".//a[@class='pseudo-link']")
    private ExtendedWebElement productItemLink;

    @FindBy(xpath = ".//div[@class='price']/span")
    private ExtendedWebElement price;

    public IOSSearchProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getTitle() {
        return productItemLink.getAttribute("title");
    }

    @Override
    public String getPrice() {
        return price.getText();
    }

    @Override
    public ProductPageBase openItem() {
        productItemLink.click();
        return initPage(this.driver, ProductPageBase.class);
    }
}
