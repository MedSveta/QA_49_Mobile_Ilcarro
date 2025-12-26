package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static config.AppiumConfig.*;

public class MyCarsScreen extends BaseScreen {
    public MyCarsScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.telran.ilcarro:id/addCarBtn")
    WebElement btnAddNewCar;
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Car was added!']")
    WebElement popUpMessageSuccess;
    @AndroidFindBy(id = "android:id/button1")
    WebElement btnYes;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.telran.ilcarro:id/myCarSerialTxt']")
    List<WebElement> carNumberList;

    public void clickBtnAddNewCar() {
        clickWait(btnAddNewCar, 3);
    }

    public boolean isTextInPopUpMessageSuccessPresent(String text, int time) {
        return isTextInElementPresent(popUpMessageSuccess, text, time);
    }

    public void deleteCar() {
        swipe(width / 8, height / 4, width / 8 * 7, height / 4);
    }

    public void clickBtnYes(){
        clickWait(btnYes, 3);
    }

    public List<String> readCarList(){
        List<String> list = new ArrayList<>();
        for (WebElement el: carNumberList){
           list.add(el.getText());
        }
        return list;
    }
}





