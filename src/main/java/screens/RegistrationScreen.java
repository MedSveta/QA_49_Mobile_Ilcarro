package screens;

import dto.RegistrationBodyDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class RegistrationScreen extends BaseScreen{
    public RegistrationScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.telran.ilcarro:id/editRegName")
    WebElement fieldName;
    @AndroidFindBy(id = "com.telran.ilcarro:id/editRegLastName")
    WebElement fieldLastName;
    @AndroidFindBy(id = "com.telran.ilcarro:id/editRegEmail")
    WebElement fieldEmail;
    @AndroidFindBy(id = "com.telran.ilcarro:id/editRegPassword")
    WebElement fieldPassword;
    @AndroidFindBy(id="com.telran.ilcarro:id/checkBoxAgree")
    WebElement checkBox;
    @AndroidFindBy(id="com.telran.ilcarro:id/regBtn")
    WebElement btnYalla;

    public void typeRegistrationForm(RegistrationBodyDto user){
        fieldName.sendKeys(user.getFirstName());
        fieldLastName.sendKeys(user.getLastName());
        fieldEmail.sendKeys(user.getUsername());
        fieldPassword.sendKeys(user.getPassword());
    }

    public void clickCheckBox(){
        checkBox.click();
    }
    public void clickBtnYalla(){
        btnYalla.click();
    }
}
