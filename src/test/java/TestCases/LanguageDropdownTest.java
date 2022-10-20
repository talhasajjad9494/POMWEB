package TestCases;

import Pages.LanguageDropdown;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LanguageDropdownTest extends LanguageDropdown {
    @Test(priority = 1)
    public void verifyLanguageDropdown(){
        languageDropdown();
        Assert.assertTrue(driver.findElement(languageDropdown).isDisplayed());
    }
    @Test(priority = 2)
    public void verifyLanguageChangeToArabic(){
        ChangeLanguageToArabic();
        Assert.assertTrue(driver.findElement(language).getText().contains("عربي"));
    }
    @Test(priority = 3)
    public void verifyLanguageChangeToEnglish(){
        ChangeLanguageToEnglish();
        Assert.assertTrue(driver.findElement(language).getText().contains("English"));
    }
}
