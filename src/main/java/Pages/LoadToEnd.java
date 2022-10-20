package Pages;

import Base.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LoadToEnd  {

    @Test
   public void Test(){
       long mrpPrice = 3799;
       long actualPrice = 2652;
       double savePrice = mrpPrice-actualPrice;
       double getSavePrice = (savePrice / mrpPrice)*100;
       String truncated = String.format("%.0f",getSavePrice);
       int getActualSaveValue = Integer.parseInt(truncated);
       System.out.println(getActualSaveValue);
   }
}
