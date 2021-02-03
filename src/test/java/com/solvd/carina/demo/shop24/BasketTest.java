package com.solvd.carina.demo.shop24;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.pages.shop24.HomePage;
import com.solvd.carina.demo.gui.pages.shop24.ProductPage;
import com.solvd.carina.demo.gui.pages.shop24.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasketTest extends BaseTest {

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "yantoniuk")
    public void openBasketTest() {
        HomePage homePage = openHomePage(getDriver());
        SearchPage searchPage = homePage.searchProductInSearchField("когтеточка");
        ProductPage productPage = searchPage.selectProduct(1);
        productPage.addToBasket();
        productPage.showBasket();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://24shop.by/personal/basket.php",
                "Basket Page was not opened!");
    }
}
