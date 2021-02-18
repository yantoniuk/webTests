package com.solvd.shop24.gui.ios.constants;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class IOSLocatorConstants {
    public static final By SIGN_IN_LINK = new By.ByName("Вход");
    public static final String SEARCH_ICON = "button.top-search-mobile__btn";
    public static final String CATALOG_ITEMS = "ul.cat_nav > li > a";
}
