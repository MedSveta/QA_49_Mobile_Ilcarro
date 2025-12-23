package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

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

    public void swipe(int startX, int startY, int endX, int endY){
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO,
                        PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(600),
                        PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipe));
    }
}
