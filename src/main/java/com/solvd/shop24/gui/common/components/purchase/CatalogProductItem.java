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

public class CatalogProductItem extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = ".//div[@class='name']//span")
    private ExtendedWebElement title;

    @FindBy(xpath = ".//div[@itemscope]//meta[@content][2]")
    private ExtendedWebElement price;

    @FindBy(xpath = ".//span[text()='Добавить в корзину']")
    private ExtendedWebElement addToBasketButton;

    @FindBy(xpath = ".//span[text()='Купить в один клик']")
    private ExtendedWebElement buyButton;

    @FindBy(xpath = ".//div[@class='img_box']/a")
    private ExtendedWebElement imageLink;

    public CatalogProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public void addToBasketButton() {
        addToBasketButton.click();
    }

    public void getBuyButton() {
        buyButton.click();
    }

    public ProductPageBase openItem() {
        imageLink.click();
        return initPage(this.driver, ProductPageBase.class);
    }
}