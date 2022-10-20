package Pages;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Base.BaseDriver;
import Utilities.Login;
import Utilities.Logout;

public class HomePage extends BaseDriver {

    Login login = new Login();
    Logout logout = new Logout();
    Random rand = new Random();

    public String[] words = new String[]{"Lays", "Toys", "Flour", "Milk", "Lenovo", "Grocery", "Accessories"};
    public int searchWord = rand.nextInt(words.length);
    int val = getRandomValue(4,1);

    public static List<WebElement> searchList;
    public static int getCartCounterSize;
    public static int getCartProductSize;

    // Logo //
    public  By logo = By.xpath("//a[@class='navbar-brand d-none d-sm-block mr-3 flex-shrink-0']/img");
    // Search //
            By search = By.xpath("//*[@id='app-search']");
    public  By searchSuggestion = By.xpath("//*[@id='SearchResult']/div[1]/ul/li/a");
            By searchButton = By.xpath("//span[@class='input-group-text']");
    public  By searchCheck = By.xpath("//h4[@style]");
            By menuButton = By.xpath("//div[@class='navbar-tool-icon-box']");
    // Country //
    public  By country = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[1]");
    public  By countryDropdown = By.xpath("//li[@class='flagBox']/div/div[@aria-labelledby='dropdownMenuLink']");
            By countryUAE = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[1]/div/div/form/li/a[1]/span[2]/span");
            By countryKSA = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[1]/div/div/form/li/a[2]/span[2]/span");
            By countryKWT = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[1]/div/div/form/li/a[3]/span[2]/span");

    // Language //
    public  By language = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[2]/div/a/span");
    public  By languageDropdown = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[2]/div/div");
            By languageEnglish = By.xpath("//*[@id='getLocalForm']/li[1]/a");
            By languageArabic = By.xpath("//*[@id='getLocalForm']/li[2]/a");
    // Cart //
            By cart = By.xpath("//*[@id='cart-updater']/a");
    public  By cartDropdown = By.xpath("//div[@id='cart-updater']/div");
    public  By cartProducts = By.xpath("//*[@id='cart-updater']/div/div/div/div/div[2]/div/div/div/div/div");
    public  By cartCounter = By.xpath("//span[@class='cart-counter']");
    // Sign In //
            By signIn = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[4]");
    public  By signInModal = By.xpath("//div[@class='modal fade show']/div/div");
    public  By cancelModal = By.xpath("//div[@class='modal fade show']/div/div/div[1]/button/span");
            By AfterSignIn = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[4]/div/a/span[1]");
    // Categories //
    public  By allCategories = By.xpath("//div[@id='navbarCollapse']/div/a");
    public  By allCategoriesDropdown = By.xpath("//div[@id='menuwrapper']/ul/li[" + val + "]/a");
    public  By allCategoriesInnerDropdown = By.xpath("//div[@id='menuwrapper']/ul/li[" + val + "]/ul/li/a");
    public  By categoriesLinkPage = By.xpath("//div[@class='container pb-5 mt-3 mb-2 mb-md-4']/div/section");
            By categories = By.xpath("//ul[@class='navbar-nav style2mainMenu arrowRemoved']/li[" + getRandomValue(4, 1) + "]/a");
            By moreCategories = By.xpath("//ul[@class='navbar-nav style2mainMenu arrowRemoved']/li[9]/a");
    public  By moreCategoriesDropdown = By.xpath("//ul[@class='navbar-nav style2mainMenu arrowRemoved']/li[9]/ul/li[" + getRandomValue(4, 1) + "]/a");

    // Add To WishList //
            By addToWishlist = By.xpath("(//button[starts-with(@title,'Add to wishlist')])[1]");
            By removeToWishList = By.xpath("//button[@class='btn-wishlist btn-sm addWishedGreen']");
            // Add To Cart //
            By addToCart = By.xpath("(//a[starts-with(@id,'cartButton-')])[1]");
            By removeToCart = By.xpath("//a[@class='btn btn-primary addToCartButton addCartedGreen']");
    public  By Toast = By.xpath("//div[@class='Vue-Toastification__toast-body']");

    // Buy_Now-Pay_Later //
            By buyNowPayLater = By.xpath("//a[contains(@href,'buy-now-pay-later')]");
    public  By buyNowPayLaterPage = By.xpath("//div[@class='secontBuyNow_sec text-center']");
    // Sell Your Item //
            By sellYourItem = By.xpath("//a[contains(@data-itemurl,'buyback')]");
    public  By getSellYourItemPage = By.xpath("//div[@id='tradein-categories']");

            By userProfileButton = By.xpath("//span[@class='text username-limit']");


    public void SelectCountry(){
        driver.findElement(country).click();
        explicitWait(countryDropdown);
        switch (Country) {
            case "UAE" -> driver.findElement(countryUAE).click();
            case "KSA" -> driver.findElement(countryKSA).click();
            case "KWT" -> driver.findElement(countryKWT).click();
        }
        explicitWait(country);
    }
    public void SelectLanguage(){
        driver.findElement(language).click();
        explicitWait(languageDropdown);
        switch (Language) {
            case "Arabic" -> driver.findElement(languageArabic).click();
            case "English" -> driver.findElement(languageEnglish).click();
        }
        explicitWait(language);
    }
    public void logo() {
        explicitWait(logo);
    }
    public void SearchSuggestion() {
        explicitWait(search);
        WebElement searchSingleItem = driver.findElement(search);
        searchSingleItem.sendKeys(words[searchWord]);
        explicitWait(searchSuggestion);
        searchList = driver.findElements(searchSuggestion);
    }

    public void SearchButtonWithoutText() {
        WebElement searchField = driver.findElement(search);
        searchField.sendKeys(Keys.chord(Keys.CONTROL+"a"+Keys.BACK_SPACE));
        explicitWaitNot(searchSuggestion);
        driver.findElement(searchButton).click();
    }

    public void SearchButtonWithText() {
        driver.findElement(search).sendKeys(words[searchWord]);
        explicitWait(searchSuggestion);
        driver.findElement(searchButton).click();
        explicitWait(searchCheck);
    }

    public void CartDropdown() {
        goBackToHomePage();
        explicitWait(cart);
        driver.findElement(cart).click();
        explicitWait(cartDropdown);
    }

    public void CartCounter() {
        getCartProductSize = driver.findElements(cartProducts).size();
        String getCartCounterText = driver.findElement(cartCounter).getText();
        getCartCounterSize = Integer.parseInt(getCartCounterText);
    }

    public void SignIn() {
        explicitWait(signIn);
        driver.findElement(signIn).click();
        explicitWait(signInModal);
    }

    public void SignInModalClose() {
        explicitWait(signInModal);
        driver.findElement(cancelModal).click();
        explicitWaitNot(cancelModal);
    }

    public void AllCategories() {
        explicitWait(allCategories);
        driver.findElement(allCategories).click();
        explicitWait(allCategoriesDropdown);
    }

    public void AllCategoriesDropdown() {
        explicitWait(allCategoriesDropdown);
        driver.findElement(allCategoriesDropdown).click();
        explicitWait(allCategoriesInnerDropdown);
    }

    public void AllInnerCategoriesDropdown() {
        explicitWait(allCategoriesInnerDropdown);
        driver.findElement(allCategoriesInnerDropdown).click();
        explicitWait(categoriesLinkPage);

    }

    public void Categories() {
        goBackToHomePage();
        explicitWait(categories);
        driver.findElement(categories).click();
        explicitWait(categoriesLinkPage);
    }

    public void MoreCategory() {
        goBackToHomePage();
        explicitWait(moreCategories);
        driver.findElement(moreCategories).click();
    }

    public void MoreCategoriesFromDropdown() {
        explicitWait(moreCategoriesDropdown);
        driver.findElement(moreCategoriesDropdown).click();
        explicitWait(categoriesLinkPage);
    }

    public void BuyNowPayLater() {
        goBackToHomePage();
        explicitWait(buyNowPayLater);
        driver.findElement(buyNowPayLater).click();
        explicitWait(buyNowPayLaterPage);
    }
    public void BuyBack() {
        goBackToHomePage();
        explicitWait(sellYourItem);
        driver.findElement(sellYourItem).click();
        explicitWait(getSellYourItemPage);
    }
    public void AddToWishList_BL() {
        if (!(driver.getCurrentUrl().equals(url))){
            driver.navigate().to(url);
        }
        scrollDown();
        explicitWait(addToWishlist);
        getRandomElement(addToWishlist,signInModal);
    }
    public void SignInModalCloseOnAddToWishList() {
        explicitWait(signInModal);
        driver.findElement(cancelModal).click();
        explicitWaitNot(cancelModal);
    }

    public void AddToCart_BL() {
        getRandomElement(addToCart,Toast);
    }
    public void RemoveToCart_BL() {
        getRandomElement(removeToCart,Toast);
    }
    // Process After Login //
    public void AddToWishList_AL() throws SQLException {
        explicitWaitNot(Toast);
        login.userLogin();
        explicitWait(AfterSignIn);
        scrollDown();
        explicitWait(addToWishlist);
        getRandomElement(addToWishlist,Toast);
    }
    public void RemoveToWishList_AL() {
        explicitWait(removeToWishList);
        getRandomElement(removeToWishList,Toast);
    }
    public void HeaderMenuButton() {
        explicitWaitNot(Toast);
        getRandomElement(menuButton,allCategories);
    }
    public void logout(){
        explicitWait(userProfileButton);
        logout.userLogout();
    }
}
