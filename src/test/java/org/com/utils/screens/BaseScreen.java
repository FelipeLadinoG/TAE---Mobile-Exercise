package org.com.utils.screens;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseScreen {
    protected AndroidDriver driver;

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitUntil(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void swipeUp (){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", "up",
                "percent", 0.75
        ));
    }

    public void swipeLeft (int n) throws InterruptedException {
        for (int i = 0; i <=n ; i++) {
            ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "left", 550, "top", 1000, "width", 200, "height", 200,
                    "direction", "left",
                    "percent", 0.75
            ));
            Thread.sleep(3000);
        }
    }


    public boolean isDisplayed (WebElement webElement){
        return webElement.isDisplayed();
    }


}
