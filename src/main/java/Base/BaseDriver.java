package Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver extends Env {

    public static WebDriver driver;
    public static String url = Test_URL;
    public static String dbURL = Stage_DB_URL;
    public static String dbUsername = DB_UserName;
    public static String dbPassword = DB_Password;
    public static Connection con;
    public static Statement statement;
    public Faker faker = new Faker(new Locale("en-PAK"));
    ChromeOptions option = new ChromeOptions();

    @BeforeTest
    public void main() throws InterruptedException, ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        statement = con.createStatement();
        WebDriverManager.chromedriver().setup();
        option.addArguments("--disable-blink-features=AutomationControlled");
        option.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(QR).click();
        explicitWaitNot(QR);
    }

    @AfterSuite
    public void close() throws SQLException {
        statement.close();
        con.close();
    }

    public void explicitWait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void explicitWaitNot(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(element)));
    }

    public void clickElementThroughJS(By element) {
        WebElement ele = driver.findElement(element);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", ele);
    }

    public int getRandomValue(int max, int min) {
        Random rand = new Random();
        return rand.nextInt(max - min) + 1;
    }

    public void getRandomElement(By element1, By element2) {
        Random rand = new Random();
        List<WebElement> elements = driver.findElements(element1);
        int size = elements.size();
        if (size <= 4 && size > 0) {
            int result = rand.nextInt(size);
            elements.get(result).click();
            explicitWait(element2);
        }
        else if(size > 4){
            int result = rand.nextInt(4-1)+1;
            elements.get(result).click();
            explicitWait(element2);
        }

    }

    public void sendKeys(By element, By element1, int expected) {
        explicitWait(element);
        driver.findElement(element1).sendKeys(Keys.chord(Keys.CONTROL + "a") + expected + Keys.chord(Keys.ENTER));
    }

    public void Delay(int j) {
        for (int i = 0; i < j; i++) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goBackToHomePage() {
        if (!(driver.getCurrentUrl().equals(url))) {
            driver.get(url);
        }
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void scrollToEnd(By productType) {
        By body = By.xpath("//body");
        By loader = By.xpath("//div[@class='loader']/div");
        By footer = By.xpath("//footer");
        List<WebElement> Products = driver.findElements(productType);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (!(driver.getCurrentUrl().equals(url))) {
            while (true) {
                if (Products.size() > 0) {
                    explicitWait(productType);
                    driver.findElement(body).sendKeys(Keys.END);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (driver.findElements(loader).size() > 0 || !(driver.findElement(footer).isEnabled())) {
                        explicitWait(productType);
                    } else {
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
        else{
            while (true) {
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                if (driver.findElements(loader).size() == 0)
                    break;
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            }
        }
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)", "");
    }

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    public int getValueUsingJS(String id) {
        WebElement element = driver.findElement(By.id(id));
        return Integer.parseInt(element.getAttribute("value"));
    }

    public void scrollToElement(By element) {
        WebElement element1 = driver.findElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
        scrollUp();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getBase64() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

    public String dbQuery(String query, String column) throws SQLException {
        ResultSet resultSet = statement.executeQuery(query);
        String data = null;
        while (resultSet.next()) {
            data = resultSet.getString(column);
        }
        return data;
    }
}
