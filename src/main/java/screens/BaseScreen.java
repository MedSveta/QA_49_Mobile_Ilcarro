package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {
    static AppiumDriver driver;

    public BaseScreen(AppiumDriver driver) {
        BaseScreen.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver,
                Duration.ofSeconds(10)), this);
    }

    public void clickWait(WebElement element, int time){
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    public boolean isTextInElementPresent(WebElement element,
                                          String text, int time){
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions
                        .textToBePresentInElement(element, text));
    }
}
