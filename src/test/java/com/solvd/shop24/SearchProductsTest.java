package com.solvd.shop24;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.pages.purchase.ProductPageBase;
import com.solvd.shop24.gui.common.pages.purchase.SearchPageBase;
import com.solvd.shop24.gui.desktop.pages.HomePage;
import com.solvd.shop24.gui.desktop.pages.purchase.ProductPage;
import com.solvd.shop24.gui.desktop.pages.purchase.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class SearchProductsTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "yantoniuk")
    public void testSearchProduct() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");

        SearchPageBase searchPage = homePage.getMenu().searchProductBySearchField("когтеточка");
        Assert.assertEquals(searchPage.getMenu().getSearchInputFieldText(),"когтеточка",
                "Invalid typed text!");
        int productIndex = new Random().nextInt(searchPage.getProducts().size() - 1);
        String searchProductTitle = searchPage.getItem(productIndex).getTitle();
        Assert.assertTrue(searchProductTitle.matches(".*[Кк]огтеточка.*"), "product hasn't a title!");

        ProductPageBase productPage = searchPage.getItem(productIndex).openItem();
        Assert.assertTrue(productPage.getTitle().contains(searchProductTitle),
                "searched item's title and current product item's title are not equals!");
    }
}
