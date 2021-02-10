package com.solvd.shop24.gui.android.pages.news;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.shop24.gui.common.components.MenuItem;
import com.solvd.shop24.gui.common.pages.news.NewsPageBase;
import com.solvd.shop24.gui.common.components.news.ArticleItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase implements IMobileUtils{

    @FindBy(className = "page-nav")
    private MenuItem menu;

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

    @Override
    public List<ArticleItem> getArticlesList() {
        return articlesList;
    }

    public ArticleItem getArticle(int index) {
        return articlesList.get(index);
    }
}

