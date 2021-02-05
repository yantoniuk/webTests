package com.solvd.carina.demo.shop24;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.pages.components.shop24.CatalogProductItem;
import com.solvd.carina.demo.gui.pages.components.shop24.SearchProductItem;
import com.solvd.carina.demo.gui.pages.shop24.HomePage;
import com.solvd.carina.demo.gui.pages.shop24.purchase.ProductPage;
import com.solvd.carina.demo.gui.pages.shop24.purchase.ProductsCatalogPage;
import com.solvd.carina.demo.gui.pages.shop24.purchase.SearchPage;
import com.solvd.carina.demo.gui.pages.shop24.purchase.SectionsCatalogPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {
    @Test(description = "JIRA#AUTO-0010")
    @MethodOwner(owner = "yantoniuk")
    public void searchByCatalogTest() {
        HomePage homePage = openHomePage(getDriver());
        homePage.getMenu().openCatalogMenu();
        Assert.assertTrue(homePage.getMenu().catalogItemsCount() > 0, "products were expected!");
        SectionsCatalogPage catalogPage = homePage.getMenu().searchProductByCatalog("Авто и мото");
        Assert.assertEquals(catalogPage.getTitle(), "Авто и мото", "invalid section!");
        ProductsCatalogPage productsCatalogPage = catalogPage.openCatalogItem("Шины");
        Assert.assertEquals("Шины", productsCatalogPage.getTitle(), "invalid type of product!");
        Assert.assertTrue(productsCatalogPage.ProductsCount() > 0, "empty product's list!");
        CatalogProductItem productItem = productsCatalogPage.getProduct(0);
        String title = productItem.getTitle();
        Assert.assertTrue(productItem.getTitle().contains("шины"), "invalid type of product item!");
        ProductPage productPage = productItem.openItem();
        Assert.assertTrue(productPage.getTitle().contains(title),
                "invalid title of a product!");
        Assert.assertTrue(productPage.getPrice().length() > 1, "invalid value of a price!");
    }
}