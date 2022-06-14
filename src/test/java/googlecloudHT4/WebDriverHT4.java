package googlecloudHT4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

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
        driverCh.switchTo().frame(1);
        System.out.println(" фрейм1 найден");
        driverCh.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 String w= driverCh.getCurrentUrl();
        System.out.println(" Страница " + w);
 driverCh.navigate().refresh();
        // попытка найти поле для ввода
         WebElement instance = driverCh.findElement(By.cssSelector("#input_85"));
//   /html/body/md-content/md-card/div/md-card-content[1]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[1]/div[1]/md-input-container/input


   //     "//*[@id='input_85']"
//ввод в поле кол-ва
        instance.sendKeys("2");
       driverCh.switchTo().defaultContent();


    }
}




