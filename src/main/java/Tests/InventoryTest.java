package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;


public class InventoryTest extends BaseTest {
    @BeforeMethod
    public void pageSetup() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");


    }

    @Test(priority = 10)
    public void userCanGoToBurgerMenu() {
        loginPage.logInMethod();
        inventoryPage.clickOnBurgerButton();
        inventoryPage.clickOnAllItemsButton();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Test(priority = 20)
    public void userCanClickOnSauceLabsBackpackButtonAndBack() throws InterruptedException {
        loginPage.logInMethod();
        inventoryPage.clickOnBurgerButton();
        inventoryPage.clickOnAllItemsButton();
        Thread.sleep(5000);
        inventoryPage.clickOnCancelButton();
        Thread.sleep(1000);
        inventoryPage.clickOnSauceLabsBackpackButton();
        Thread.sleep(1000);
        String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        inventoryPage.clickOnBackToProducts();
        Assert.assertEquals(inventoryPage.getProductsTitle(), "Products");

    }@Test(priority = 30)
    public void userCanCheckoutShoppingCart() throws InterruptedException {
        loginPage.logInMethod();
        Thread.sleep(1000);
        inventoryPage.clickOnBackpackAddToCart();
        Thread.sleep(1000);
        cartPage.clickOnCartBadge();
        cartPage.clickOnCheckoutButton();
        Thread.sleep(1000);
        checkoutPage.inputValidCredentials("Sanja", "Milojevic", "11000");
        checkoutPage.clickOnContinueButton();
        Thread.sleep(1000);
        Assert.assertEquals(cartPage.getItemTotal(), "Item total: $29.99");
        Assert.assertEquals(cartPage.getTax(), "Tax: $2.40");
        Assert.assertEquals(cartPage.getTotal(), "Total: $32.39");
        checkoutPage.clickOnFinishButton();

    }

    @Test(priority = 40)
    public void userCanContinueShoppingFromCart() throws InterruptedException {
        loginPage.logInMethod();
        inventoryPage.clickOnBackpackAddToCart();
        Thread.sleep(3000);
        cartPage.clickOnCartBadge();
        cartPage.clickOnContinueShoppingButton();
        inventoryPage.clickOnRemoveButtonBackpack();
        // da li je korisnik na stranici svih proizvoda
        String expected = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expected);
    }

    @Test(priority = 50)
    public void userCanCompareProductImageWithDescription() {
        loginPage.logInMethod();
        //kliknuti na img
        inventoryPage.clickOnImage();
        // Asertacija za proveru opisa
        Assert.assertTrue(inventoryPage.getDescription().isDisplayed());
        inventoryPage.clickOnBackToProducts();
    }

    @Test(priority = 60)
    public void userCanAddToCartAndRemoveFromCart() {
        loginPage.logInMethod();
        inventoryPage.clickOnBackpackAddToCart();
        // Izbaciti proizvod
        inventoryPage.clickOnRemoveButtonBackpack();
        // Asertacija da je lista prazna
        Assert.assertTrue(inventoryPage.isCartEmpty());

    }

    @Test(priority = 70)
    public void SortItemsLowToHigh() throws InterruptedException {
        loginPage.logInMethod();
        Thread.sleep(1000);
        inventoryPage.clickOnSortButton();
        Thread.sleep(1000);
        inventoryPage.clickSetPriceLowToHigh();
        Thread.sleep(1000);
        List<Double> productPrices = inventoryPage.getAllProductPrices();
        Assert.assertTrue(inventoryPage.isProductsSortedByPriceLowToHigh(productPrices), "Items are not sorted by price from low to high");

    }

    @Test(priority = 80)
    public void SortItemsHighToLow() throws InterruptedException {
        loginPage.logInMethod();
        Thread.sleep(1000);
        inventoryPage.clickOnSortButton();
        Thread.sleep(1000);
        inventoryPage.clickSetPriceHighToLow();
        Thread.sleep(1000);
        List<Double> productPrices = inventoryPage.getAllProductPrices();
        Assert.assertTrue(inventoryPage.isProductsSortedByPriceHighToLow(productPrices), "Items are not sorted by price from high to low");
    }

    @Test(priority = 90)
    public void SortItemsAToZ() throws InterruptedException {
        loginPage.logInMethod();
        Thread.sleep(1000);
        inventoryPage.clickOnSortButton();
        Thread.sleep(1000);
        inventoryPage.clickSetAToZ();
        Thread.sleep(1000);
        List<String> productsNames = inventoryPage.getAllProductsNames();
        Assert.assertTrue(inventoryPage.isProductsSortedAToZ(productsNames), "Items are not sorted by name from A to Z");
    }
    @Test(priority = 100)
    public void SortItemsZToA() throws InterruptedException {
        loginPage.logInMethod();
        Thread.sleep(1000);
        inventoryPage.clickOnSortButton();
        Thread.sleep(1000);
        inventoryPage.clickSetZToA();
        Thread.sleep(1000);
        List<String> productsNames = inventoryPage.getAllProductsNames();
        Assert.assertTrue(inventoryPage.isProductsSortedZToA(productsNames), "Items are not sorted by name from Z to A");
    }

    @Test(priority = 110)
    public void userCanAddItemsToCartAndCheckout() throws InterruptedException {
        loginPage.logInMethod();
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnBoltTShirtAddToCart();
        inventoryPage.clickOnBikeLightAddToCart();
        // Provera kupovine
        Thread.sleep(3000);
        cartPage.clickOnCartBadge();
        cartPage.clickOnCheckoutButton();
        // upisivanje vazecih kredencijala
        Thread.sleep(3000);
        checkoutPage.inputValidCredentials("Sanja", "Milojevic", "11000");
        checkoutPage.clickOnContinueButton();
        Thread.sleep(5000);
        checkoutPage.clickOnFinishButton();
        // Asertacija do kraja kupovine i povratak na inventoryPage
        Assert.assertTrue(checkoutPage.getThankYouMessage().isDisplayed());
        Thread.sleep(5000);
        checkoutPage.clickOnBackHomeButton();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

    } @Test(priority = 120)
    public void userCanCheckCartBadge() throws InterruptedException {
        loginPage.logInMethod();
        //staviti proizvod u korpu
        Thread.sleep(1000);
        inventoryPage.clickOnBackpackAddToCart();
        Thread.sleep(1000);
        // Staviti u korpu
        Assert.assertEquals(cartPage.getCartBadgeNumber(), "1");
        // skloniti
        inventoryPage.clickOnRemoveButtonBackpack();
        Thread.sleep(1000);
        Assert.assertFalse(cartPage.isCartBadgePresent());
    }
}



