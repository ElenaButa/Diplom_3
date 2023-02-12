package stellarburgersTest;

import stellarburgers.pages.HomePage;
import stellarburgers.pages.PersonalAreaPage;
import org.junit.Assert;
import org.junit.Test;

public class HomePageTest extends BaseTest {
    @Test
    public void homePageLogoTest() {
        HomePage homePage = new HomePage(driver);

        PersonalAreaPage personalAreaPage = homePage.headerContainer.clickPersonalAreaButton();
        Assert.assertTrue(personalAreaPage.getExitButton().isDisplayed());

        homePage = personalAreaPage.headerContainer.clickLogo();
        Assert.assertTrue(homePage.getCreateOrderButton().isDisplayed());

        personalAreaPage = homePage.headerContainer.clickPersonalAreaButton();
        Assert.assertTrue(personalAreaPage.getExitButton().isDisplayed());

        homePage = personalAreaPage.headerContainer.clickConstructorButton();
        Assert.assertTrue(homePage.getCreateOrderButton().isDisplayed());
    }

}