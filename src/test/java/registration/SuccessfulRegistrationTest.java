package registration;

import io.restassured.response.ValidatableResponse;
import org.example.pom.LoginPage;
import org.example.pom.MainPage;
import org.example.pom.RegisterPage;
import org.example.rest.User;
import org.example.rest.UserClient;
import org.junit.Test;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;

public class SuccessfulRegistrationTest extends annotations.BaseTest{

    UserClient client = new UserClient();
    Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password(6, 9);

    @Test
    @DisplayName("Проверь успешную регистрацию")
    public void successfulRegistration(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickAccountButton();
        loginPage.clickRegisterButton();
        registerPage.inputName(name);
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
        registerPage.clickFinallyRegisterButton();
        loginPage.checkRegistrationIsSuccessfully();

        ValidatableResponse response = client.loginUser(new User(email, password));
        String accessToken = client.getToken(response);
        ValidatableResponse deleteResponse = client.deleteUser(accessToken);
        client.userDeleted(deleteResponse);
    }
}