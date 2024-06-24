package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void userCanLogInAnDLogout() throws InterruptedException {
        loginPage.logInMethod();
        inventoryPage.clickOnBurgerButton();
        inventoryPage.clickOnLogoutButton();
        Thread.sleep(5000);
        String expectedUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

    }
}