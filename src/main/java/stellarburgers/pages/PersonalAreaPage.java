package stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalAreaPage extends BasePage {

    public PersonalAreaPage(WebDriver driver) {
        super(driver);
    }

    private By exitButton = By.xpath(".//button[text()='Выход']");

    public WebElement getExitButton() {
        return driver.findElement(exitButton);
    }

    public LoginPage clickExitButton() {
        getExitButton().click();
        return new LoginPage(driver);
    }
}