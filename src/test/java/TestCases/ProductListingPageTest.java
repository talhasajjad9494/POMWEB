package TestCases;

import Database.DBProducts;
import Pages.ProductListingPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.SQLException;

public class ProductListingPageTest extends ProductListingPage  {
    DBProducts dbProducts = new DBProducts();
    @Test(priority = 1)
    public void verifyCategoryIsSelected(){
        selectRandomCategory();
        boolean expected = driver.findElement(categoriesLinkPage).isDisplayed();
        Assert.assertTrue(expected);
    }
    @Test(priority = 2)
    public void verifyMinPriceIsSet(){
        enterMinPrice();
        Assert.assertEquals(actual,expected);
    }
    @Test(priority = 3)
    public void verifyMaxPriceIsSet(){
        enterMaxPrice();
        Assert.assertEquals(actual,expected);
    }
    @Test(priority = 4)
    public void verifyPriceRangeOfAllProducts() throws SQLException {
        getAllProducts();
        int expected = dbProducts.getCountOnPriceRange();
        int actual = driver.findElements(allProducts).size();
        Assert.assertEquals(actual,expected);
    }
    @Test(priority = 5)
    public void verifyConditionIsSelected(){
        selectRandomCondition();
        int size = driver.findElements(selectedCondition).size();
        Assert.assertTrue(size>0);
    }
    @Test(priority = 6)
    public void verifyConditionOfAllProducts() throws SQLException {
        getAllProducts();
        int expected = dbProducts.getCountOfSelectedConditionFromDB();
        int actual = driver.findElements(allProducts).size();
        Assert.assertEquals(actual,expected);
    }
    @Test(priority = 7)
    public void verifyBrandIsSelected(){
        selectRandomBrand();
        int size = driver.findElements(selectedBrand).size();
        Assert.assertTrue(size>0);
    }
    @Test(priority = 8)
    public void verifyBrandOfAllProducts() throws SQLException {
        getAllProducts();
        int expected = dbProducts.getCountOfSelectedBrandFromDB();
        int actual = driver.findElements(allProducts).size();
        Assert.assertEquals(actual,expected);
    }
    @Test(priority = 9)
    public void verifyErrorIsAppearingWhenEnterMinValueGreaterThanMaxValue(){
        checkErrorForMinPrice();
        Assert.assertTrue(driver.findElements(toast).size()>0);
    }
    @Test(priority = 10)
    public void verifyErrorIsAppearingWhenEnterMaxValueLessThanMinValue(){
        checkErrorForMaxPrice();
        int size = driver.findElements(toast).size();
        Assert.assertTrue(size>0);
    }
    @Test(priority = 11)
    public void verifyAddToWishList_BL(){
        addToWishList_BL();
        Assert.assertTrue(driver.findElements(signInModal).size()>0);
    }
    @Test(priority = 12)
    public void verifyModalClose(){
        signInModalCloseOnAddToWishList();
        Assert.assertEquals(driver.findElements(signInModal).size(), 0);
    }
    @Test(priority = 13)
    public void verifyProductIsAddingToCart(){
        addToCart();
        int size = driver.findElements(toast).size();
        Assert.assertTrue(size>0);
    }
    @Test(priority = 14)
    public void verifyProductIsRemovingToCart(){
        removeToCart();
        int size = driver.findElements(toast).size();
        Assert.assertTrue(size>0);
    }
    @Test(priority = 15)
    public void verifyAddToWishList_AL() throws SQLException {
        addToWishList_AL();
        Assert.assertTrue(driver.findElements(toast).size()>0);
    }
    @Test(priority = 16)
    public void verifyRemoveToWishList_AL(){
        removeToWishList_AL();
        Assert.assertTrue(driver.findElements(toast).size()>0);
    }
    @Test(priority = 17)
    public void verifyCurrencyOfProducts(){
        currentCountryCurrency();
        int allProducts = driver.findElements(currentCountryCurrency).size();
        for (int i=0;i<allProducts;i++){
            String getEachProductCurrency = driver.findElement(currentCountryCurrency).getText();
            switch (getCurrentCountry){
                case "KSA" ->{
                    Assert.assertTrue(getEachProductCurrency.contains("SAR"));
                }
                case "KWT" ->{
                    Assert.assertTrue(getEachProductCurrency.contains("KWD"));
                }
                default -> Assert.assertTrue(getEachProductCurrency.contains("AED"));
            }
        }
    }
    @Test(priority = 18)
    public void verityProductDetailScreen(){
        productDetailPage();
        Assert.assertTrue(driver.findElement(ProductDetailPage).isDisplayed());
    }
}
