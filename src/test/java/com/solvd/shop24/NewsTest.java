package com.solvd.shop24;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.shop24.gui.common.components.news.ArticleItem;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.pages.news.ArticlePageBase;
import com.solvd.shop24.gui.common.pages.news.NewsPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class NewsTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "yantoniuk")
    public void testReadNews() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");

        NewsPageBase newsPage = homePage.getMenu().openNews();
        newsPage.assertPageOpened();
        Assert.assertEquals(newsPage.getTitle(), "Новости", "Invalid title of News page!");
        Assert.assertFalse(newsPage.getArticlesList().isEmpty(), "Empty article's list!");
        int articleIndex = new Random().nextInt(newsPage.getArticlesList().size() - 1);
        ArticleItem articleItem = newsPage.getArticle(articleIndex);
        String title = articleItem.getTitle();

        ArticlePageBase articlePage = articleItem.openArticle();
        new SoftAssert().assertTrue(articlePage.allElementsPresent(),
                "Article page hasn't a description or a title!");
        Assert.assertEquals(articlePage.getTitle(), title, "Invalid article was opened!");
    }
}