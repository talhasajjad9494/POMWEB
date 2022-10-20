package Utilities;

import Base.BaseDriver;
import org.openqa.selenium.By;

public class Logout extends BaseDriver {

    By userProfileButton = By.xpath("//span[@class='text username-limit']");
    By logoutButton = By.xpath("//*[@id='form-button']");

    public void userLogout(){
        driver.findElement(userProfileButton).click();
        explicitWait(logoutButton);
        driver.findElement(logoutButton).click();
    }
}
