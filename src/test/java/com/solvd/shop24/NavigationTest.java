package com.solvd.shop24;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.pages.purchase.ProductPageBase;
import com.solvd.shop24.gui.common.pages.purchase.ProductsCatalogPageBase;
import com.solvd.shop24.gui.common.components.purchase.CatalogProductItem;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class NavigationTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "yantoniuk")
    public void testSearchByCatalog() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");
        Assert.assertTrue(homePage.getMenu().catalogItemsCount() > 0, "Products were expected!");

        ProductsCatalogPageBase productsCatalogPage = homePage.getMenu().searchProductByCatalog("Авто и мото", "Автомобильные лампы");
        Assert.assertEquals(productsCatalogPage.getTitle(), "Автомобильные лампы", "Invalid type of product!");
        Assert.assertFalse(productsCatalogPage.getProducts().isEmpty(), "Empty product's list!");
        int productIndex = new Random().nextInt(productsCatalogPage.getProducts().size() - 1);
        CatalogProductItem productItem = productsCatalogPage.getProduct(productIndex);
        String title = productItem.getTitle();
        Assert.assertTrue(productItem.getTitle().matches(".*[Лл]амп.*"), "Invalid type of product item!");

        ProductPageBase productPage = productItem.openItem();
        Assert.assertTrue(productPage.getTitle().contains(title),
                "invalid title of a product!");
        Assert.assertTrue(productPage.getPrice().contains("К сожалению, товар закончился на складе") ||
                productPage.getPrice().length() > 1, "Invalid value of a price!");
    }
}