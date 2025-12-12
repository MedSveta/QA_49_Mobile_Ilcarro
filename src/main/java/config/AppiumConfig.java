package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfig {
    public static AppiumDriver driver;
    private final String APPIUM_URL = "http://127.0.0.1:4723";

//    {
//        "platformName": "Android",
//            "automationName": "UiAutomator2",
//            "deviceName": "Pixel",
//            "appPackage": "com.telran.ilcarro",
//            "appActivity": ".SplashActivity"
//    }
    @BeforeMethod
    public void setup(){
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName("Pixel")
                .setAppPackage("com.telran.ilcarro")
                .setAppActivity(".SplashActivity");

    try {
        driver = new AppiumDriver(new URL(APPIUM_URL), options);
    } catch (MalformedURLException e) {
        throw new RuntimeException(e);
    }

    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        if(driver!= null)
            driver.quit();
    }

}
