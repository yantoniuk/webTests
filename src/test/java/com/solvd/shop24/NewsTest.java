package com.solvd.shop24;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.shop24.gui.components.news.ArticleItem;
import com.solvd.shop24.gui.pages.news.ArticlePage;
import com.solvd.shop24.gui.pages.HomePage;
import com.solvd.shop24.gui.pages.news.NewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class NewsTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "yantoniuk")
    public void testReadNews() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");

        NewsPage newsPage = homePage.getMenu().openNews();
        newsPage.assertPageOpened();
        Assert.assertEquals(newsPage.getTitle(), "Новости", "Invalid title of News page!");
        Assert.assertFalse(newsPage.getArticlesList().isEmpty(), "Empty article's list!");
        int articleIndex = new Random().nextInt(newsPage.getArticlesList().size() - 1);
        ArticleItem articleItem = newsPage.getArticle(articleIndex);
        String title = articleItem.getTitle();

        ArticlePage articlePage = articleItem.openArticle();
        new SoftAssert().assertTrue(articlePage.allElementsPresent(),
                "Article page hasn't a description or a title!");
        Assert.assertEquals(articlePage.getTitle(), title, "Invalid article was opened!");
    }
}