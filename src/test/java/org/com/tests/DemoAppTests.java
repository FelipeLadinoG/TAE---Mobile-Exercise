package org.com.tests;

import org.com.screens.*;
import org.com.screens.MenuBar;
import org.com.utils.enums.TestMsgs;
import org.com.utils.tests.BaseTest;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class DemoAppTests extends BaseTest {

    private String email, password;

    @Test
    public void optionsNavigation() {
        MenuBar menuBar = returnMenu();
        HomeScreen homeScreen = returnHomeScreen();
        Assert.assertTrue(homeScreen.isDisplayed(homeScreen.getTitle()));


        menuBar.tapWebView();
        WebViewScreen webViewScreen = returnWebViewScreen();
        webViewScreen.waitUntil(webViewScreen.getMenu());
        //if the execution is slowly, it could fail
        Assert.assertTrue(webViewScreen.isDisplayed(webViewScreen.getMenu()), TestMsgs.ELEMENT_MSG.getValue());

        menuBar.tapLogin();
        LogInScreen logInScreen = returnLoginScreen();
        logInScreen.waitUntil(logInScreen.getLoginBtn());
        Assert.assertTrue(logInScreen.isDisplayed(logInScreen.getLoginBtn()), TestMsgs.ELEMENT_MSG.getValue());


        menuBar.tapForms();
        FormsScreen formsScreen = returnFormsScreen();
        formsScreen.waitUntil(formsScreen.getTitle());
        Assert.assertTrue(formsScreen.isDisplayed(formsScreen.getTitle()), TestMsgs.ELEMENT_MSG.getValue());

        menuBar.tapSwipe();
        SwipeScreen swipeScreen = returnSwipeScreen();
        swipeScreen.waitUntil(swipeScreen.getTitle());
        Assert.assertTrue(swipeScreen.isDisplayed(swipeScreen.getTitle()), TestMsgs.ELEMENT_MSG.getValue());


        menuBar.tapDrag();
        DragScreen dragScreen = returnDragScreen();
        dragScreen.waitUntil(dragScreen.getTitle());
        Assert.assertTrue(dragScreen.isDisplayed(dragScreen.getTitle()), TestMsgs.ELEMENT_MSG.getValue());
    }


    @Test(dependsOnMethods = "optionsNavigation")
    public void signIn() {
        MenuBar menuBar = returnMenu();
        menuBar.tapLogin();
        LogInScreen logInScreen = returnLoginScreen();
        logInScreen.tapSignUp();
        SignUpScreen signUpScreen = returnSignUpScreen();
        this.email = generateRandomString(true);
        this.password = generateRandomString(false);
        signUpScreen.sendKeys(email, password, password);
        signUpScreen.swipeUp();
        signUpScreen.tapSignUpBtn();
        signUpScreen.waitUntil(signUpScreen.getSignedUpMsg());
        Assert.assertTrue(signUpScreen.isDisplayed(signUpScreen.getSignedUpMsg()), TestMsgs.SIGN_IN_MSG.getValue());
        quitApp();
    }


    @Test(dependsOnMethods = "signIn")
    public void login() {
        MenuBar menuBar = returnMenu();
        menuBar.tapLogin();
        LogInScreen logInScreen = returnLoginScreen();
        logInScreen.sendKeys(email, password);
        logInScreen.tapLoginBtn();
        logInScreen.waitUntil(logInScreen.getSuccessMsg());
        Assert.assertTrue(logInScreen.isDisplayed(logInScreen.getSuccessMsg()), TestMsgs.LOGIN_MSG.getValue());
        quitApp();
    }


    @Test(dependsOnMethods = "login")
    public void swipe() throws InterruptedException {
        MenuBar menuBar = returnMenu();
        menuBar.tapSwipe();
        SwipeScreen swipeScreen = returnSwipeScreen();
        swipeScreen.waitUntil(swipeScreen.getTitle());

        swipeScreen.swipeLeft(4);
        boolean isElementDisplayed = true;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOf(swipeScreen.getFirstBox()));
        } catch (TimeoutException | NoSuchElementException e) {
            isElementDisplayed = false;
        }

        Assert.assertFalse(isElementDisplayed, TestMsgs.ELEMENT_MSG.getValue());
        Assert.assertEquals(swipeScreen.getBoxList().size(), 1, TestMsgs.LAST_CARD_MSG.getValue());
        quitApp();

    }


}
