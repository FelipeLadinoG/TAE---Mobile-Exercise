package org.com.utils.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.com.screens.*;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;

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
        } catch (MalformedURLException exception) {
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

    public static String generateRandomString(boolean generateEmail) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789"; // Caracteres permitidos
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) { // Longitud del nombre de usuario (puedes ajustarlo según tus necesidades)
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            result.append(randomChar);
        }
        if (generateEmail)
            result.append("@correo.com");
        return result.toString();
    }


    public static String getCapability(String variable) {
        return PROPERTIES.getProperty(variable);
    }

    public void quitApp(){
        driver.quit();
    }

    public MenuBar returnMenu() {
        return new MenuBar(driver);
    }

    public HomeScreen returnHomeScreen() {
        return new HomeScreen(driver);
    }

    public WebViewScreen returnWebViewScreen() {
        return new WebViewScreen(driver);
    }

    public LogInScreen returnLoginScreen() {
        return new LogInScreen(driver);
    }

    public SignUpScreen returnSignUpScreen() {
        return new SignUpScreen(driver);
    }

    public FormsScreen returnFormsScreen() {
        return new FormsScreen(driver);
    }

    public SwipeScreen returnSwipeScreen() {
        return new SwipeScreen(driver);
    }

    public DragScreen returnDragScreen() {
        return new DragScreen(driver);
    }


}
