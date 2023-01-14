package LoginTest;

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

public class LogoutTest {

    private WebDriver driver;

    @Before
    public void setUpChrome(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    @DisplayName("Проверь выход по кнопке «Выйти» в личном кабинете.")
    public void Logout() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.open();
        mainPage.clickAccountButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Конструктор']")));
        mainPage.clickAccountButton();
        profilePage.clickLogoutButton();
        loginPage.checkRegistrationIsSuccessfully();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}