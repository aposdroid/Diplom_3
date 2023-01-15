package registration;

import pom.LoginPage;
import pom.MainPage;
import pom.RegisterPage;
import org.junit.Test;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;


public class SuccessfulRegistrationTest extends annotations.BaseTest{

    Faker faker = new Faker();

    @Test
    @DisplayName("Проверь успешную регистрацию")
    public void successfulRegistration(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickAccountButton();
        loginPage.clickRegisterButton();
        registerPage.inputName(faker.name().firstName());
        registerPage.inputEmail(faker.internet().emailAddress());
        registerPage.inputPassword(faker.internet().password(6, 9));
        registerPage.clickFinallyRegisterButton();
        loginPage.checkRegistrationIsSuccessfully();
    }
}