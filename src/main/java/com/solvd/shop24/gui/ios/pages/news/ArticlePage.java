package com.solvd.shop24.gui.ios.pages.news;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.shop24.gui.common.pages.news.ArticlePageBase;

import com.solvd.shop24.gui.ios.constants.IOSLocatorConstants;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.MobileContextUtils;

import java.net.MalformedURLException;
import java.net.URL;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ArticlePageBase.class)
public class ArticlePage extends ArticlePageBase implements IMobileUtils {

    @FindBy(className = "page-main__title")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[@class='news-detail']/div[2]")
    private ExtendedWebElement description;

    public ArticlePage(WebDriver driver) throws MalformedURLException {
        super(driver);
        new MobileContextUtils().switchMobileContext(MobileContextUtils.View.WEB);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public boolean allElementsPresent() {
        return !getDescription().isEmpty() &&
                !getTitle().isEmpty();
    }
}
