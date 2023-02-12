package stellarburgersTest;

import stellarburgers.pages.ForgotPasswordPage;
import stellarburgers.pages.HomePage;
import stellarburgers.pages.LoginPage;
import stellarburgers.pages.RegistrationPage;
import stellarburgers.testData.GenerateUserData;
import stellarburgers.testData.User;
import org.junit.Assert;
import org.junit.Test;

public class LoginUserTest extends BaseTest {

    public LoginUserTest() {
        this.isRegistration = false;
    }

    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.clickSignIn().clickRegistration();

        User user = new User("Bill", GenerateUserData.getRandomEmail(), "12345678");
        this.user = user;
        LoginPage loginPage = registrationPage.registrationUser(user.name, user.email, user.password);
        Assert.assertTrue(loginPage.getInputButton().isDisplayed());
        loginPage.setEmail(user.email);
        Assert.assertEquals(user.email, loginPage.getEmail().getAttribute("value"));
        loginPage.setPassword(user.password);
        Assert.assertEquals(user.password, loginPage.getPassword().getAttribute("value"));

        homePage = loginPage.clickInputButton();
        Assert.assertTrue(homePage.getCreateOrderButton().isDisplayed());
    }

    @Test
    public void loginWithForgotPasswordPageTest() {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.clickSignIn().clickRegistration();

        User user = new User("Bill", GenerateUserData.getRandomEmail(), "12345678");
        this.user = user;
        LoginPage loginPage = registrationPage.registrationUser(user.name, user.email, user.password);
        Assert.assertTrue(loginPage.getInputButton().isDisplayed());

        ForgotPasswordPage forgotPasswordPage = loginPage.clickPasswordRecoveryButton();
        loginPage = forgotPasswordPage.clickLoginButton();
        homePage = loginPage.loginUser(user.email, user.password);
        Assert.assertTrue(homePage.getCreateOrderButton().isDisplayed());

    }

    @Test
    public void loginWithAreaPageTest() {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.clickSignIn().clickRegistration();

        User user = new User("Bill", GenerateUserData.getRandomEmail(), "12345678");
        this.user = user;
        LoginPage loginPage = registrationPage.registrationUser(user.name, user.email, user.password);
        Assert.assertTrue(loginPage.getInputButton().isDisplayed());

        loginPage = loginPage.headerContainer.clickPersonalAreaButtonNotAuth();
        homePage = loginPage.loginUser(user.email, user.password);
        Assert.assertTrue(homePage.getCreateOrderButton().isDisplayed());
    }

    @Test
    public void loginWithRegistrationPageTest() {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.clickSignIn().clickRegistration();

        User user = new User("Bill", GenerateUserData.getRandomEmail(), "12345678");
        this.user = user;
        LoginPage loginPage = registrationPage.registrationUser(user.name, user.email, user.password);
        Assert.assertTrue(loginPage.getInputButton().isDisplayed());

        registrationPage = loginPage.clickRegistration();
        loginPage = registrationPage.clickInputButton();
        homePage = loginPage.loginUser(user.email, user.password);
        Assert.assertTrue(homePage.getCreateOrderButton().isDisplayed());

    }

}