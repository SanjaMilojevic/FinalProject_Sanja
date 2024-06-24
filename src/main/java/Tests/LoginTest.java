package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void pageSetup() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        //izvrsava se pre svakog testa, stranica od koje polazi
    }

    @Test
    public void userCanLogIn() {
        loginPage.inputUsername();
        loginPage.inputPassword();
        loginPage.clickOnLoginButton();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);


    }

    //------------------------------------------
    @Test
    public void userCannotLoginInvalidUsername() {
        loginPage.inputInvalidUsername();
        loginPage.inputPassword();
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void userCannotLoginInvalidPassword() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.inputUsername();
        Thread.sleep(1000);
        loginPage.inputInvalidPassword();
        Thread.sleep(1000);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void userCannotLogInEmptyUsernameField() {
        loginPage.inputEmptyUsername();
        loginPage.inputPassword();
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");

    }

    @Test
    public void userCannotLogInEmptyPasswordField() {
        loginPage.inputUsername();
        loginPage.inputEmptyPassword();
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");

    }

    @Test
    public void userCannotLogInEmptyFields() {
        loginPage.inputEmptyUsername();
        loginPage.inputEmptyPassword();
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");

    }

    @Test
    public void userCanLogInLockedOutUser() {
        loginPage.inputUsernameLockedOutUser();
        loginPage.inputPassword();
        loginPage.clickOnLoginButton();

        String expectedUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");


    }

   @Test
   public void userCanLogInProblemUser() {
       loginPage.inputUsernameProblemUser();
       loginPage.inputPassword();
       loginPage.clickOnLoginButton();

       String expectedUrl = "https://www.saucedemo.com/inventory.html";
       Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

   }
    @Test
    public void verifyPageTitle() {
        loginPage.logInMethod();
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

}

