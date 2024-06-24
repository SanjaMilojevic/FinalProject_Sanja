package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

    public WebDriver driver;
    WebElement usernameField;
    WebElement passwordField;
    WebElement loginButton;
    WebElement errorMessage;
    WebElement inputInvalidUsername;
    WebElement inputInvalidPassword;
    WebElement inputEmptyUsername;
    WebElement inputEmptyPassword;
    WebElement inputUsernameLockedOutUser;
    WebElement inputUsernameProblemUser;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("user-name"));
    }
    //kreiranje get-er za svaki WebElement, i za return lokator elementa cime pozivam tu metodu
    //kada zelim da dohvatim taj WebElement

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    public void inputUsername() {
        getUsernameField().clear();
        getUsernameField().sendKeys("standard_user");
    }

    public void inputPassword() {
        getPasswordField().clear();
        getPasswordField().sendKeys("secret_sauce");

    }

    public void inputInvalidUsername() {
        getUsernameField().clear();
        getUsernameField().sendKeys("Sanja");
    }

    public void inputEmptyUsername() {
        getUsernameField().clear();
        getUsernameField().sendKeys("");
    }

    public void inputInvalidPassword() {
        getPasswordField().clear();
        getPasswordField().sendKeys("a!A.9");
    }
    public void inputEmptyPassword() {
        getPasswordField().clear();
        getPasswordField().sendKeys("");
    }

    public void inputUsernameLockedOutUser() {
        getUsernameField().clear();
        getUsernameField().sendKeys("locked_out_user");
    }

    public void inputUsernameProblemUser() {
        getUsernameField().clear();
        getUsernameField().sendKeys("problem_user");
    }

    public String getErrorMessage() {
        return driver.findElement(By.className("error-message-container")).getText();
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public void logInMethod() {
        inputUsername();
        inputPassword();
        clickOnLoginButton();
    }

}
