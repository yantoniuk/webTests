package com.solvd.carina.demo.demoqa;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.pages.demoqa.DynamicPropertiesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicPropertiesTest extends AbstractTest {

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "yantoniuk")
    public void checkButtonsTest() {
        DynamicPropertiesPage propertiesPage = new DynamicPropertiesPage(getDriver());
        propertiesPage.open();
        propertiesPage.clickButton();
    }
}
