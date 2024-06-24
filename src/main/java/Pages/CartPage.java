package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    public WebDriver driver;
    public WebDriverWait wdWait;
    WebElement cartBadge;
    WebElement checkoutButton;
    WebElement continueShoppingButton;
    WebElement cartBadgeNumber;
    WebElement itemTotal;
    WebElement tax;
    WebElement total;



    public CartPage(WebDriver driver, WebDriverWait wdWait) {
        this.driver = driver;
        this.wdWait = wdWait;
    }

    public WebElement getCartBadge() {
        return driver.findElement(By.className("shopping_cart_badge"));
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(By.id("checkout"));
    }


    public boolean isCartBadgePresent(){
        return driver.findElements(By.className("shopping_cart_badge")).size() > 0;
    }
    public String getCartBadgeNumber() {
            return driver.findElement(By.className("shopping_cart_badge")).getText();
        }
        public WebElement getContinueShoppingButton () {
            return driver.findElement(By.id("continue-shopping"));
        }


        public String getItemTotal () {
            return driver.findElement(By.className("summary_subtotal_label")).getText();
        }
        public String getTax () {
            return driver.findElement(By.className("summary_tax_label")).getText();
        }
        public String getTotal () {
            return driver.findElement(By.className("summary_total_label")).getText();
        }

    public void clickOnCartBadge () {
        getCartBadge().click();
    }
    public void clickOnCheckoutButton () {
        getCheckoutButton().click();
    }
    public void clickOnContinueShoppingButton () {
        getContinueShoppingButton().click();
    }

}

