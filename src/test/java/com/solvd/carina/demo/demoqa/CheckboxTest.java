package com.solvd.carina.demo.demoqa;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.pages.demoqa.CheckBoxPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxTest extends AbstractTest {

    private CheckBoxPage checkBoxPage;

    @BeforeTest()
    public void up() {
        CheckBoxPage checkBoxPage = new CheckBoxPage(getDriver());
        checkBoxPage.open();
        getDriver().manage().window().fullscreen();
        Assert.assertTrue(checkBoxPage.isPageOpened(), "checkBoxPage was not opened!");
    }

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "yantoniuk")
    public void selectHomeCheckboxTest() {
        checkBoxPage.selectHomeCheckbox();
        Assert.assertTrue(checkBoxPage.isSelectedHomeCheckbox(), "cannot select home checkbox");
    }

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "yantoniuk")
    public void openAllFoldersTest() {
        checkBoxPage.openAllFolders();
        Assert.assertTrue(checkBoxPage.filesCount() > 0, "cannot find files!");
    }

    @AfterTest()
    public void down() {
        getDriver().close();
    }
}
