package stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private By nameInput = By.xpath(".//label[text()='Имя']/../input");
    private By emailInput = By.xpath(".//label[text()='Email']/../input");
    private By passwordInput = By.xpath(".//label[text()='Пароль']/../input");
    private By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By inputButton = By.xpath(".//a[@href = '/login']");
    private By errorMessage = By.xpath(".//p[text()='Некорректный пароль']");


    public void setNameInput(String text) {
        getNameInput().sendKeys(text);
    }

    public void setEmailInput(String text) {
        getEmailInput().sendKeys(text);
    }

    public void setPasswordInput(String text) {
        getPasswordInput().sendKeys(text);
    }

    public WebElement getNameInput() {
        return driver.findElement(nameInput);
    }

    public WebElement getErrorMessage() {
        return driver.findElement(errorMessage);
    }

    public WebElement getEmailInput() {
        return driver.findElement(emailInput);
    }

    public WebElement getPasswordInput() {
        return driver.findElement(passwordInput);
    }

    public LoginPage clickRegistrationButton() {
        driver.findElement(registrationButton).click();
        return new LoginPage(driver);
    }

    public LoginPage registrationUser(String name, String email, String password) {
        setNameInput(name);
        setEmailInput(email);
        setPasswordInput(password);
        return clickRegistrationButton();
    }

    public WebElement getInputButton() {
        return driver.findElement(inputButton);
    }

    public LoginPage clickInputButton() {
        getInputButton().click();
        return new LoginPage(driver);
    }
}