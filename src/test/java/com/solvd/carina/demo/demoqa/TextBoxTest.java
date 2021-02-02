package com.solvd.carina.demo.demoqa;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.pages.demoqa.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TextBoxTest extends AbstractTest {

    private TextBoxPage textBoxPage;

    @BeforeTest()
    public void up() {
        this.textBoxPage = new TextBoxPage(getDriver());
        textBoxPage.open();
        getDriver().manage().window().fullscreen();
        Assert.assertTrue(textBoxPage.isPageOpened(), "Text box page was not opened!");
    }

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "yantoniuk")
    public void simpleTest() {
        Assert.assertEquals(textBoxPage.getTitle(), "Text Box",
                "text of title has different value!");
    }

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "yantoniuk")
    public void sendFormTest() {
        textBoxPage.typeFullName("Antoniuk Yana V");
        textBoxPage.typeEmail("yantoniuk@gmail.com");
        textBoxPage.typeCurrentAddress("street Odincova house 20");
        textBoxPage.typePermanentAddress("hi!");
        textBoxPage.submit();
        String userInfo = textBoxPage.getInfo();
        System.out.println(userInfo);
        Assert.assertFalse(userInfo.isEmpty(), "Empty information about user!");
    }

    @AfterTest()
    public void down() {
        getDriver().close();
    }
}
