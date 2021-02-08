package com.solvd.shop24;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.shop24.gui.components.purchase.CatalogProductItem;
import com.solvd.shop24.gui.pages.HomePage;
import com.solvd.shop24.gui.pages.purchase.ProductPage;
import com.solvd.shop24.gui.pages.purchase.ProductsCatalogPage;
import com.solvd.shop24.gui.pages.purchase.SectionsCatalogPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class NavigationTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "yantoniuk")
    public void testSearchByCatalog() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");

        homePage.getMenu().openCatalogMenu();
        Assert.assertTrue(homePage.getMenu().catalogItemsCount() > 0, "Products were expected!");

        SectionsCatalogPage catalogPage = homePage.getMenu().searchProductByCatalog("Авто и мото");
        Assert.assertEquals(catalogPage.getTitle(), "Авто и мото", "Invalid section!");

        ProductsCatalogPage productsCatalogPage = catalogPage.openCatalogItem("Шины");
        Assert.assertEquals(productsCatalogPage.getTitle(), "Шины", "Invalid type of product!");
        Assert.assertFalse(productsCatalogPage.getProducts().isEmpty(), "Empty product's list!");
        int productIndex = new Random().nextInt(productsCatalogPage.getProducts().size() - 1);
        CatalogProductItem productItem = productsCatalogPage.getProduct(productIndex);
        String title = productItem.getTitle();
        Assert.assertTrue(productItem.getTitle().contains("шины"), "Invalid type of product item!");

        ProductPage productPage = productItem.openItem();
        Assert.assertTrue(productPage.getTitle().contains(title),
                "invalid title of a product!");
        Assert.assertTrue(productPage.getPrice().contains("К сожалению, товар закончился на складе") ||
                productPage.getPrice().length() > 1, "Invalid value of a price!");
    }
}