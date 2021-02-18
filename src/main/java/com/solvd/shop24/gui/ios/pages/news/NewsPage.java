package com.solvd.shop24.gui.ios.pages.news;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.solvd.shop24.gui.common.pages.news.NewsPageBase;
import com.solvd.shop24.gui.ios.components.ArticleItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase {

    @FindBy(xpath = "name = 'Новости' AND type = 'XCUIElementTypeStaticText' AND value != '1'")
    @Predicate
    private ExtendedWebElement title;

    @FindBy(xpath = "value MATCHES '3' AND type = 'XCUIElementTypeLink' AND label != '3'")
    @Predicate
    public List<ArticleItem> articlesList;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        return title.getText();
    }

    @Override
    public List<ArticleItem> getArticlesList() {
        return articlesList;
    }

    @Override
    public ArticleItem getArticle(int index) {
        return articlesList.get(index);
    }
}
