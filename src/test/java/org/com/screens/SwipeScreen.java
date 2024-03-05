package org.com.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.com.utils.screens.BaseScreen;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SwipeScreen extends BaseScreen {

    private static final String TITLE = "UiSelector().className(android.widget.TextView).text(\"Swipe horizontal\")";
    private static final String TEXT = "UiSelector().descriptionContains(\"card\")";
    private static final String TEXT2 = "UiSelector().className(android.widget.TextView).text(\"FULLY OPEN SOURCE\")";



    @AndroidFindBy (uiAutomator = TITLE)
    private WebElement title;

    @AndroidFindBy(uiAutomator = TEXT)
    private List<WebElement> boxList;

    @AndroidFindBy(uiAutomator = TEXT2)
    private WebElement firstBox;


    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    public WebElement getTitle() {
        return title;
    }

    public List<WebElement> getBoxList() {
        return boxList;
    }

    public WebElement getFirstBox() {
        return firstBox;
    }
}
