package com.solvd.shop24;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.shop24.gui.pages.HomePage;
import com.solvd.shop24.gui.pages.purchase.ProductPage;
import com.solvd.shop24.gui.pages.purchase.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class SearchProductsTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "yantoniuk")
    public void testSearchProduct() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");

        SearchPage searchPage = homePage.getMenu().searchProductBySearchField("Когтеточка");
        Assert.assertEquals(searchPage.getMenu().getSearchInputFieldText(),"Когтеточка",
                "Invalid typed text!");
        int productIndex = new Random().nextInt(searchPage.getProducts().size() - 1);
        String searchProductTitle = searchPage.getItem(productIndex).getTitle();
        Assert.assertTrue(searchProductTitle.matches(".*[Кк]огтеточка.*"), "product hasn't a title!");

        ProductPage productPage = searchPage.getItem(productIndex).openItem();
        Assert.assertTrue(productPage.getTitle().contains(searchProductTitle),
                "searched item's title and current product item's title are not equals!");
    }
}
