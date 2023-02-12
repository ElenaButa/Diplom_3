package stellarburgers.pages.containers;

import stellarburgers.pages.HomePage;
import stellarburgers.pages.LoginPage;
import stellarburgers.pages.PersonalAreaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderContainer {
    private WebDriver driver;

    public HeaderContainer(WebDriver driver) {
        this.driver = driver;
    }

    private By personalAreaButton = By.xpath(".//a[@href='/account']");
    private By logo = By.xpath(".//div[contains(@class, 'AppHeader_header__logo')]/a");
    private By ordersListButton = By.xpath(".//a[@href = '/feed']");
    private By constructorButton = By.xpath(".//p[text() = 'Конструктор']/..");

    public WebElement getPersonalAreaButton() {
        return driver.findElement(personalAreaButton);
    }

    public WebElement getLogo() {
        return driver.findElement(logo);
    }

    public WebElement getOrderListButton() {
        return driver.findElement(ordersListButton);
    }

    public WebElement getConstructorButton() {
        return driver.findElement(constructorButton);
    }

    public PersonalAreaPage clickPersonalAreaButton() {
        getPersonalAreaButton().click();
        return new PersonalAreaPage(driver);
    }

    public LoginPage clickPersonalAreaButtonNotAuth() {
        getPersonalAreaButton().click();
        return new LoginPage(driver);
    }

    public HomePage clickLogo() {
        getLogo().click();
        return new HomePage(driver);
    }

    public HomePage clickConstructorButton() {
        getConstructorButton().click();
        return new HomePage(driver);
    }

}