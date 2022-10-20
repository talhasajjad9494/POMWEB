package TestCases;

import Pages.CountryDropdown;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CountryDropdownTest extends CountryDropdown {

    @Test(priority = 1)
    public void verifyCountryDropdown(){
        countryDropdown();
        Assert.assertTrue(driver.findElement(countryDropdown).isDisplayed());

    }
    @Test(priority = 2)
    public void verifyCountryChangeToKWT(){
        ChangeCountryToKWT();
        Assert.assertTrue(driver.findElement(country).getText().contains("KWT"));
    }
    @Test(priority = 3)
    public void verifyCountryChangeToKSA(){
        ChangeCountryToKSA();
        Assert.assertTrue(driver.findElement(country).getText().contains("KSA"));
    }
    @Test(priority = 4)
    public void verifyCountryChangeToUAE(){
        ChangeCountryToUAE();
        Assert.assertTrue(driver.findElement(country).getText().contains("UAE"));
    }
}
