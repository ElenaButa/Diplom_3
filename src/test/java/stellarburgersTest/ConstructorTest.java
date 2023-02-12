package stellarburgersTest;

import stellarburgers.pages.HomePage;
import org.junit.Test;

public class ConstructorTest extends BaseTest {

    public ConstructorTest() {
        this.isRegistration = false;
    }

    @Test
    public void transitionsToSectionsTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.constructorContainer.clickToppings();
        homePage.constructorContainer.clickSauce();
        homePage.constructorContainer.clickBuns();
    }

}