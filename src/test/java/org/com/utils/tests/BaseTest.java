package org.com.utils.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.com.screens.HomeScreen;
import org.com.screens.MenuBar;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTest {
    private static final String PROPERTIES_FILE = "src/test/resources/config.properties";
    private static final Properties PROPERTIES = new Properties();
    public static AndroidDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void enviromentSetUp() {
        loadProperties();
        UiAutomator2Options capabilities = new UiAutomator2Options();
        setUpCapabilities(capabilities);
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        }catch (MalformedURLException exception){
            System.out.println(exception.getMessage());
        }
    }


    public void loadProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE);
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Error loading the properties file " + PROPERTIES_FILE);
        }
    }


    public static void setUpCapabilities(UiAutomator2Options capabilities) {
        capabilities.setPlatformName(getCapability("platformName"));
        capabilities.setDeviceName(getCapability("deviceName"));
        capabilities.setAppPackage(getCapability("appPackage"));
        capabilities.setAppActivity(getCapability("appActivity"));

    }


    public static String getCapability(String variable) {
        return PROPERTIES.getProperty(variable);
    }

    public MenuBar returnMenu(){
        return new MenuBar(driver);
    }

    public HomeScreen returnHomeScreen(){
        return new HomeScreen(driver);
    }


}
