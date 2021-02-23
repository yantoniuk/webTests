package com.solvd.shop24;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.pages.purchase.BasketPageBase;
import com.solvd.shop24.gui.common.pages.purchase.ProductPageBase;
import com.solvd.shop24.gui.common.pages.purchase.SearchPageBase;
import com.solvd.shop24.gui.desktop.pages.HomePage;
import com.solvd.shop24.gui.desktop.pages.purchase.BasketPage;
import com.solvd.shop24.gui.desktop.pages.purchase.ProductPage;
import com.solvd.shop24.gui.desktop.pages.purchase.SearchPage;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class BasketTest extends AbstractTest {

    @Test
    @Parameters({"browserName"})
    @MethodOwner(owner = "yantoniuk")
    public void testOpenBasket(String browserName) {
        HomePageBase homePage = initPage(getDriver(browserName), HomePageBase.class);
        homePage.open();
        SearchPageBase searchPage = homePage.getMenu().searchProductBySearchField("когтеточка");
        int productIndex = new Random().nextInt(searchPage.getProducts().size() - 1);
        System.out.println("opening product page....");
        ProductPageBase productPage = searchPage.getItem(productIndex).openItem();
        String title = productPage.getTitle();
        productPage.addToBasket();
        Assert.assertTrue(productPage.isItemAddedToBasket(), "Item wasn't added to the basket!");

        BasketPageBase basketPage = productPage.getMenu().showBasket();
        basketPage.assertPageOpened();
        Assert.assertEquals(basketPage.getProducts().size(), 1, "Invalid count of products");
        Assert.assertTrue(title.contains(basketPage.getProducts().get(0).getTitle()), "Invalid item " +
                "was added to the basket!");
    }
}
