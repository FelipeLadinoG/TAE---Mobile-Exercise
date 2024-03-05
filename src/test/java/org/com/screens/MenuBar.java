package org.com.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.com.utils.screens.BaseScreen;
import org.openqa.selenium.WebElement;

public class MenuBar extends BaseScreen {
    private static final String HOME = "Home";
    private static final String WEB_VIEW = "Webview";
    private static final String LOGIN = "Login";
    private static final String FORMS = "Forms";
    private static final String SWIPE = "Swipe";
    private static final String DRAG = "Drag";
    @AndroidFindBy(accessibility = HOME)
    private WebElement homeOption;
    @AndroidFindBy(accessibility = WEB_VIEW)
    private WebElement webViewOption;

    @AndroidFindBy(accessibility = LOGIN)
    private WebElement loginOption;

        @AndroidFindBy(accessibility = FORMS)
    private WebElement formsOption;

    @AndroidFindBy(accessibility = SWIPE)
    private WebElement swipeOption;

    @AndroidFindBy(accessibility = DRAG)
    private WebElement dragOption;


    public MenuBar(AndroidDriver driver) {
        super(driver);
    }

    public void tapHomeView (){
        homeOption.click();
    }

    public void tapWebView (){
        webViewOption.click();
    }

    public void tapLogin (){
        waitUntil(loginOption);
        loginOption.click();
    }

    public void tapForms (){
        formsOption.click();
    }

    public void tapSwipe (){
        swipeOption.click();
    }

    public void tapDrag (){
        dragOption.click();
    }


}
