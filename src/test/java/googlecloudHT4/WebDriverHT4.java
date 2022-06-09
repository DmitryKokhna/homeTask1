package googlecloudHT4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.security.Key;

public class WebDriverHT4 {

    public String urlCloud="https://cloud.google.com/";
    public String stringForSearch="Google Cloud Platform Calculator";
    public String locatorSearch="//div[@class='devsite-searchbox' ]//input[@class='devsite-search-field devsite-search-query']";

@Test
    public void  checkCost() {
        WebDriver driverCh = new ChromeDriver();

        driverCh.get(urlCloud);

        WebElement searchButton = driverCh.findElement(By.xpath(locatorSearch));
        searchButton.sendKeys(stringForSearch);
        searchButton.sendKeys(Keys.ENTER);
      //  searchButton.click();


    }
}
