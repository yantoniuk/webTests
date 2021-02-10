package com.solvd.shop24.gui.android.pages.news;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.shop24.gui.common.components.MenuItem;
import com.solvd.shop24.gui.common.pages.news.ArticlePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ArticlePageBase.class)
public class ArticlePage extends ArticlePageBase implements IMobileUtils {

    @FindBy(className = "page-main__title")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[@class='news-detail']/div[2]")
    private ExtendedWebElement description;

    @FindBy(className = "page-nav")
    private MenuItem menu;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public boolean allElementsPresent() {
        return allElementsPresent(title, description);
    }
}