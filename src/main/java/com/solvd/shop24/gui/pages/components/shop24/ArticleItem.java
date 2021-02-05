package com.solvd.shop24.gui.pages.components.shop24;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.shop24.gui.pages.shop24.news.ArticlePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ArticleItem extends AbstractUIObject {

    @FindBy(className = "news-item__img")
    private ExtendedWebElement image;

    @FindBy(className = "news-title")
    private ExtendedWebElement title;

    @FindBy(className = "news-descr")
    private ExtendedWebElement description;

    public ArticleItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
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

    public ArticlePage openArticle() {
        description.click();
        return new ArticlePage(this.driver);
    }
}
