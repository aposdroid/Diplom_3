package login;

import pom.LoginPage;
import pom.MainPage;
import pom.ProfilePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class AccountLoginTest {

    private WebDriver driver;

    @Before
    public void setUpChrome(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    @DisplayName("Проверь переход по клику на «Личный кабинет»")
    public void accountLogin() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.open();
        mainPage.clickAccountButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        Thread.sleep(1000);//тут только слип помогает, нормальное ожидание через раз падает
        //new WebDriverWait(driver, Duration.ofSeconds(5))
                //.until(ExpectedConditions.elementToBeClickable(By.xpath(".//p[text()='Конструктор']")));
        mainPage.clickAccountButton();
        profilePage.checkLogoutButton();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}