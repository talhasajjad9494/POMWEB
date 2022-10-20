package TestCases;

import Database.DBProducts;
import Pages.ProductDetailPage;
import Utilities.GetterSetter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Objects;

public class ProductDetailPageTest extends ProductDetailPage {

    DBProducts dbProducts = new DBProducts();
    GetterSetter gs = new GetterSetter();
    @Test(priority = 1)
    public void testProductImageIsAppearing() {
        productImageIsAppearing();
        Assert.assertTrue(driver.findElement(productImage).isDisplayed());
    }
    @Test(priority = 2)
    public void testProductImageThumbnailIsAppearing() throws InterruptedException {
        productImageThumbnailIsAppearing();
        for(int i=0;i<getThumbnailSize;i++){
            driver.findElements(productThumbnailImage).get(i).click();
            Thread.sleep(1500);
            Assert.assertTrue(driver.findElements(productImage).get(i).isDisplayed());
        }
    }
    @Test(priority = 3)
    public void testProductFeatureIsAppearing() throws SQLException {
        productFeatureIsAppearing();
        int[] list = {9, 10, 15, 16, 18, 20, 21, 22, 24};
        for (int value :list){
            if (dbProducts.getFeatureOfProduct()==value) {
                Assert.assertTrue(driver.findElement(productFeatures).isDisplayed());
                break;
            }
        }
    }
    @Test(priority = 4)
    public void testProductTitleIsAppearing() {
        productTitleIsAppearing();
        Assert.assertTrue(driver.findElement(productTitle).isDisplayed());
    }
    @Test(priority = 5)
    public void testProductPriceIsAppearing() {
        productPriceIsAppearing();
        Assert.assertTrue(driver.findElement(productPrice).isDisplayed());
    }
    @Test(priority = 6)
    public void testProductMRPPriceIsAppearing() {
        productMRPPriceIsAppearing();
        Assert.assertTrue(driver.findElement(productMRPPrice).isDisplayed());
    }
    @Test(priority = 7)
    public void testProductPriceIsLessThanMRPPrice() {
        productPriceIsLessThanMRP();
        int Price = Integer.parseInt(driver.findElement(productPrice).getText());
        int MRPrice = Integer.parseInt(driver.findElement(productMRPPrice).getText());
        Assert.assertTrue(MRPrice>Price);
    }
    @Test(priority = 8)
    public void testDiscountValueIsAppearing() {
        discountValueIsAppearing();
        Assert.assertTrue(driver.findElement(productDiscountValue).isDisplayed());
    }
    @Test(priority = 9)
    public void testDiscountValueIsAccurate(){
        discountValueIsAccurate();
        int actual = Integer.parseInt(driver.findElement(productDiscountValue).getText());
        int expected = getActualSaveValue;
        Assert.assertEquals(actual,expected);
    }
    @Test(priority = 10)
    public void testQuantityIsAppearing() {
        quantityIsAppearing();
        int getQuantity = Integer.parseInt(driver.findElement(productTotalQuantity).getText());
        if (getQuantity<10){
            Assert.assertTrue(driver.findElement(productTotalQuantity).isDisplayed());
        }
    }
    @Test(priority = 11)
    public void testStoreIsAppearing() {
        storeIsAppearing();
        Assert.assertTrue(driver.findElement(productStoreName).isDisplayed());
    }

    @Test(priority = 12)
    public void testViewAllButtonIsWorking() {
        viewAllButtonIsWorking();
        Assert.assertTrue(driver.findElement(productViewAllButton).isDisplayed());
    }

    @Test(priority = 13)
    public void testDeliveryTimeIsAppearing() throws SQLException {
        deliveryTimeIsAppearing();
        int productStoreCountryID = dbProducts.getStoreCountryID();
        int productInHouse = dbProducts.getStoreStatus();
        int productCountryID = dbProducts.getProductCountryID();
        int productQuantity = dbProducts.getProductQuantity();
        if (productStoreCountryID==productCountryID && productInHouse==1 &&  productQuantity>0){
             Assert.assertEquals(getDeliveryTime, "Delivery in 72 Hours");
        }
        else{
            Assert.assertEquals(getDeliveryTime,"Delivery in 3-5 business days");
        }
    }
    @Test(priority = 14)
    public void testConditionIsAppearing() {
        conditionIsAppearing();
        if(Objects.equals(getProductType, "pdp")){
            Assert.assertTrue(driver.findElement(productConditionLegacy).isDisplayed());
        }
        else {
            Assert.assertTrue(driver.findElements(productOptionsVariation).size()>0);
        }

    }

    @Test(priority = 15)
    public void testConditionDescriptionIsAppearing() {
        conditionDescriptionIsAppearing();
        Assert.assertTrue(driver.findElement(productConditionDescription).isDisplayed());
    }

    @Test(priority = 16)
    public void testQuantityFieldIsAppearing() {
        quantityFieldIsAppearing();
        Assert.assertTrue(driver.findElement(productQuantityField).isDisplayed());
    }

    @Test(priority = 17)
    public void testQuantityIncrementButtonIsClickable() throws SQLException {
        int getQuantity = dbProducts.getProductQuantity();
        for (int i=0;i<getQuantity;i++){
            quantityIncrementButtonIsClickable();
            if (driver.findElements(toast).size()>0){
                explicitWait(toast);
                String getToast = driver.findElement(toast).getText();
                Assert.assertEquals(getToast,"You have reached Maximum Buyable Limit");
                break;
            }
        }
    }

    @Test(priority = 18)
    public void testQuantityDecrementButtonIsClickable() throws SQLException {
        int getQuantity = dbProducts.getProductQuantity();
        for (int i=0;i<getQuantity;i++){
            quantityDecrementButtonIsClickable();
            if (driver.findElements(toast).size()>0){
                explicitWait(toast);
                String getToast = driver.findElement(toast).getText();
                Assert.assertEquals(getToast,"You have reached Minimum Buyable Limit");
                break;
            }
        }
    }
    @Test(priority = 19)
    public void testAddToCartButtonIsClickable() {
        addToCartButtonIsClickable();
        Assert.assertEquals(driver.getCurrentUrl(), "http://web.cartlow.lan/cart/show");
    }

    @Test(priority = 20)
    public void testBuyNowButtonIsClickable() {
        buyNowButtonIsClickable();
        Assert.assertEquals(driver.getCurrentUrl(),"http://web.cartlow.lan/checkout?rdr=/checkout");
    }

    @Test(priority = 21)
    public void testProductDetailIsAppearing() {
        productDetailIsAppearing();
        Assert.assertTrue(driver.findElement(productDescription).isDisplayed());

    }
}