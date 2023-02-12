package stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    private By email = By.xpath(".//label[text()='Email']/../input");
    private By passwordRecoveryButton = By.xpath(".//button[text()='Восстановить']");
    private By loginButton = By.xpath(".//a[@href = '/login']");

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPasswordRecoveryButton() {
        return driver.findElement(passwordRecoveryButton);
    }

    public void setEmail() {
        getEmail().sendKeys();
    }

    public void clickPasswordRecoveryButton() {
        getPasswordRecoveryButton().click();
    }

    public LoginPage clickLoginButton() {
        getLoginButton().click();
        return new LoginPage(driver);
    }

}