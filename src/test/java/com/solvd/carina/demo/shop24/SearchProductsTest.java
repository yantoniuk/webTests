package com.solvd.carina.demo.shop24;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.pages.components.shop24.SearchProductItem;
import com.solvd.carina.demo.gui.pages.shop24.HomePage;
import com.solvd.carina.demo.gui.pages.shop24.purchase.ProductPage;
import com.solvd.carina.demo.gui.pages.shop24.purchase.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class SearchProductsTest extends BaseTest {

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "yantoniuk")
    public void searchingProduct() {
        HomePage homePage = openHomePage(getDriver());
        SearchPage searchPage = homePage.getMenu().searchProductBySearchField("Когтеточка");
        Assert.assertTrue(searchPage.getMenu().getSearchInputFieldText().equals("Когтеточка"));
        int productIndex = new Random().nextInt(searchPage.getProductsCount() - 1);
        String searchProductTitle = searchPage.getItem(productIndex).getTitle();
        Assert.assertTrue(searchProductTitle.matches(".*[Кк]огтеточка.*"), "product hasn't a title!");
        ProductPage productPage = searchPage.selectProduct(productIndex);
        Assert.assertTrue(productPage.getTitle().contains(searchProductTitle), "searched item's title and " +
                "current product item's title are not equals!");
    }

    @Test(description = "JIRA#AUTO-0009")
    @MethodOwner(owner = "yantoniuk")
    public void failSearchingProduct() {
        HomePage homePage = openHomePage(getDriver());
        SearchPage searchPage = homePage.getMenu().searchProductBySearchField("ssssss");
        Assert.assertTrue(searchPage.getProductsCount() == 0, "no products were expected!");
    }
}
