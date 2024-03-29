package org.com.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.com.utils.screens.BaseScreen;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    private static final String TITLE = "UiSelector().className(android.widget.TextView).text(\"WEBDRIVER\")";
    @AndroidFindBy (uiAutomator = TITLE)
    private WebElement title;

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public WebElement getTitle() {
        return title;
    }

    public void setTitle(WebElement title) {
        this.title = title;
    }
}
