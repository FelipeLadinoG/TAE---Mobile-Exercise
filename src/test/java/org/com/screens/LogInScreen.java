package org.com.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.com.utils.screens.BaseScreen;
import org.openqa.selenium.WebElement;

public class LogInScreen extends BaseScreen {

    private static final String EMAIL = "input-email";
    private static final String PASSWORD = "input-password";
    private static final String LOGIN = "button-LOGIN";
    private static final String SIGN_UP = "UiSelector().className(android.widget.TextView).text(\"Sign up\")";

    @AndroidFindBy(accessibility = EMAIL)
    WebElement emailField;

    @AndroidFindBy(accessibility = PASSWORD)
    WebElement passwordField;

    @AndroidFindBy(accessibility = LOGIN)
    WebElement loginBtn;

    @AndroidFindBy(uiAutomator = SIGN_UP)
    private WebElement signUp;


    public LogInScreen(AndroidDriver driver) {
        super(driver);
    }

    public void sendKeys (String email, String password){
        waitUntil(emailField);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public void tapLoginBtn(){
        loginBtn.click();
    }

    public void tapSignUp(){
        signUp.click();
    }
}
