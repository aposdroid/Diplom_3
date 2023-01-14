package GoToMainPageTest;

import POM.LoginPage;
import POM.MainPage;
import POM.ProfilePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ToMainPageFromAccountPageTest {

    private WebDriver driver;

    @Before
    public void setUpChrome() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        mainPage.clickAccountButton();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Конструктор']")));
    }

    @Test
    @DisplayName("Проверь переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void toMainPageFromAccountPageWithLogoButton(){
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        profilePage.clickLogoButton();
        mainPage.checkOrderButton();
    }

    @Test
    @DisplayName("Проверь переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void toMainPageFromAccountPageWithConstructorButton(){
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        profilePage.clickConstructorButton();
        mainPage.checkOrderButton();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}