package com.solvd.shop24.gui.android.pages.purchase;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.shop24.gui.common.pages.purchase.SearchPageBase;
import com.solvd.shop24.gui.common.components.purchase.SearchProductItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {

    @FindBy(xpath = "//div[@class='catalog_table__item']/div")
    private List<SearchProductItem> products;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchProductItem getItem(int index) {
        return products.get(index);
    }

    public List<SearchProductItem> getProducts() {
        return products;
    }
}
