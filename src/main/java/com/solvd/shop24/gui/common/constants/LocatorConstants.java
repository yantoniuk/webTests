package com.solvd.shop24.gui.common.constants;

import org.openqa.selenium.By;

public class LocatorConstants {
    public static final By NEWS_LINK = By.xpath("//span[text()='Новости']/parent::a");
    public static final By SEARCH_INPUT = By.xpath(".//div[@class='top-search__input-block']/input");
    public static final By SEARCH_ICON = By.xpath("//*[contains(@class, 'top-search-mobile__btn')]");
}
