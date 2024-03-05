package org.com.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.com.utils.screens.BaseScreen;
import org.openqa.selenium.WebElement;

public class SignUpScreen extends BaseScreen {

    private static final String EMAIL = "input-email";
    private static final String PASSWORD = "input-password";
    private static final String CONFIRM_PASSWORD = "input-repeat-password";
    private static final String SIGN_UP = "UiSelector().className(android.widget.TextView).text(\"SIGN UP\")";

    @AndroidFindBy(accessibility = EMAIL)
    WebElement emailField;

    @AndroidFindBy(accessibility = PASSWORD)
    WebElement passwordField;

    @AndroidFindBy(accessibility = CONFIRM_PASSWORD)
    WebElement confirmField;

    @AndroidFindBy(uiAutomator = SIGN_UP)
    WebElement signUpBtn;
    public SignUpScreen(AndroidDriver driver) {
        super(driver);
    }

    public void sendKeys (String email, String password, String confirm){
        waitUntil(emailField);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmField.sendKeys(confirm);
    }

    public void tapSignUpBtn (){
         signUpBtn.click();
    }

    public WebElement getSignUpBtn() {
        return signUpBtn;
    }

    public void setSignUpBtn(WebElement signUpBtn) {
        this.signUpBtn = signUpBtn;
    }
}
