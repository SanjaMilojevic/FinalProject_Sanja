package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public FooterPage footerPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage=new LoginPage(driver);
        inventoryPage= new InventoryPage(driver,wdwait);
        cartPage=new CartPage(driver,wdwait);
        checkoutPage=new CheckoutPage(driver,wdwait);
        footerPage=new FooterPage(driver,wdwait);


    }
    @AfterClass
    public void tearDown(){
       driver.quit();
    }
}
