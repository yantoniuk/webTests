package com.solvd.shop24.gui.common.pages.news;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import org.openqa.selenium.WebDriver;

public abstract class ArticlePageBase extends HomePageBase {

    public ArticlePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getTitle();

    public abstract boolean allElementsPresent();
}
