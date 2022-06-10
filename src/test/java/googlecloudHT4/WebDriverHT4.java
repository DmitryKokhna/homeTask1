package googlecloudHT4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class WebDriverHT4 {

    public String urlCloud="https://cloud.google.com/";
    public String stringForSearch="Google Cloud Platform Calculator";
    public String locatorSearch="//div[@class='devsite-searchbox' ]//input[@class='devsite-search-field devsite-search-query']";

    // переменная для определения, что это результаты поиска

     public String searchTitlePage="//h1[contains(text(), 'Search results for')]";

  public String  locatorAfterSearch ="//a[contains(@href, 'cloud.google.com/products/calculator/')]";
/*
/html/body/section/section/main/devsite-content/article/article/div/devsite-cse/devsite-analytics-scope/div/div/div/div/div/div/div[5]/div[2]/div/div/div[1]/div[3]/div[1]/div[3]/div/div[1]/a
//div[@class='gs-title']//a[@href='https://cloud.google.com/products/calculator/?hl=sv']
//*[contains(.,'Google Cloud Platform')]  проходит, но нет клика
//b[contains(.,'Google Cloud Platform')]  не проходит
//a[@class='gs-title' and @href='https://cloud.google.com/products/calculator/?hl=sv']
//div[@class='gs-title']//a/@href='https://cloud.google.com/products/calculator/?hl=sv']
//b[contains(text(),'Google Cloud Platform')]/preceding::a[@href='https://cloud.google.com/products/calculator/?hl=sv']


 */
@Test
    public void  checkCost() {
        WebDriver driverCh = new ChromeDriver();

        driverCh.get(urlCloud);

        WebElement searchButton = driverCh.findElement(By.xpath(locatorSearch));
        searchButton.sendKeys(stringForSearch);
        searchButton.sendKeys(Keys.ENTER);
      //  searchButton.click();

    new WebDriverWait(driverCh, Duration.ofSeconds(2))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchTitlePage)));


WebElement elementForClick = driverCh.findElement(By.xpath(locatorAfterSearch));

  //  driverCh.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
elementForClick.click();

driverCh.get("https://cloud.google.com/products/calculator/?hl=sv");

  /*   List<WebElement> searchResults= driverCh.findElements(By.xpath(locatorAfterSearch));

   int numberOfResults = searchResults.size();

    if(numberOfResults>0){
        System.out.println("результатов количество " + numberOfResults);

            }
    else {
        System.out.println("нет результатов " + numberOfResults);
*/

    }


    }

