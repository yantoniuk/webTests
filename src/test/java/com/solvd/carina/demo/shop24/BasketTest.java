package com.solvd.carina.demo.shop24;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.pages.shop24.HomePage;
import com.solvd.carina.demo.gui.pages.shop24.purchase.BasketPage;
import com.solvd.carina.demo.gui.pages.shop24.purchase.ProductPage;
import com.solvd.carina.demo.gui.pages.shop24.purchase.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasketTest extends BaseTest {

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "yantoniuk")
    public void openBasketTest() {
        HomePage homePage = openHomePage(getDriver());
        SearchPage searchPage = homePage.getMenu().searchProductBySearchField("когтеточка");
        ProductPage productPage = searchPage.selectProduct(1);
        String title = productPage.getTitle();
        productPage.addToBasket();
        Assert.assertTrue(productPage.isItemAddedToBasket(), "item wasn't added to the basket!");
        BasketPage basketPage = productPage.getMenu().showBasket();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://24shop.by/personal/basket.php",
                "Basket Page was not opened!");
        Assert.assertEquals(basketPage.getProducts().size(), 1, "invalid count of products");
        Assert.assertTrue(title.contains(basketPage.getProducts().get(0).getTitle()), "invalid item " +
                "was added to the basket!");
    }
}
