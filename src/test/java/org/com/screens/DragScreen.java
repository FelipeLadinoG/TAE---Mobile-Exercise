package org.com.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.com.utils.screens.BaseScreen;
import org.openqa.selenium.WebElement;

public class DragScreen extends BaseScreen {

    private static final String TITLE = "UiSelector().className(android.widget.TextView).text(\"Drag and Drop\")";

    @AndroidFindBy (uiAutomator = TITLE)
    private WebElement title;

    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    public WebElement getTitle() {
        return title;
    }
}
