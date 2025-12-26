package mobile_tests;

import config.AppiumConfig;
import dto.CarDto;
import dto.RegistrationBodyDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

import java.util.Random;

public class AddNewCarTests extends AppiumConfig {
    @BeforeMethod
    public void login(){
        new SplashScreen(driver).goToSearchScreen(7);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnLogin();
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("sima_simonova370@gmail.com")
                .password("BSas124!")
                .build();
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnYalla();
    }

    @Test
    public void addNewCarPositiveTest(){
        int i = new Random().nextInt(1000);
        CarDto car = CarDto.builder()
                .serialNumber("345-"+i)
                .manufacture("Mazda")
                .model("cx-30")
                .city("Haifa")
                .pricePerDay(1.34)
                .carClass("A")
                .year("2023")
                .fuel("Diesel")
                .seats(4)
                .build();
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnMyCars();
        new MyCarsScreen(driver).clickBtnAddNewCar();
        AddNewCarScreen addNewCarScreen = new AddNewCarScreen(driver);
        addNewCarScreen.typeAddNewCarForm(car);
        addNewCarScreen.clickBtnAddNewCar();
        Assert.assertTrue(new MyCarsScreen(driver)
                .isTextInPopUpMessageSuccessPresent("Car was added!",
                        3));
    }

    @Test
    public void addNewCarNegativeTest_DuplicateSerialNumber(){
        CarDto car = CarDto.builder()
                .serialNumber("345-843")
                .manufacture("Mazda")
                .model("cx-30")
                .city("Haifa")
                .pricePerDay(1.34)
                .carClass("A")
                .year("2023")
                .fuel("Diesel")
                .seats(4)
                .build();
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnMyCars();
        new MyCarsScreen(driver).clickBtnAddNewCar();
        AddNewCarScreen addNewCarScreen = new AddNewCarScreen(driver);
        addNewCarScreen.typeAddNewCarForm(car);
        addNewCarScreen.clickBtnAddNewCar();
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("already exists"));

    }

    @Test
    public void addNewCarNegativeTest_EmptyFields(){
        CarDto car = CarDto.builder()
                .serialNumber("")
                .manufacture("")
                .model("")
                .city("")
                .pricePerDay(0)
                .carClass("")
                .year("")
                .fuel("")
                .seats(0)
                .build();
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnMyCars();
        new MyCarsScreen(driver).clickBtnAddNewCar();
        AddNewCarScreen addNewCarScreen = new AddNewCarScreen(driver);
        addNewCarScreen.typeAddNewCarForm(car);
        addNewCarScreen.clickBtnAddNewCar();
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("is required!"));

    }

    @Test
    public void addNewCarNegativeTest_WrongField_Year_BUG(){
        int i = new Random().nextInt(1000);
        CarDto car = CarDto.builder()
                .serialNumber("345-"+i)
                .manufacture("Mazda")
                .model("cx-30")
                .city("Haifa")
                .pricePerDay(1.34)
                .carClass("A")
                .year("ф")
                .fuel("Diesel")
                .seats(4)
                .build();
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnMyCars();
        new MyCarsScreen(driver).clickBtnAddNewCar();
        AddNewCarScreen addNewCarScreen = new AddNewCarScreen(driver);
        addNewCarScreen.typeAddNewCarForm(car);
        addNewCarScreen.clickBtnAddNewCar();

    }
}
