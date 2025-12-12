package screens;

import dto.RegistrationBodyDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.telran.ilcarro:id/editLoginEmail")
    WebElement fieldLoginEmail;
    @AndroidFindBy(id = "com.telran.ilcarro:id/editLoginPassword")
    WebElement fieldLoginPassword;
    @AndroidFindBy(id = "com.telran.ilcarro:id/loginBtn")
    WebElement btnYalla;

    public void typeLoginForm(RegistrationBodyDto user){
        fieldLoginEmail.sendKeys(user.getUsername());
        fieldLoginPassword.sendKeys(user.getPassword());
    }

    public void clickBtnYalla(){
        btnYalla.click();
    }
}
