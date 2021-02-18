package com.solvd.shop24.gui.ios.components;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.shop24.gui.common.components.news.ArticleItemBase;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.pages.news.ArticlePageBase;
import com.solvd.shop24.gui.ios.pages.news.ArticlePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;
import java.net.URL;

public class ArticleItem extends AbstractUIObject implements ArticleItemBase, ICustomTypePageFactory {

    @FindBy(xpath = "type = 'XCUIElementTypeStaticText'")
    @Predicate
    private ExtendedWebElement title;

    public ArticleItem(WebDriver driver, SearchContext searchContext) throws MalformedURLException {
        super(driver, searchContext);
    }

    @Override
    public String getTitle() {
        return title.getText();
    }

    @Override
    public ArticlePageBase openArticle() {
        title.click();
        return initPage(this.driver, ArticlePageBase.class);
    }
}
