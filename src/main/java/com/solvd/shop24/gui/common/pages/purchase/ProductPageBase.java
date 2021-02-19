package com.solvd.shop24.gui.common.pages.purchase;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.desktop.pages.constant.PageLocatorsConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class ProductPageBase extends HomePageBase {

    @FindBy(className = "page-main__title")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[@class='price-container']/div")
    private ExtendedWebElement priceRubs;

    @FindBy(xpath = "//div[@class='price-container']//sup")
    private ExtendedWebElement priceCoints;

    @FindBy(xpath = "//div[@class='product-parameters']//li")
    private List<ExtendedWebElement> descriptionList;

    @FindBy(xpath = "//span[contains(text(), 'В корзину')]")
    private ExtendedWebElement basketButton;

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getPrice() {
        if (!findExtendedWebElements(PageLocatorsConstants.IS_NOT_IN_STOCK_MESSAGE, 5).isEmpty()) {
            return "К сожалению, товар закончился на складе";
        }
        return priceRubs.getText() + " " + priceCoints.getText();
    }

    public String getDescription() {
        StringBuffer description = new StringBuffer();
        descriptionList.stream().forEach(element->description.append(element.getText() + "\n"));
        return description.toString();
    }

    public void addToBasket() {
        basketButton.click();
    }

    public boolean isItemAddedToBasket() {
        return !findExtendedWebElement(PageLocatorsConstants.MESSAGE_SUCCESS_ADDING_BASKET)
                .getAttribute("style").isEmpty();
    }
}
