package com.solvd.shop24.gui.common.components;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.shop24.gui.common.constants.LocatorConstants;
import com.solvd.shop24.gui.common.pages.news.NewsPageBase;
import com.solvd.shop24.gui.common.pages.profile.AuthenticationPageBase;
import com.solvd.shop24.gui.common.pages.purchase.BasketPageBase;
import com.solvd.shop24.gui.common.pages.purchase.ProductsCatalogPageBase;
import com.solvd.shop24.gui.common.pages.purchase.SearchPageBase;
import com.solvd.shop24.gui.desktop.components.constant.ComponentLocatorsConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public interface MenuItemBase {

    public abstract boolean isUIObjectPresent();

    public abstract BasketPageBase showBasket();

    public abstract SearchPageBase searchProductBySearchField(String name);

    public abstract ProductsCatalogPageBase searchProductByCatalog(String type, String subType);

    public abstract int catalogItemsCount();

    public abstract String getSearchInputFieldText();
    public abstract NewsPageBase openNews();

    public abstract AuthenticationPageBase navigateToAuthenticationPage();
}
