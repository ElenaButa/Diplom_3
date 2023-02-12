package stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By email = By.xpath(".//label[text()='Email']/../input");
    private By password = By.xpath(".//label[text()='Пароль']/../input");
    private By inputButton = By.xpath(".//button[text()='Войти']");
    private By registrationButton = By.xpath(".//a[@href='/register']");
    private By passwordRecoveryButton = By.xpath(".//a[@href='/forgot-password']");

    public void setEmail(String text) {
        getEmail().sendKeys(text);
    }

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getPasswordRecoveryButton() {
        return driver.findElement(passwordRecoveryButton);
    }


    public WebElement getInputButton() {
        return driver.findElement(inputButton);
    }

    public RegistrationPage clickRegistration() {
        driver.findElement(registrationButton).click();
        return new RegistrationPage(driver);
    }

    public void setPassword(String text) {
        getPassword().sendKeys(text);
    }

    public HomePage clickInputButton() {
        getInputButton().click();
        return new HomePage(driver);
    }


    public ForgotPasswordPage clickPasswordRecoveryButton() {
        getPasswordRecoveryButton().click();
        return new ForgotPasswordPage(driver);
    }


    public HomePage loginUser(String email, String password) {
        setEmail(email);
        setPassword(password);
        return clickInputButton();
    }

}