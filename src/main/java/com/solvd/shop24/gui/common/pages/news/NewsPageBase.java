package com.solvd.shop24.gui.common.pages.news;

import com.solvd.shop24.gui.common.components.news.ArticleItem;
import com.solvd.shop24.gui.common.components.news.ArticleItemBase;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class NewsPageBase extends HomePageBase {

    public NewsPageBase(WebDriver driver) {
        super(driver);
        setPageURL("/news/");
    }

    public abstract String getTitle();

    public abstract List<? extends ArticleItemBase> getArticlesList();

    public abstract ArticleItemBase getArticle(int index);
}
