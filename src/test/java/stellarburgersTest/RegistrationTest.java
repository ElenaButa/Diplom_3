package stellarburgersTest;

import stellarburgers.pages.HomePage;
import stellarburgers.pages.LoginPage;
import stellarburgers.pages.RegistrationPage;
import stellarburgers.testData.GenerateUserData;
import stellarburgers.testData.User;
import org.junit.Assert;
import org.junit.Test;


public class RegistrationTest extends BaseTest {

    public RegistrationTest() {
        this.isRegistration = false;
    }

    @Test
    public void registrationTest() {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.clickSignIn().clickRegistration();

        User user = new User("Bill", GenerateUserData.getRandomEmail(), "12345678");
        registrationPage.setNameInput(user.name);
        registrationPage.setEmailInput(user.email);
        registrationPage.setPasswordInput(user.password);

        Assert.assertEquals(user.name, registrationPage.getNameInput().getAttribute("value"));
        Assert.assertEquals(user.email, registrationPage.getEmailInput().getAttribute("value"));
        Assert.assertEquals(user.password, registrationPage.getPasswordInput().getAttribute("value"));

        LoginPage loginPage = registrationPage.clickRegistrationButton();
        Assert.assertTrue(loginPage.getInputButton().isDisplayed());
        this.user = user;

    }

    @Test
    public void registrationWithNotCorrectPasswordTest() {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.clickSignIn().clickRegistration();

        User user = new User("Bill", GenerateUserData.getRandomEmail(), "1234000");

        registrationPage.registrationUser(user.name, user.email, user.password);
        Assert.assertTrue(registrationPage.getErrorMessage().isDisplayed());
    }

}