package com.solvd.shop24;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.shop24.gui.pages.HomePage;
import com.solvd.shop24.gui.pages.purchase.BasketPage;
import com.solvd.shop24.gui.pages.purchase.ProductPage;
import com.solvd.shop24.gui.pages.purchase.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class BasketTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "yantoniuk")
    public void testOpenBasket() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");

        SearchPage searchPage = homePage.getMenu().searchProductBySearchField("когтеточка");

        int productIndex = new Random().nextInt(searchPage.getProducts().size() - 1);
        ProductPage productPage = searchPage.getItem(productIndex).openItem();
        String title = productPage.getTitle();
        productPage.addToBasket();
        Assert.assertTrue(productPage.isItemAddedToBasket(), "Item wasn't added to the basket!");

        BasketPage basketPage = productPage.getMenu().showBasket();
        basketPage.assertPageOpened();
        Assert.assertEquals(basketPage.getProducts().size(), 1, "Invalid count of products");
        Assert.assertTrue(title.contains(basketPage.getProducts().get(0).getTitle()), "Invalid item " +
                "was added to the basket!");
    }
}
