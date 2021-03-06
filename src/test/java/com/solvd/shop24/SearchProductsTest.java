package com.solvd.shop24;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.pages.purchase.ProductPageBase;
import com.solvd.shop24.gui.common.pages.purchase.SearchPageBase;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

public class SearchProductsTest extends AbstractTest {

    private WebDriver driver;

    @BeforeMethod
    @Parameters({"browserName"})
    private void up(String browserName) {
        driver = getDriver(browserName);
    }

    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "yantoniuk")
    @XlsDataSourceParameters(path = "xls/Book1.xlsx", sheet = "Products",
            dsUid = "TUID" , dsArgs = "name")
    public void testSearchProduct(String name) {
        HomePageBase homePage = initPage(this.driver, HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");

        SearchPageBase searchPage = homePage.getMenu().searchProductBySearchField(name);
        Assert.assertEquals(searchPage.getMenu().getSearchInputFieldText(), name,
                "Invalid typed text!");
        int productIndex = new Random().nextInt(searchPage.getProducts().size() - 1);
        String searchProductTitle = searchPage.getItem(productIndex).getTitle();
        Assert.assertTrue(searchProductTitle.contains(name.substring(1, name.length() - 2)), "product hasn't a title!");

        ProductPageBase productPage = searchPage.getItem(productIndex).openItem();
        Assert.assertTrue(productPage.getTitle().contains(searchProductTitle),
                "searched item's title and current product item's title are not equals!");
    }

}