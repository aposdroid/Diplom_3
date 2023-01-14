package RegistrationTest;

import POM.LoginPage;
import POM.MainPage;
import POM.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.github.javafaker.Faker;
import java.time.Duration;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.chrome.ChromeOptions;

public class SuccessfulRegistrationTest {
    private WebDriver driver;
    Faker faker = new Faker();

    @Before
    public void setUpChrome(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    @DisplayName("Проверь успешную регистрацию")
    public void successfulRegistration(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.open();
        mainPage.clickAccountButton();
        loginPage.clickRegisterButton();
        registerPage.inputName(faker.name().firstName());
        registerPage.inputEmail(faker.internet().emailAddress());
        registerPage.inputPassword(faker.internet().password(6, 9));
        registerPage.clickFinallyRegisterButton();
        loginPage.checkRegistrationIsSuccessfully();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}