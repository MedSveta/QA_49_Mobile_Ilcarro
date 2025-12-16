package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SearchScreen extends BaseScreen {
    public SearchScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    WebElement btnDots;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com." +
            "telran.ilcarro:id/title' and @text='Login']")
    WebElement btnLogin;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com." +
            "telran.ilcarro:id/title' and @text='Registration']")
    WebElement btnRegistration;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.telran.ilcarro:id/title'" +
            " and @text='My Cars']")
    WebElement btnMyCars;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.telran.ilcarro:id/title'" +
            " and @text='Logout']")
    WebElement btnLogout;

    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Login success!']")
    WebElement popUpMessageLoginSuccess;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Registration success!']")
    WebElement popUpMessageRegistrationSuccess;

    public boolean validatePopUpMessageLoginSuccess(String text) {
        return isTextInElementPresent(popUpMessageLoginSuccess, text, 5);
    }

    public boolean validatePopUpMessageRegistrationSuccess(String text) {
        return isTextInElementPresent(popUpMessageRegistrationSuccess, text, 5);
    }

    public boolean isElementPresent_BtnLogin(String text){
        return isTextInElementPresent(btnLogin, text, 5);
    }

    public void clickBtnMyCars() {
        clickWait(btnMyCars, 3);
    }

    public void clickBtnLogout() {
        clickWait(btnLogout, 3);
    }

    public void clickBtnDots() {
        clickWait(btnDots, 3);
    }

    public void clickBtnLogin() {
        clickWait(btnLogin, 3);
    }

    public void clickBtnRegistration() {
        clickWait(btnRegistration, 3);
    }
}
