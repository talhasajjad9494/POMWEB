package Pages;

import Base.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LinksOfHomePage extends BaseDriver {
    public static ArrayList<String> category_list = new ArrayList<>();
    public static ArrayList<String> section_list = new ArrayList<>();
    public static ArrayList<String> element_list = new ArrayList<>();
    public static ArrayList<String> condition_list = new ArrayList<>();

    // Section_Links //
    public By section_id_Product_Page = By.xpath("//div[@class='container pb-5 mt-3 mb-2 mb-md-4']/div/section/div[2]/div/div/div");
    // Element_Links //
    public  By element_id_Product_Page = By.xpath("//div[@class='container pb-5 mt-3 mb-2 mb-md-4']/div/section/div[2]/div/div/div");
    // Condition_links //
    public  By condition_id_Product_Page = By.xpath("//div[@class='container pb-5 mt-3 mb-2 mb-md-4']/div/section/div[2]/div/div/div");
    // Category_links //
    public  By category_id_Product_Page = By.xpath("//div[@class='container pb-5 mt-3 mb-2 mb-md-4']/div/section/div[2]/div/div/div");

    By productType = By.xpath("//div[@class='productType']/span[@class='badge badge-success badge-shadow']");
    // Href //
    By linksHref = By.xpath("//a[@href]");
    By linksData_ItemURL = By.xpath("//a[@data-itemurl]");

    public  By categoriesLinkPage = By.xpath("//div[@class='container pb-5 mt-3 mb-2 mb-md-4']/div/section");

    public void getAllLinksFromHomePage() {
        scrollToEnd(productType);
        List<WebElement> links_Href = driver.findElements(linksHref);
        List<WebElement> links_dataItemURL = driver.findElements(linksData_ItemURL);

        for (WebElement link : links_Href) {
            String href = link.getAttribute("href");
            if (href.contains("section_id")) {
                section_list.add(href);
            }
            if (href.contains("condition_id")) {
                condition_list.add(href);
            }
            if (href.contains("category_id")) {
                category_list.add(href);
            }
        }
        for (WebElement link : links_dataItemURL) {
            String data_ItemURL = link.getAttribute("data-itemurl");
            if (data_ItemURL.contains("element_id")) {
                element_list.add(data_ItemURL);
            }
        }
    }
    public void LinksOnHomePage(ArrayList<String> element1, By element2) {
        int i = 0;
        for (String link : element1) {
            driver.navigate().to(link);
            explicitWait(categoriesLinkPage);
            if (driver.findElements(element2).size() > 0) {
                System.out.println(i + " Test Case Passed! " + element1.get(i));
            } else {
                System.out.println(ANSI_RED + i + " Test Case Failed! " + element1.get(i) + ANSI_RESET);
            }
            i++;
        }
    }
}
