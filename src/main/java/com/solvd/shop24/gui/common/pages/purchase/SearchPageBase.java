package com.solvd.shop24.gui.common.pages.purchase;

import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.components.purchase.SearchProductItem;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SearchPageBase extends HomePageBase {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract SearchProductItem getItem(int index);

    public abstract List<SearchProductItem> getProducts();

}
