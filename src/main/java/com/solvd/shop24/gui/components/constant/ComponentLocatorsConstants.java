package com.solvd.shop24.gui.components.constant;

import org.openqa.selenium.By;

public class ComponentLocatorsConstants {

    public static final By BASKET_BUTTON = By.xpath("//div[@class='go-to-basket']/a");
    public static final By OPENED_CATALOG_MENU = By.cssSelector("catalog-btn > open");
    public static final By LOG_IN_LINK = By.linkText("Вход");

    private ComponentLocatorsConstants() {}
}
