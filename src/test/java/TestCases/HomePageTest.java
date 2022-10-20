package TestCases;

import Pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class HomePageTest extends HomePage {

    @Test(priority = 1)
    public void verifyCountryIsSelected(){
        SelectCountry();
        Assert.assertEquals(Country, driver.findElement(country).getText());
    }
    @Test(priority = 2)
    public void verifyLanguageIsSelected(){
        SelectLanguage();
        Assert.assertEquals(Language, driver.findElement(language).getText());
    }
    @Test(priority = 3)
    public void verifyLogo(){
        logo();
        Assert.assertTrue(driver.findElement(logo).isDisplayed());
    }
    @Test(priority = 4)
    public void verifySearchingSuggestion(){
        SearchSuggestion();
        for (WebElement search:searchList){
            Assert.assertTrue(search.getText().contains(words[searchWord]));
        }
    }
    @Test(priority = 5)
    public void verifySearchButton(){
        SearchButtonWithoutText();
        Assert.assertEquals(driver.findElements(searchCheck).size(), 0);
    }
    @Test(priority = 6)
    public void verifySearchButtonWithText(){
        SearchButtonWithText();
        Assert.assertTrue(driver.findElements(searchCheck).size()>0);
    }
    @Test(priority = 7)
    public void verifyCartDropdown(){
        CartDropdown();
        Assert.assertTrue(driver.findElement(cartDropdown).isDisplayed());
    }
    @Test(priority = 8)
    public void verifyCartCounter(){
        CartCounter();
        Assert.assertEquals(getCartCounterSize,getCartProductSize);
    }
    @Test(priority = 9)
    public void verifySignIn(){
        SignIn();
        Assert.assertTrue(driver.findElement(signInModal).isDisplayed());
    }
    @Test(priority = 10)
    public void verifySignInModalClose(){
        SignInModalClose();
        Assert.assertEquals(driver.findElements(cancelModal).size(), 0);
    }
    @Test(priority = 11)
    public void verifyAllCategories(){
        AllCategories();
        Assert.assertTrue(driver.findElement(allCategoriesDropdown).isDisplayed());
    }
    @Test(priority = 12)
    public void verifyAllCategoriesDropdown(){
        AllCategoriesDropdown();
        Assert.assertTrue(driver.findElement(allCategoriesInnerDropdown).isDisplayed());
    }
    @Test(priority = 13)
    public void verifyAllInnerCategoriesDropdown(){
        AllInnerCategoriesDropdown();
        Assert.assertTrue(driver.findElement(categoriesLinkPage).isDisplayed());
    }
    @Test(priority = 14)
    public void verifyCategories(){
        Categories();
        Assert.assertTrue(driver.findElement(categoriesLinkPage).isDisplayed());
    }
    @Test(priority = 15)
    public void verifyMoreCategory(){
        MoreCategory();
        Assert.assertTrue(driver.findElement(moreCategoriesDropdown).isDisplayed());
    }
    @Test(priority = 16)
    public void verifyMoreCategoryDropdown(){
        MoreCategoriesFromDropdown();
        Assert.assertTrue(driver.findElement(categoriesLinkPage).isDisplayed());
    }
    @Test(priority = 17)
    public void verifyBuyNowPayLater(){
        BuyNowPayLater();
        Assert.assertTrue(driver.findElement(buyNowPayLaterPage).isDisplayed());
    }
    @Test(priority = 18)
    public void verifyBuyBack(){
        BuyBack();
        Assert.assertTrue(driver.findElement(getSellYourItemPage).isDisplayed());
    }
    @Test(priority = 19)
    public void verifyAddToWishList_BL(){
        AddToWishList_BL();
        Assert.assertTrue(driver.findElement(signInModal).isDisplayed());
    }
    @Test(priority = 20)
    public void verifyModalClose(){
        SignInModalCloseOnAddToWishList();
        Assert.assertEquals(driver.findElements(signInModal).size(), 0);
    }
    @Test(priority = 21)
    public void verifyAddToCart_BL(){
        AddToCart_BL();
        Assert.assertTrue(driver.findElements(Toast).size()>0);
    }
    @Test(priority = 22)
    public void verifyRemoveToCart_BL(){
        RemoveToCart_BL();
        Assert.assertTrue(driver.findElements(Toast).size()>0);
    }
    @Test(priority = 23)
    public void verifyAddToWishList_AL() throws SQLException {
        AddToWishList_AL();
        Assert.assertTrue(driver.findElements(Toast).size()>0);
    }
    @Test(priority = 24)
    public void verifyRemoveToWishList_AL() {
        RemoveToWishList_AL();
        Assert.assertTrue(driver.findElements(Toast).size()>0);
    }
    @Test(priority = 25)
    public void verifyHeaderMenuButton() {
        HeaderMenuButton();
        Assert.assertTrue(driver.findElement(allCategories).isDisplayed());
    }
    @Test(priority = 26)
    public void verifyLogout(){
        logout();
    }

}
