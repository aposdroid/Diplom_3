package login;

import pom.ForgotPasswordPage;
import pom.LoginPage;
import pom.MainPage;
import pom.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void setUpChrome(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    @DisplayName("Проверь вход через кнопку «Личный кабинет»")
    public void loginThroughPersonalAccountButton(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickAccountButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @Test
    @DisplayName("Проверь вход по кнопке «Войти в аккаунт» на главной")
    public void loginThroughSignInButton(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.clickSignInButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @Test
    @DisplayName("Проверь вход через кнопку в форме восстановления пароля.")
    public void LoginThroughTheButtonInThePasswordRecoveryForm(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        mainPage.clickSignInButton();
        loginPage.clickRestorePasswordButton();
        forgotPasswordPage.clickSignInButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @Test
    @DisplayName("Проверь вход через кнопку в форме регистрации")
    public void loginThroughTheButtonInTheRegistrationForm(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickSignInButton();
        loginPage.clickRegisterButton();
        registerPage.clickSignInButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        mainPage.checkOrderButton();
    }

    @After
        public void tearDown(){
        driver.quit();
    }
}