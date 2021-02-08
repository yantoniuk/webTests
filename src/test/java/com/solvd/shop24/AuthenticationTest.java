package com.solvd.shop24;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.shop24.gui.pages.HomePage;
import com.solvd.shop24.gui.pages.profile.AuthenticationPage;
import com.solvd.shop24.gui.pages.profile.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AuthenticationTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "yantoniuk")
    public void testSuccessAuthentication() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page wasn't opened!");

        AuthenticationPage authenticationPage = homePage.navigateToAuthentificationPage();
        authenticationPage.assertPageOpened();

        ProfilePage profilePage = authenticationPage.authentication(R.TESTDATA.get("account.phoneNumber").substring(4),
                R.TESTDATA.get("account.password"));
        profilePage.assertPageOpened();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(profilePage.getName(), R.TESTDATA.get("account.name"), "Invalid name!");
        softAssert.assertEquals(profilePage.getEmail(), R.TESTDATA.get("account.email"), "Invalid email!");
        softAssert.assertEquals(profilePage.getPhoneNumber(), R.TESTDATA.get("account.phoneNumber"),
                "Invalid phone number!");
        softAssert.assertAll();
    }
}
