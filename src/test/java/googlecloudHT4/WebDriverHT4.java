package googlecloudHT4;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverHT4 {

    public String urlCloud = "https://cloud.google.com/";
    int timeForWait = 5;
    public String stringForSearch = "Google Cloud Platform Calculator";
    public String locatorSearch = "//div[@class='devsite-searchbox' ]//input[@class='devsite-search-field devsite-search-query']";

    // переменная для определения, что это результаты поиска

    public String searchTitlePage = "//h1[contains(text(), 'Search results for')]";

    public String locatorAfterSearch = "//div[@class='gs-title']//a[contains(@href, 'cloud.google.com/products/calculator/')]";


    @Test(description = "Cloud")
    public void checkCost() throws InterruptedException {
        WebDriver driverCh = new ChromeDriver();
// открываем страницу
        driverCh.get(urlCloud);
//ищем поле поиска
        WebElement searchButton = driverCh.findElement(By.xpath(locatorSearch));
        // вводим искомый запрос
        searchButton.sendKeys(stringForSearch);
        // подтверждаем
        searchButton.sendKeys(Keys.ENTER);
        //  searchButton.click();

        // ждем отображения элемента как для страницы поиска
        new WebDriverWait(driverCh, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchTitlePage)));

// делам остановку обработки
        driverCh.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeForWait));
// ищем локатор страницы калькулятора
        WebElement elementForClick = driverCh.findElement(By.xpath(locatorAfterSearch));
        driverCh.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
// нажимаем на найденный локатор калькулятора
        elementForClick.click();


//  попытка1 обойти "НЕПОИСК" элементов


// приостановка процесса
        Thread.sleep(5000);

// поиск фрейма с нужным элементом
   //     driverCh.switchTo().frame(1);
     //   System.out.println(" фрейм1 найден");
        driverCh.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

WebElement but = driverCh.findElement(By.xpath("//a[@href='https://cloud.google.com/contact?hl=sv']"));
but.click();

      // new WebDriverWait(driverCh, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#input_85")));
        // попытка найти поле для ввода

        /*
        FluentWait wait = new FluentWait(driverCh);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.alertIsPresent());
*/


     /*   Wait<WebDriver> wait = new FluentWait<WebDriver>(driverCh)
                .withTimeout(Duration.ofSeconds(10L))
                .pollingEvery(Duration.ofSeconds(1L))
                .ignoring(NoSuchElementException.class);
*/


    /*    WebElement instance = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driverCh.findElement(By.id("input_85"));
            }
        });
*/
//   WebElement instance = driverCh.findElement(By.cssSelector("#input_85"));
//   /html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[1]/div[1]/md-input-container/input


   //     "//*[@id='input_85']"
//ввод в поле кол-ва
   //     instance.sendKeys("2");
   //    driverCh.switchTo().defaultContent();


    }
}




