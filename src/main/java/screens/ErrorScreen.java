package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ErrorScreen extends BaseScreen {
    public ErrorScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "android:id/message")
    WebElement errorMessage;

    public boolean validateErrorMessage(String text){
        return isTextInElementPresent(errorMessage, text, 5);
    }
}
