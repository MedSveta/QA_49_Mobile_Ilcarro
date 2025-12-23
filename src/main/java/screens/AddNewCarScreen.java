package screens;

import dto.CarDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.AppiumConfig.*;

public class AddNewCarScreen extends BaseScreen {
    public AddNewCarScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.telran.ilcarro:id/editSerial")
    WebElement fieldSerialNumber;
    @AndroidFindBy(id = "com.telran.ilcarro:id/editMan")
    WebElement fieldManufacture;
    @AndroidFindBy(id = "com.telran.ilcarro:id/editModel")
    WebElement fieldModel;
    @AndroidFindBy(id = "com.telran.ilcarro:id/editCity")
    WebElement fieldCity;
    @AndroidFindBy(id = "com.telran.ilcarro:id/editPrice")
    WebElement fieldPrice;
    @AndroidFindBy(id = "com.telran.ilcarro:id/editCarClass")
    WebElement fieldCarClass;
    @AndroidFindBy(id = "com.telran.ilcarro:id/text1")
    WebElement fieldFuel;
    @AndroidFindBy(id = "com.telran.ilcarro:id/editYear")
    WebElement fieldYear;
    @AndroidFindBy(id = "com.telran.ilcarro:id/editSeats")
    WebElement fieldSeats;
    @AndroidFindBy(id = "com.telran.ilcarro:id/addCarBtn")
    WebElement btnAddNewCar;

    public void typeAddNewCarForm(CarDto car) {
        fieldSerialNumber.sendKeys(car.getSerialNumber());
        fieldManufacture.sendKeys(car.getManufacture());
        fieldModel.sendKeys(car.getModel());
        fieldCity.sendKeys(car.getCity());
        fieldPrice.sendKeys(car.getPricePerDay() + "");
        fieldCarClass.sendKeys(car.getCarClass());
        //swipe(500, 1500, 500, 300);
        System.out.println(height + "x" + width);
        swipe(width / 2, (int) (height * 0.8),
                width / 2, (int) (height * 0.2));
        typeFuel(car.getFuel());
        fieldYear.sendKeys(car.getYear());
        fieldSeats.sendKeys(Integer.toString(car.getSeats()));
    }

    public void clickBtnAddNewCar(){
        clickWait(btnAddNewCar, 3);
    }


    private void typeFuel(String fuel) {
        fieldFuel.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("//*[@text='" + fuel + "']")))
                .click();
    }

}
