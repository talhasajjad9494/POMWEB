package Pages;

import Base.BaseDriver;
import org.openqa.selenium.By;

public class LanguageDropdown extends BaseDriver {

    public By language = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[2]/div/a/span");
    public  By languageDropdown = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[2]/div/div");
    By languageEnglish = By.xpath("//*[@id='getLocalForm']/li[1]/a");
    By languageArabic = By.xpath("//*[@id='getLocalForm']/li[2]/a");

    public void languageDropdown() {
        explicitWait(language);
        driver.findElement(language).click();
    }
    public void ChangeLanguageToArabic() {
        explicitWait(languageDropdown);
        driver.findElement(languageArabic).click();
        explicitWait(language);
    }
    public void ChangeLanguageToEnglish() {
        languageDropdown();
        explicitWait(languageDropdown);
        driver.findElement(languageEnglish).click();
        explicitWait(language);
    }
}
