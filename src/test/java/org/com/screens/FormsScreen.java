package org.com.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.com.utils.screens.BaseScreen;
import org.openqa.selenium.WebElement;

public class FormsScreen extends BaseScreen {

    private static final String TITLE = "UiSelector().className(android.widget.TextView).text(\"Form components\")";

    @AndroidFindBy (uiAutomator = TITLE)
    private WebElement title;

    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }

    public WebElement getTitle() {
        return title;
    }
}
