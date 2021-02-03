package com.solvd.carina.demo.shop24;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.gui.pages.shop24.HomePage;
import com.solvd.carina.demo.gui.pages.shop24.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchProductsTest extends BaseTest {

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "yantoniuk")
    public void searchBySearchFieldTest() {
        HomePage homePage = openHomePage(getDriver());
        SearchPage searchPage = homePage.searchProductInSearchField("когтеточка");
        searchPage.getProductsInfo();
        Assert.assertFalse(searchPage.getProducts().isEmpty(), "cannot find products!");
    }

    @Test(description = "JIRA#AUTO-0009")
    @MethodOwner(owner = "yantoniuk")
    public void failSearchBySearchFieldTest() {
        HomePage homePage = openHomePage(getDriver());
        SearchPage searchPage = homePage.searchProductInSearchField("ssssss");
        searchPage.getProductsInfo();
        Assert.assertTrue(searchPage.getProducts().isEmpty(), "no products were expected!");
    }

    @Test(description = "JIRA#AUTO-0010")
    @MethodOwner(owner = "yantoniuk")
    public void searchByCatalogTest() {
        HomePage homePage = openHomePage(getDriver());
        SearchPage searchPage = homePage.searchProductInCatalog("Авто и мото");
        Assert.assertTrue(searchPage.getProducts().isEmpty(), "no products were expected!");
    }
}
