package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTest extends BaseTest {
    @BeforeMethod
    public void pageSetup() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

} @Test(priority = 10)
public void userCanOpenFooterLinkTwitter() throws InterruptedException {
        loginPage.logInMethod();
        // dugme za Twitter
        footerPage.clickOnTwitterButton();
        //prelazak na novi prozor
        footerPage.switchToNewWindow();
        Thread.sleep(10000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://x.com/saucelabs");
        //nekada ocita ovaj link https://x.com/saucelabs?mx=2, a nekada https://x.com/saucelabs

    }@Test(priority = 20)
    public void userCanOpenFooterLinkFacebook() {
        loginPage.logInMethod();
        // dugme za facebook
        footerPage.clickOnFacebookButton();
        footerPage.switchToNewWindow();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/saucelabs");

    }@Test(priority = 30)
    public void userCanOpenFooterLinkedin() throws InterruptedException {
        loginPage.logInMethod();
        // dugme za linkedin
        footerPage.clickOnLinkedinButton();
        footerPage.switchToNewWindow();
        Thread.sleep(10000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/company/sauce-labs/");
}
}