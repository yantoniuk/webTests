package com.solvd.carina.demo.shop24;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.pages.shop24.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTest extends BaseTest {

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "yantoniuk")
    public void SuccessAuthenticationTest() {
        String phoneNumber = "444544281";
        String password = "cmn0hd";
        HomePage homePage = openHomePage(getDriver());
        homePage.authorization(phoneNumber, password);
        Assert.assertEquals(getDriver().getCurrentUrl(),
                "https://24shop.by/cabinet/settings/", "authentication is failed!");
    }

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "yantoniuk")
    public void FailedAuthenticationTest() {
        String phoneNumber = "444544281";
        String password = "invalid11";
        HomePage homePage = openHomePage(getDriver());
        homePage.authorization(phoneNumber, password);
        Assert.assertEquals(getDriver().getCurrentUrl(),
                "https://24shop.by/personal/auth.php?login=yes",
                "failed authentication was expected!");
    }
}
