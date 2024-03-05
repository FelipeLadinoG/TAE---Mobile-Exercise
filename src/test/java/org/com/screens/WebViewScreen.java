package org.com.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.com.utils.screens.BaseScreen;
import org.openqa.selenium.WebElement;

public class WebViewScreen extends BaseScreen {

    private static final String TITLE = "Toggle navigation bar";
    @AndroidFindBy (accessibility = TITLE)
    private WebElement menu;

    public WebViewScreen(AndroidDriver driver) {
        super(driver);
    }

    public WebElement getMenu() {
        return menu;
    }
}
