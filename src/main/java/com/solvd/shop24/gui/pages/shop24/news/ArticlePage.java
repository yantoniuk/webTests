package com.solvd.shop24.gui.pages.shop24.news;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.shop24.gui.pages.shop24.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends HomePage {

    @FindBy(className = "page-main__title")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[@class='news-detail']/div[2]")
    private ExtendedWebElement description;

    @FindBy(xpath = "//div[@class='news-detail']//img")
    private ExtendedWebElement image;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public boolean isImagePresent() {
        return image.isPresent();
    }
}
