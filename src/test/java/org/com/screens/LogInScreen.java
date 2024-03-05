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
    private static final String SUCCESS_MSG = "UiSelector().className(android.widget.TextView).text(\"Success\")";

    @AndroidFindBy(accessibility = EMAIL)
    WebElement emailField;

    @AndroidFindBy(accessibility = PASSWORD)
    WebElement passwordField;

    @AndroidFindBy(accessibility = LOGIN)
    WebElement loginBtn;

    @AndroidFindBy(uiAutomator = SIGN_UP)
    WebElement signUp;

    @AndroidFindBy(uiAutomator = SUCCESS_MSG)
    WebElement successMsg;


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

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public WebElement getSuccessMsg() {
        return successMsg;
    }
}
