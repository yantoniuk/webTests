package com.solvd.carina.demo.gui.pages.shop24.purchase;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.gui.pages.shop24.HomePage;
import com.solvd.carina.demo.gui.pages.shop24.constant.PageLocatorsConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends HomePage {

    @FindBy (className = "page-main__title")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[@class='catalog-price-value price-main']")
    private ExtendedWebElement priceRubs;

    @FindBy(xpath = "//div[@class='catalog-price-value price-main']/sup")
    private ExtendedWebElement priceCoints;

    @FindBy(xpath = "//div[@class='product-parameters']//li")
    private List<ExtendedWebElement> descriptionList;

    @FindBy(xpath = "//span[contains(text(), 'В корзину')]")
    private ExtendedWebElement basketButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getPrice() {
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
