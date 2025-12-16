package mobile_tests;

import config.AppiumConfig;
import dto.RegistrationBodyDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.SearchScreen;
import screens.SplashScreen;

public class LogoutTests extends AppiumConfig {
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
    public void logoutPositiveTest(){
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnLogout();
        searchScreen.clickBtnDots();
        Assert.assertTrue(searchScreen
                .isElementPresent_BtnLogin("Login"));
    }
}
