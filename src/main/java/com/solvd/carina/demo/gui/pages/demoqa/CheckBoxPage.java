package com.solvd.carina.demo.gui.pages.demoqa;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.pages.demoqa.constant.ElementsConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckBoxPage extends AbstractPage {

    @FindBy(id = "tree-node-home")
    private ExtendedWebElement homeCheckBox;

    @FindBy(xpath = "//div[@class='rct-options']/button[1]")
    private ExtendedWebElement plusButton;

    @FindBy(xpath = "//div[@class='rct-options']/button[2]")
    private ExtendedWebElement minusButton;

    public CheckBoxPage(WebDriver driver) {
        super(driver);
        setPageURL("/checkbox");
    }

    public void selectHomeCheckbox() {
        if (!homeCheckBox.isChecked()) {
            homeCheckBox.click();
        }
    }

    public boolean isSelectedHomeCheckbox() {
        return homeCheckBox.isChecked();
    }

    public void openAllFolders() {
        plusButton.click();
    }

    public void closeAllFolders() {
        minusButton.click();
    }

    public int filesCount() {
        List<ExtendedWebElement> folders = findExtendedWebElements(ElementsConstant.FOLDERS);
        folders.forEach(el -> System.out.println(el.getText()));
        return folders.size();
    }
}
