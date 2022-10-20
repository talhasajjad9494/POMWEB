package TestCases;

import Pages.LinksOfHomePage;
import org.testng.annotations.Test;

public class LinksOfHomePageTest extends LinksOfHomePage {
     @Test(priority = 1)
     public void GetLinksFromHomePage(){
         getAllLinksFromHomePage();
     }
     @Test(priority = 2)
     public void verifySection_LinksOfHomePage(){ LinksOnHomePage(section_list,section_id_Product_Page);}
     @Test(priority = 3)
     public void verifyElement_LinksOfHomePage(){
         LinksOnHomePage(element_list,element_id_Product_Page);
     }
     @Test(priority = 4)
     public void verifyCondition_LinksOfHomePage(){
         LinksOnHomePage(condition_list,condition_id_Product_Page);
     }
     @Test(priority = 5)
     public void verifyCategory_LinksOfHomePage(){
         LinksOnHomePage(category_list,category_id_Product_Page);
    }
}
