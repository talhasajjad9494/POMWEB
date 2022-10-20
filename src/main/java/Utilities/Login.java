package Utilities;

import java.sql.SQLException;

import org.openqa.selenium.By;

import Base.BaseDriver;
import Database.DBUsers;

public class Login extends BaseDriver {

    DBUsers users = new DBUsers();
    By signIn = By.xpath("//span[text()='Sign in']");
    By signInEmail = By.xpath("//input[@id='si-email']");
    By signInPassword = By.xpath("//input[@id='si-password']");
    By signInButton = By.xpath("//button[@id='sign-in']");

    public void userLogin() throws SQLException {
        String email = users.userEmail();
        String getLoginStatus = driver.findElement(signIn).getText();
        if (getLoginStatus.equals("Sign in")){
            driver.findElement(signIn).click();
            explicitWait(signInEmail);
            driver.findElement(signInEmail).sendKeys(email);
            driver.findElement(signInPassword).sendKeys("demo101");
            driver.findElement(signInButton).click();
        }
    }
}
