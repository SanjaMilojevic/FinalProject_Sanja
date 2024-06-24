package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class InventoryPage {
    public WebDriver driver;
    public WebDriverWait wdWait;
    WebElement burgerButton;
    WebElement allItemsButton;
    WebElement cancelButton;
    WebElement sauceLabsBackpackButton;
    WebElement backToProductsButton;
    WebElement backpackAddToCart;
    WebElement boltTShirtAddToCart;
    WebElement bikeLightAddToCart;
    WebElement cartBadge;
    WebElement image;
    WebElement description;
    WebElement removeButtonBackpack;
    WebElement logoutButton;


    public InventoryPage(WebDriver driver, WebDriverWait wdWait) {
        this.driver = driver;
        this.wdWait = wdWait;
    }

    public WebElement getBurgerButton() {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    public WebElement getAllItemsButton() {
        return driver.findElement(By.id("inventory_sidebar_link"));
    }

    public WebElement getCancelButton() {
        return driver.findElement(By.id("react-burger-cross-btn"));
    }

    public WebElement getSauceLabsBackpackButton() {
        return driver.findElement(By.id("item_4_title_link"));
    }

    public WebElement getBackToProductsButton() {
        return driver.findElement(By.id("back-to-products"));
    }

    public WebElement getBackpackAddToCart() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    public WebElement getBoltTShirtAddToCart() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
    }

    public WebElement getBikeLightAddToCart() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
    }

    public WebElement getCartBadge() {
        return driver.findElement(By.className("shopping_cart_badge"));
    }

    public WebElement getImage() {
        return driver.findElement(By.className("inventory_item_img"));

    }

    public WebElement getDescription() {
        return driver.findElement(By.cssSelector(".inventory_details_desc.large_size"));
    }

    public WebElement getRemoveButtonBackpack() {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    //-------------------------------------------------------------------------
    public void clickOnBurgerButton() {
        getBurgerButton().click();

    }

    public void clickOnAllItemsButton() {
        getAllItemsButton().click();
    }

    public void clickOnCancelButton() {
        getCancelButton().click();
    }

    public void clickOnSauceLabsBackpackButton() {
        getSauceLabsBackpackButton().click();
    }

    public void clickOnBackToProducts() {
        getBackToProductsButton().click();
    }

    public void clickOnBackpackAddToCart() {
        getBackpackAddToCart().click();
    }


    public void clickOnBoltTShirtAddToCart() {
        getBoltTShirtAddToCart().click();
    }

    public void clickOnBikeLightAddToCart() {
        getBikeLightAddToCart().click();
    }

    public void clickOnCartBadge() {
        getCartBadge().click();

    }public void clickOnImage() {
        getImage().click();

    }
    public void clickOnRemoveButtonBackpack() {
        getRemoveButtonBackpack().click();
    }

    public String getProductsTitle(){
        return driver.findElement(By.cssSelector(".title")).getText();
    }

    public void clickOnLogoutButton() {
        getLogoutButton().click();

    }
    public boolean isCartEmpty() {
        return driver.findElements(By.className("cart_list")).isEmpty();
    }


    // -----------------------------------
    // ----------------------------------- sort low to high
    public WebElement sortItemsButton() {
        return driver.findElement(By.className("product_sort_container"));
    }

    public WebElement sortItemsLowToHighButton() {
        return driver.findElement(By.cssSelector("option[value='lohi']"));
    }

    public void clickOnSortButton() {
        sortItemsButton().click();
    }

    public void clickSetPriceLowToHigh() {
        sortItemsLowToHighButton().click();
    }

    public List<Double> getAllProductPrices() {
        List<WebElement> itemPrices = driver.findElements(By.className("inventory_item_price"));
        List<Double> pricesList = new ArrayList<>();//prazna listu pricesList za double vred.
        for (WebElement priceElement : itemPrices) {//petlja prolazi kroz sve itemPrices,priceElement predstavlja trenutni element cene u listi
            double price = Double.parseDouble(priceElement.getText().replace("$", ""));
            pricesList.add(price);//priceElement.getText() od cene vraca string, replace uklanja znak $ iz stringa
        }//doubleparseDouble konvertuje String u double
        return pricesList;//vraca listu pricesList koja sadrzi sve cene proizvoda kao double vrednosti
    }

    public boolean isProductsSortedByPriceLowToHigh(List<Double> productPrices) {
        double previousPrice = 0.0;//prethodna cena min.vred.prva cena u listi sigurno biti veca ili jednaka od previousPrice
        for (double currentPrice : productPrices) {//prolazi kroz sve elemente liste productPrices
            //currentPrice- trenutna cena proizvoda
            if (currentPrice < previousPrice) {//trenutna cena trebalo da bude veca ili jednaka prethodnoj ceni i onda vraca false
                return false;
            }
            previousPrice = currentPrice;
        }
        return true;//previousPrice na currentPrice, kako bi se u sledecoj iteraciji uporedila sledeca cena sa ovom i onda vraca true
    }

    // ----------------------------------- sorttranje od high do low
    public WebElement sortItemsHighToLowButton() {
        return driver.findElement(By.cssSelector("option[value='hilo']")); //
    }

    public void clickSetPriceHighToLow() {
        sortItemsHighToLowButton().click();
    }



    public boolean isProductsSortedByPriceHighToLow(List<Double> productPrices) {
        double previousPrice = Double.MAX_VALUE;//cene previous price se proveravaju od najvise ka najnizoj
        for (double currentPrice : productPrices) {//prolazi kroz sve elemente liste productPrices,currentPrice je trenutna cena proizvoda u listi
            if (currentPrice > previousPrice) {//proverava da li je trenutna cena veca od prethodne cene
                return false;//ako nadje vraca false
            }
            previousPrice = currentPrice;
        }
        return true;//  ako ne nadje lista sortirana od najviše ka najnižoj ceni i vraca true
    }

    // ----------------------------------- od A do Z


    public List<String> getAllProductsNames() {
        List<WebElement> itemNames = driver.findElements(By.className("inventory_item_name"));
        List<String> namesList = new ArrayList<>();
        for (WebElement nameElement : itemNames) {//nameElement predstavlja trenutni element imena u listi koji prolazi kroz itemNames
            namesList.add(nameElement.getText());//getText vraca string ,namesList.add dodavanje imena -String vred. u listu namesList.
        }
        return namesList;//vraca listu namesList koja sadrzi sva imena proizvoda kao String vred.
    }
    public WebElement sortItemsAtoZButton() {
        return driver.findElement(By.cssSelector("option[value='az']"));
    }

    public void clickSetAToZ() {
        sortItemsAtoZButton().click();
    }

    public boolean isProductsSortedAToZ(List<String> productNames) {
        String previousName = ""; // pocinje sa prvom vrednoscu "A"ako ima, tako će prvo ime u listi sigurno biti veće ili jednako od previousName
        for (String currentName : productNames) {// prolazi kroz sve elemente liste productNames,currentName predstavlja trenutno ime proizvoda u listi
            if (currentName.compareToIgnoreCase(previousName) < 0) {
                return false;
            }//ako currentName dolazi pre previousName od A do Z, rezultat je - broj.
            //Ako su jednaki, rezultat je 0.
            //Ako currentName dolazi posle previousName od A do Z, rezultat + broj.
            previousName = currentName;
        }
        return true;//ako završi bez povratka false, svi elementi liste su prošli proveru sortiranja u rastućem redosledu
    }

    // ----------------------------------- od Z do A
    public WebElement sortItemsZtoAButton() {
        return driver.findElement(By.cssSelector("option[value='za']"));
    }

    public void clickSetZToA() {
        sortItemsZtoAButton().click();
    }

    public boolean isProductsSortedZToA(List<String> productNames) {
        String previousName = "Z"; // Pocinje sa poslednjom vrednoscu max,prvi element liste sigurno biti manji ili jednak previousName
        for (String currentName : productNames) {//prolazi kroz sve elemente liste productNames,currentName predstavlja trenutno ime proizvoda u listi koje se proverava
            if (currentName.compareToIgnoreCase(previousName) > 0) {
                return false;
            }//ako currentName dolazi pre previousName od A do Z, rezultat je - broj
            //ako su jednaki onda je 0
            //ako currentName dolazi posle previousName od A do Z, rezultat je + broj
            previousName = currentName;// previousName jednako currentName, kako bi se u sledećoj iteraciji uporedilo sledeće ime sa ovim
        }
        return true;// lista sortirana od Z do A.
    }

}





