package com.solvd.shop24.gui.pages.news;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.shop24.gui.components.news.ArticleItem;
import com.solvd.shop24.gui.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends HomePage {

    @FindBy(className = "page-main__title")
    private ExtendedWebElement title;

    @FindBy(className = "news-item__content")
    private List<ArticleItem> articlesList;

    public NewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/news/");
    }

    public String getTitle() {
        return title.getText();
    }

    public List<ArticleItem> getArticlesList() {
        return articlesList;
    }

    public ArticleItem getArticle(int index) {
        return articlesList.get(index);
    }
}
