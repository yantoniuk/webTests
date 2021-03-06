package com.solvd.shop24;

import com.beust.jcommander.Parameter;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.FirefoxCapabilities;
import com.solvd.shop24.gui.common.components.news.ArticleItem;
import com.solvd.shop24.gui.common.components.news.ArticleItemBase;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.pages.news.ArticlePageBase;
import com.solvd.shop24.gui.common.pages.news.NewsPageBase;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Random;

public class NewsTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "yantoniuk")
    @Parameters({"browserName"})
    public void testReadNews(String browserName) {
        HomePageBase homePage = initPage(getDriver(browserName), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");
        NewsPageBase newsPage = homePage.getMenu().openNews();
        Assert.assertTrue(homePage.isPageOpened(), "News page wasn't opened!");
        Assert.assertEquals(newsPage.getTitle(), "Новости", "Invalid title of News page!");
        Assert.assertFalse(newsPage.getArticlesList().isEmpty(), "Empty article's list!");
        int articleIndex = new Random().nextInt(newsPage.getArticlesList().size() - 1);
        ArticleItemBase articleItem = newsPage.getArticle(articleIndex);
        String title = articleItem.getTitle();
        ArticlePageBase articlePage = articleItem.openArticle();
        new SoftAssert().assertTrue(articlePage.allElementsPresent(),
                "Article page hasn't a description or a title!");
        Assert.assertEquals(articlePage.getTitle(), title, "Invalid article was opened!");
    }
}