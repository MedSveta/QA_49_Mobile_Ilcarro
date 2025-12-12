package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SplashScreen extends BaseScreen {
    public SplashScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.telran.ilcarro:id/versionText")
    WebElement versionApp;

    public boolean validateVersion() {
        return isTextInElementPresent(versionApp,
                "Version 1.0.0", 5);
    }

    public void goToSearchScreen(int time) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(time))
                    .until(ExpectedConditions.presenceOfElementLocated(By
                            .id("com.telran.ilcarro:id/findTitle")));
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("element not found");
        }
    }
}
