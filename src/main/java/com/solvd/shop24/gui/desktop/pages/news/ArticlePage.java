package com.solvd.shop24.gui.desktop.pages.news;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.shop24.gui.common.pages.news.ArticlePageBase;
import com.solvd.shop24.gui.common.components.MenuItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ArticlePageBase.class)
public class ArticlePage extends ArticlePageBase {

    @FindBy(className = "page-main__title")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[@class='news-detail']/div[2]")
    private ExtendedWebElement description;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public boolean allElementsPresent() {
        return allElementsPresent(title, description);
    }
}