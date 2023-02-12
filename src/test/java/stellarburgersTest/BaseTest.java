package stellarburgersTest;

import stellarburgers.api.data.User;
import stellarburgers.api.requests.UserRequest;
import stellarburgers.pages.HomePage;
import stellarburgers.pages.LoginPage;
import stellarburgers.pages.RegistrationPage;
import stellarburgers.testData.GenerateUserData;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    public stellarburgers.testData.User user;
    public WebDriver driver;
    public boolean isRegistration = true;
    String url = "https://stellarburgers.nomoreparties.site";


    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.driver.get(url);
        if (isRegistration) {
            registration();
        }
    }

    @After
    public void after() {
        driver.quit();
        if (null != user) {
            RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
            User user = new User(this.user.email, this.user.password);
            UserRequest.deleteUser(UserRequest.loginUser(user));
        }
    }

    private void registration() {
        stellarburgers.testData.User user = new stellarburgers.testData.User("Bill", GenerateUserData.getRandomEmail(), "12345678");
        this.user = user;
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.clickSignIn().clickRegistration();

        LoginPage loginPage = registrationPage.registrationUser(user.name, user.email, user.password);
        Assert.assertTrue(loginPage.getInputButton().isDisplayed());

        homePage = loginPage.loginUser(user.email, user.password);
        Assert.assertTrue(homePage.getCreateOrderButton().isDisplayed());
    }

}