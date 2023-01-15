package registration;

import pom.LoginPage;
import pom.MainPage;
import pom.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.github.javafaker.Faker;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ShortPasswordErrorTest {
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
        @DisplayName("Проверь ошибку для некорректного пароля. Минимальный пароль — шесть символов.")
        public void shortPasswordError(){
            MainPage mainPage = new MainPage(driver);
            LoginPage loginPage = new LoginPage(driver);
            RegisterPage registerPage = new RegisterPage(driver);

            mainPage.open();
            mainPage.clickAccountButton();
            loginPage.clickRegisterButton();
            registerPage.inputName(faker.name().firstName());
            registerPage.inputEmail(faker.internet().emailAddress());
            registerPage.inputPassword(faker.internet().password(3, 5));
            registerPage.clickFinallyRegisterButton();
            registerPage.checkShortPasswordError();
        }

        @After
        public void tearDown(){
            driver.quit();
        }
}