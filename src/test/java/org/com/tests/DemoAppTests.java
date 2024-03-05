package org.com.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.com.screens.LogInScreen;
import org.com.screens.MenuBar;
import org.com.screens.SignUpScreen;
import org.com.utils.tests.BaseTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoAppTests extends BaseTest {

//    @Test
//    public void optionsNavigation (){
//        MenuBar menuBar = returnMenu();
//        menuBar.tapWebView();
//        menuBar.tapLogin();
//        menuBar.tapForms();
//        menuBar.tapSwipe();
//        menuBar.tapDrag();
//    }

    @Test
    public void signIn (){
        MenuBar menuBar = returnMenu();
        menuBar.tapLogin();
        LogInScreen logInScreen = returnLoginScreen();
        logInScreen.tapSignUp();
        SignUpScreen signUpScreen = returnSignUpScreen();
        signUpScreen.sendKeys("omar","felipe", "felipe");
        signUpScreen.swipeDown();
        signUpScreen.tapSignUpBtn();
    }

//    @Test
//    public void login (){
//        MenuBar menuBar = returnMenu();
//        menuBar.tapLogin();
//        LogInScreen logInScreen = returnLoginScreen();
//        logInScreen.sendKeys("Omar", "Felipe");
//        logInScreen.tapLoginBtn();
//    }


}
