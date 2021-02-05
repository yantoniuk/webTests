package com.solvd.shop24;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.shop24.gui.pages.shop24.news.ArticlePage;
import com.solvd.shop24.gui.pages.shop24.HomePage;
import com.solvd.shop24.gui.pages.shop24.news.NewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewsTest extends BaseTest {
    @Test(description = "JIRA#AUTO-0010")
    @MethodOwner(owner = "yantoniuk")
    public void readingNews() {
        HomePage homePage = openHomePage(getDriver());
        NewsPage newsPage = homePage.getMenu().openNews();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://24shop.by/news/",
                "New page wasn't opened!");
        Assert.assertEquals(newsPage.getTitle(), "Новости", "invalid title of News page!");
        Assert.assertFalse(newsPage.getArticlesList().isEmpty(), "empty article's list!");
        String title = newsPage.getArticle(0).getTitle();
        ArticlePage articlePage = newsPage.getArticle(0).openArticle();
        Assert.assertTrue(articlePage.getTitle().equals(title), "invalid article was opened!");
        Assert.assertTrue(articlePage.isImagePresent(), "image wasn't found!");
        Assert.assertFalse(articlePage.getDescription().isEmpty(), "empty article's description!");
    }
}
