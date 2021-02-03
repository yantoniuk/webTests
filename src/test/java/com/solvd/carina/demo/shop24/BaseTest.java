package com.solvd.carina.demo.shop24;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.carina.demo.gui.pages.shop24.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BaseTest extends AbstractTest {

    protected HomePage openHomePage(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        driver.manage().window().fullscreen();
        Assert.assertTrue(homePage.isPageOpened(), "homePage of shop24 was not opened!");
        return homePage;
    }
}
