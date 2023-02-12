package stellarburgers.pages;

import stellarburgers.pages.containers.ConstructorContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public ConstructorContainer constructorContainer;

    public HomePage(WebDriver driver) {
        super(driver);
        this.constructorContainer = new ConstructorContainer(driver);
    }

    private By signIn = By.xpath("//button[text()='Войти в аккаунт']");

    private By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");


    public WebElement getCreateOrderButton() {
        return driver.findElement(createOrderButton);
    }


    public LoginPage clickSignIn() {
        driver.findElement(signIn).click();
        return new LoginPage(driver);
    }
}