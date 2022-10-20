package Base;

import org.openqa.selenium.By;

public class Env {

    // URLS
    public static String Production_URL = "https://www.cartlow.com/";
    public static String Production_Category_URL = "https://www.cartlow.com/search?category_id=27000";
    public static String Stage_URL = "http://web.cartlow.lan/";
    public static String Test_URL = "http://web.cartlow.lan/pdp/id5603628/apple-iphone-xs-max-with-facetime-512gb-4g-lte-space-gray";
    public static String Stage_Category_URL = "http://web.cartlow.lan/search?category_id=27000";
    public static String Stage_DB_URL = "jdbc:mysql://cartlow.lan:3306/fantacy4";

    // QR
    By QR = By.xpath("//*[@id=\"app-modal\"]/div/div/div[1]/button/span");

    // Use UAE, KSA OR KWT
    public static String Country = "UAE";

    // Use English or Arabic
    public static String Language = "English";
    // Use Stage Or Production DB as per requirement
    public static String DB_UserName = "root";
    public static String DB_Password = "Lahore@123";

    // Error //
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

}
