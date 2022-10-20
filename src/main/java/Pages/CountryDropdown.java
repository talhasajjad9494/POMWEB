package Pages;

import Base.BaseDriver;
import org.openqa.selenium.By;


public class CountryDropdown extends BaseDriver {
    public By country = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[1]");
    public  By countryDropdown = By.xpath("//li[@class='flagBox']/div/div[@aria-labelledby='dropdownMenuLink']");
    By countryUAE = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[1]/div/div/form/li/a[1]/span[2]/span");
    By countryKSA = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[1]/div/div/form/li/a[2]/span[2]/span");
    By countryKWT = By.xpath("//div[@class='style2CenterBoxRightSide']/ul/li[1]/div/div/form/li/a[3]/span[2]/span");

    public void countryDropdown() {
        if (!(driver.getCurrentUrl().equals(url))){
            driver.navigate().to(url);
        }
        explicitWait(country);
        driver.findElement(country).click();
    }

    public void ChangeCountryToKWT() {
        explicitWait(countryDropdown);
        driver.findElement(countryKWT).click();
        explicitWait(country);
    }

    public void ChangeCountryToKSA() {
        countryDropdown();
        explicitWait(countryDropdown);
        driver.findElement(countryKSA).click();
        explicitWait(country);

    }
    public void ChangeCountryToUAE() {
        countryDropdown();
        explicitWait(countryDropdown);
        driver.findElement(countryUAE).click();
        explicitWait(country);
    }
}
