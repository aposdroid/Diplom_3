package navigation;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.example.pom.MainPage;

public class NavigationThroughMenuTest extends annotations.BaseTest {

    @Test
    @DisplayName("Проверь, что работают переходы к разделам:«Булки», «Соусы», «Начинки».")
    public void navigationThroughMenu() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingsButton();
        mainPage.checkGoToTheFillingsSection();
        mainPage.clickSaucesButton();
        mainPage.checkGoToTheSaucesSection();
        mainPage.clickBunsButton();
        mainPage.checkGoToTheBunsSection();
    }
}