package navigation;

import pom.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class NavigationThroughMenuTest {
    private WebDriver driver;

    @Before
    public void setUpChrome(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    @DisplayName("Проверь, что работают переходы к разделам:«Булки», «Соусы», «Начинки».")
    public void navigationThroughMenu() {
        MainPage mainPage = new MainPage(driver);

        mainPage.open();
        mainPage.clickFillingsButton();
        mainPage.checkGoToTheFillingsSection();
        mainPage.clickSaucesButton();
        mainPage.checkGoToTheSaucesSection();
        mainPage.clickBunsButton();
        mainPage.checkGoToTheBunsSection();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}