package Pages;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;

import Base.BaseDriver;
import Utilities.GetterSetter;
import Utilities.Login;
import org.openqa.selenium.WebElement;

public class ProductListingPage extends BaseDriver {

    Login login = new Login();
    GetterSetter gs = new GetterSetter();
    public static int actual = 0;
    public static int expected = 0;
    public static String getCurrentCountry;

    public  By country = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[1]/div[1]/a/span[2]/span");
    public  By signInModal = By.xpath("//div[@class='modal fade show']/div/div");
    public  By cancelModal = By.xpath("//div[@class='modal fade show']/div/div/div[1]/button/span");
    By categories = By.xpath("//ul[@class='navbar-nav style2mainMenu arrowRemoved']/li[@class='nav-item']/a");
    public  By categoriesLinkPage = By.xpath("//div[@class='container pb-5 mt-3 mb-2 mb-md-4']/div/section");
    public  By currentCountryCurrency = By.xpath("//span[@class='currencyText']");
    // Error //
    public  By toast = By.xpath("//div[@class='Vue-Toastification__container top-right']/div");
    // Filter Condition //
            By minPrice = By.xpath("//li[@class='minPrice']/input");
            By maxPrice = By.xpath("//li[@class='maxPrice']/input");
            By conditions = By.xpath("//div[@class='widget cz-filter mb-4 conditionFilter filter']/ul/li/div/label");
            By brands = By.xpath("//div[@class='widget cz-filter mb-4 brandFilter filter']/ul/li/div/label");
    public  By selectedCondition = By.cssSelector("div.widget.cz-filter.mb-4.conditionFilter.filter > ul > li > div > input:checked~.custom-control-label span");
    public  By selectedBrand = By.cssSelector("div.widget.cz-filter.mb-4.brandfilter.filter > ul > li > div > input:checked~.custom-control-label");
    // Product Section //
    public  By allProducts = By.xpath("//div[@class='productType']/span");
            By productType = By.xpath("//div[@class='productType']/span[@class='badge badge-success badge-shadow']");
            By productImage = By.xpath("//div[@class='productImage']/a");
            By addToWishlist  = By.xpath("(//button[starts-with(@title,'Add to wishlist')])");
            By removeToWishList = By.xpath("//button[@class='btn-wishlist btn-sm addWishedGreen']");
            By addToCart = By.xpath("(//a[starts-with(@id,'cartButton-')])");
    public  By removeToCart = By.xpath("//a[@class='btn btn-primary addToCartButton addCartedGreen']");
            By AfterSignIn = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[4]/div/a/span[1]");

    public  By ProductDetailPage = By.xpath("//div[@class='cart-info text-left']");

    public void selectRandomCategory() {
        explicitWait(categories);
        getRandomElement(categories, categoriesLinkPage);
        String category = driver.getCurrentUrl().replace("http://web.cartlow.lan/search?category_id=", "");
        gs.setCategory(category);
    }
    public void enterMinPrice() {
        expected = faker.number().numberBetween(2, 99);
        sendKeys(minPrice, minPrice, expected);
        actual = getValueUsingJS("minPrice");
        gs.setMinPrice(expected);
    }
    public void enterMaxPrice() {
        expected = faker.number().numberBetween(300, 1000);
        sendKeys(maxPrice, maxPrice, expected);
        actual = getValueUsingJS("maxPrice");
        gs.setMaxPrice(expected);
    }
    public void selectRandomCondition() {
        getRandomElement( conditions, selectedCondition);
        String getCondition = driver.findElement(selectedCondition).getText();
        gs.setConditions(getCondition);
    }
    public void selectRandomBrand() {
        scrollToElement(brands);
        getRandomElement(brands, selectedBrand);
        String getBrand = driver.findElement(selectedBrand).getAttribute("for").replace("brand-", "");
        gs.setBrands(getBrand);
    }
    public void getAllProducts() {
        scrollToEnd(productType);
        scrollUp();
    }
    public void checkErrorForMinPrice() {
        int getMaxValue = getValueUsingJS("maxPrice");
        int price = faker.number().numberBetween(getMaxValue + 1, getMaxValue + 1000);
        sendKeys(minPrice, minPrice, price);
    }
    public void checkErrorForMaxPrice() {
        int getMinValue = getValueUsingJS("minPrice");
        int price = faker.number().numberBetween(0, getMinValue - 1);
        sendKeys(maxPrice, maxPrice, price);
    }
    public void addToWishList_BL(){
        if (driver.findElements(allProducts).size() == 0) {
            refresh();
        }
        explicitWait(allProducts);
        getRandomElement(addToWishlist,signInModal);
        explicitWait(signInModal);
    }
    public void signInModalCloseOnAddToWishList() {
        explicitWait(cancelModal);
        driver.findElement(cancelModal).click();
        explicitWaitNot(cancelModal);
    }
    public void addToCart(){
        explicitWait(allProducts);
        getRandomElement(addToCart,toast);
        explicitWaitNot(toast);
    }
    public void removeToCart(){
        explicitWait(allProducts);
        getRandomElement(removeToCart,toast);
        explicitWaitNot(toast);
    }
    public void addToWishList_AL() throws SQLException {
        explicitWaitNot(toast);
        login.userLogin();
        explicitWait(AfterSignIn);
        explicitWait(allProducts);
        getRandomElement(addToWishlist,toast);
        explicitWaitNot(toast);
    }
    public void removeToWishList_AL() {
        explicitWait(allProducts);
        getRandomElement(removeToWishList,toast);
        explicitWaitNot(toast);
    }
    public void currentCountryCurrency(){
        explicitWaitNot(toast);
        getAllProducts();
        getCurrentCountry = driver.findElement(country).getText();
    }
    public void productDetailPage(){
        explicitWait(productImage);
        getRandomElement(productImage,ProductDetailPage);
    }
}
