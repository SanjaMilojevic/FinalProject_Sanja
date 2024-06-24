package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage {

    public WebDriver driver;
    public WebDriverWait wdWait;
    WebElement twitterButton;
    WebElement facebookButton;
    WebElement linkedinButon;

    public FooterPage(WebDriver driver, WebDriverWait wdWait) {
        this.driver = driver;
        this.wdWait = wdWait;
    }

    public WebElement getTwitterButton() {
        return driver.findElement(By.className("social_twitter"));

    }

    public WebElement getFacebookButton() {
        return driver.findElement(By.className("social_facebook"));
    }

    public WebElement getLinkedinButton() {
        return driver.findElement(By.className("social_linkedin"));
    }

    public void clickOnTwitterButton() {
        getTwitterButton().click();
    }

    public void clickOnFacebookButton() {
        getFacebookButton().click();
    }

    public void clickOnLinkedinButton() {
        getLinkedinButton().click();
    }

    public void switchToNewWindow() {
        String mainWindow = driver.getWindowHandle();//driver.getWindowHandle() vraca String koji predstavlja jedinstveni identifikator trenutnog prozora

        for (String window : driver.getWindowHandles()) {
            //driver.getWindowHandles() vraca String koji sadrži jedinstvene identifikatore svih trenutno otvorenih prozora
            if (!window.equals(mainWindow)) { //da trenutni prozor nije jednak glavnom prozoru
                driver.close();  // zatvara glavni prozor
                driver.switchTo().window(window);//radi u novom prozoru window
                break;
            }
        }
    }
}