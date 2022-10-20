package Pages;

import Base.BaseDriver;
import Utilities.GetterSetter;
import org.openqa.selenium.By;

import java.util.Objects;

public class ProductDetailPage extends BaseDriver {
    GetterSetter gs = new GetterSetter();
    public static int getThumbnailSize;
    public static int getActualSaveValue;
    public static String getDeliveryTime;
    public static String getProductType;

    public  By productImage = By.xpath("//div[@class='cz-preview order-sm-2']/div/img");
    public  By productThumbnailImage = By.xpath("//div[@class='cz-thumblist order-sm-1']/a[not(contains(@class,'hidden'))]/img");
    public  By productFeatures = By.xpath("//div[@class='product-feature-wrap mt-3 ']/ul/li");
    public  By productTitle = By.xpath("//h1[@id='var_name']");
    public  By productPrice = By.xpath("//span[@id='var_price']");
    public  By productMRPPrice = By.xpath("//span[@id='var_market_price']");
    public  By productDiscountValue = By.xpath("//span[@id='var_discount']");
    public  By productTotalQuantity = By.xpath("//span[@id='var_quantity']");
    public  By productStoreName = By.xpath("//div[@class=' mt-3 mb-3  font-weight-bold']/div[1] | //div[@class=' mt-3 mb-3  font-weight-bold']/span[@id='shop_name']");
    public  By productViewAllButton = By.xpath("//a[text()='View All']");
    public  By productDeliveryTime = By.xpath("//div[contains(@class,'text-green-custom font-weight-bold')]");
    public  By productConditionLegacy = By.xpath("//span[@class='text-light rounded condition-btn']");
    public  By productOptionsVariation = By.xpath("//button[contains(@class,'btn btn-sm btn-primary-custom')]");
    public  By productConditionDescription = By.xpath("//div[contains(@class,'condition_description_sec')]");
    public  By productQuantityField = By.xpath("//input[contains(@class,'quantity-field')]");
    public  By productQuantityIncrementButton = By.xpath("//input[contains(@class,'button-plus')]");
    public  By ProductQuantityDecrementButton = By.xpath("//input[contains(@class,'button-minus')]");
    public  By productAddToCartButton = By.xpath("//button[@class='btn btn-primary btn-shadow btn-block add_cart_button']");
    public  By toast = By.xpath("//div[@class='Vue-Toastification__container top-right']/div/div[1]");
    public  By productBuyNowOrMyCartButton = By.xpath("//button[@class='btn btn-primary btn-shadow btn-block my-cart-btn']");
    public  By productDescription = By.xpath("//div[@class='discription_sec_pro_page' or @class='des-pro-sec']");


    public void productImageIsAppearing(){
        explicitWait(productImage);
    }
    public void productImageThumbnailIsAppearing()  {
        explicitWait(productThumbnailImage);
        getThumbnailSize = driver.findElements(productThumbnailImage).size();

    }
    // Make Sure this option will appear for some products
    public void productFeatureIsAppearing(){
        explicitWait(productThumbnailImage);
        String getPID = driver.getCurrentUrl();
        String[] id =getPID.split("/");
        gs.setPID(id[4].replace("id",""));
    }
    public void productTitleIsAppearing(){
        explicitWait(productTitle);
    }
    public void productPriceIsAppearing(){
        explicitWait(productPrice);

    }
    public void productMRPPriceIsAppearing(){
        explicitWait(productMRPPrice);
    }
    public void productPriceIsLessThanMRP(){
        explicitWait(productPrice);

    }
    public void discountValueIsAppearing(){
        explicitWait(productDiscountValue);
    }
    public void discountValueIsAccurate(){
        explicitWait(productDiscountValue);
        long actualPrice = Integer.parseInt(driver.findElement(productPrice).getText());
        long mrpPrice =  Integer.parseInt(driver.findElement(productMRPPrice).getText());
        double savePrice = mrpPrice-actualPrice;
        double getSavePrice = (savePrice / mrpPrice)*100;
        String truncated = String.format("%.0f",getSavePrice);
        getActualSaveValue = Integer.parseInt(truncated);

    }
    // Make Sure this function will execute when quantity is less than 10
    public void quantityIsAppearing(){
        explicitWait(productPrice);
    }
    public void storeIsAppearing(){
        explicitWait(productStoreName);
        String getStoreName = driver.findElement(productStoreName).getText();
        if (getStoreName.contains("Sold By")){
            getStoreName = getStoreName.replace("Sold By ","");
        }
        gs.setStoreName(getStoreName);
    }
    public void viewAllButtonIsWorking(){
        explicitWait(productViewAllButton);

    }
    public void deliveryTimeIsAppearing(){
        explicitWait(productDeliveryTime);
        getDeliveryTime = driver.findElement(productDeliveryTime).getText();

    }
    public void conditionIsAppearing(){
        String ProductType = driver.getCurrentUrl();
        String[] id =ProductType.split("/");
        getProductType = id[3];
    }
    public void conditionDescriptionIsAppearing(){
        explicitWait(productConditionDescription);

    }
    public void quantityFieldIsAppearing(){
        explicitWait(productQuantityField);
    }
    public void quantityIncrementButtonIsClickable(){
        explicitWait(productQuantityIncrementButton);
        driver.findElement(productQuantityIncrementButton).click();

    }
    public void quantityDecrementButtonIsClickable(){
        explicitWait(ProductQuantityDecrementButton);
        driver.findElement(ProductQuantityDecrementButton).click();

    }
    public void addToCartButtonIsClickable(){
        explicitWait(productAddToCartButton);
        driver.findElement(productAddToCartButton).click();
        explicitWaitNot(productAddToCartButton);
    }
    public void buyNowButtonIsClickable(){
        goBack();
        explicitWait(productBuyNowOrMyCartButton);
        driver.findElement(productBuyNowOrMyCartButton).click();
        explicitWaitNot(productBuyNowOrMyCartButton);
    }
    public void productDetailIsAppearing(){
        if (driver.getCurrentUrl().equals("http://web.cartlow.lan/cart/show")){
            goBack();
        }
        explicitWait(productDescription);
    }

}
