package com.solvd.shop24.gui.common.pages.news;

import com.solvd.shop24.gui.common.components.news.ArticleItem;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class NewsPageBase extends HomePageBase {

    public NewsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getTitle();

    public abstract List<ArticleItem> getArticlesList();

    public abstract ArticleItem getArticle(int index);
}
