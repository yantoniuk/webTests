package com.solvd.shop24.gui.common.components.news;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.shop24.gui.common.pages.news.ArticlePageBase;
import com.solvd.shop24.gui.desktop.pages.news.ArticlePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ArticleItem extends AbstractUIObject implements ICustomTypePageFactory, ArticleItemBase {

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

    public ArticlePageBase openArticle() {
        description.click();
        return initPage(this.driver, ArticlePageBase.class);
    }
}
