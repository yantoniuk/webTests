package com.solvd.shop24;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.crypto.CryptoConsole;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.shop24.gui.common.pages.HomePageBase;
import com.solvd.shop24.gui.common.pages.profile.AuthenticationPageBase;
import com.solvd.shop24.gui.common.pages.profile.ProfilePageBase;
import org.junit.After;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AuthenticationTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "yantoniuk")
    public void testSuccessAuthentication() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");
        System.out.println();
        AuthenticationPageBase authenticationPage = homePage.getMenu().navigateToAuthenticationPage();
        Assert.assertTrue(authenticationPage.isPageOpened(), "Authentication page wasn't opened!");
        ProfilePageBase profilePage = authenticationPage.authentication(R.TESTDATA.get("account.authPhoneNumber"),
                R.TESTDATA.get("account.password"));
        Assert.assertTrue(profilePage.isPageOpened(), "Profile page wasn't opened!");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(profilePage.getName(), R.TESTDATA.get("account.name"), "Invalid name!");
        softAssert.assertEquals(profilePage.getEmail(), R.TESTDATA.get("account.email"), "Invalid email!");
        softAssert.assertEquals(profilePage.getPhoneNumber(), R.TESTDATA.get("account.phoneNumber"),
                "Invalid phone number!");
        softAssert.assertAll();
    }
}
