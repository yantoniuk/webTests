package com.solvd.shop24.gui.ios.pages.purchase;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.pages.purchase.SearchPageBase;
import com.solvd.shop24.gui.ios.components.IOSSearchProductItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import utils.MobileContextUtils;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {

    @FindBy(xpath = "//div[@class='catalog_table__item']/div")
    private List<IOSSearchProductItem> productItems;

    public SearchPage(WebDriver driver) {
        super(driver);
        new MobileContextUtils().switchMobileContext(MobileContextUtils.View.WEB);
    }

    @Override
    public List<IOSSearchProductItem> getProducts() {
        return productItems;
    }

    @Override
    public IOSSearchProductItem getItem(int index) {
        return productItems.get(index);
    }
}
