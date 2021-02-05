package com.solvd.carina.demo.shop24;

import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.pages.shop24.HomePage;
import com.solvd.carina.demo.gui.pages.shop24.profile.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTest extends BaseTest {
//1. Page is opened
//2. Search input field has typed text (for example: "Когтеточка")
//3. ProductPage is opened (random product item has price and title,
// which contain typed text). For example:
//"Когтеточка Trixie Sisal 43071 (бежевый)" contains "Когтеточка"

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "yantoniuk")
    public void successAuthentication() {
        String phoneNumber = "444544281";
        String password = "cmn0hd";
        HomePage homePage = openHomePage(getDriver());
        ProfilePage profilePage = homePage.getMenu().authorization(phoneNumber, password);
        Assert.assertEquals(getDriver().getCurrentUrl(),
                "https://24shop.by/cabinet/settings/", "authentication is failed!");
        Assert.assertEquals(profilePage.getName(), "Alex", "invalid name!");
        Assert.assertEquals(profilePage.getEmail(), "y@mail.ru", "invalid email!");
        Assert.assertEquals(profilePage.getPhoneNumber(), "+375 44 454-42-81",
                "invalid phone number!");
    }

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "yantoniuk")
    public void failedAuthentication() {
        String phoneNumber = "444544281";
        String password = "invalid11";
        HomePage homePage = openHomePage(getDriver());
        homePage.getMenu().authorization(phoneNumber, password);
        Assert.assertEquals(getDriver().getCurrentUrl(),
                "https://24shop.by/personal/auth.php?login=yes",
                "failed authentication was expected!");
    }
}
