package com.solvd.shop24.gui.common.pages.purchase;

import com.solvd.shop24.gui.common.components.purchase.SearchProductItemBase;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SearchPageBase extends HomePageBase {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SearchProductItemBase getItem(int index);

    public abstract List<? extends SearchProductItemBase> getProducts();

}
