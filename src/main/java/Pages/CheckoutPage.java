package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

        public WebDriver driver;
        public WebDriverWait wdWait;

        WebElement firstNameField;
        WebElement lastNameField;
        WebElement postalCodeField;
        WebElement continueButton;
        WebElement finishButton;
        WebElement thankYouMessage;
        WebElement backHomeButton;

        public CheckoutPage(WebDriver driver, WebDriverWait wdWait) {
            this.driver = driver;
            this.wdWait = wdWait;
        }

        public WebElement getFirstNameField() {
            return driver.findElement(By.id("first-name"));
        }

        public WebElement getLastNameField() {
            return driver.findElement(By.id("last-name"));
        }

        public WebElement getPostalCodeField() {
            return driver.findElement(By.id("postal-code"));
        }

       public WebElement getContinueButton() {
            return driver.findElement(By.cssSelector(".submit-button.btn.btn_primary.cart_button.btn_action"));
        }

        public WebElement getFinishButton() {
            return driver.findElement(By.id("finish"));
        }
        public WebElement getThankYouMessage(){
         return driver.findElement(By.className("complete-header"));

        }public WebElement getBackHomeButton(){
            return driver.findElement(By.cssSelector(".btn.btn_primary.btn_small"));
    }

        public void inputValidCredentials(String firstName, String lastName, String postalCode) {
            getFirstNameField().clear();
            getFirstNameField().sendKeys(firstName);
            getLastNameField().clear();
            getLastNameField().sendKeys(lastName);
            getPostalCodeField().clear();
            getPostalCodeField().sendKeys(postalCode);

        }
       public void clickOnContinueButton(){
            getContinueButton().click();
        }
        public void clickOnFinishButton() {
            getFinishButton().click();
        }
        public void clickOnBackHomeButton(){
            getBackHomeButton().click();
        }
    }

