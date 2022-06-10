package googlecloudHT4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLSelectElement;

import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

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
// нажимаем на найденный локатор калькулятора
        elementForClick.click();



//  попытка1 обойти "НЕПОИСК" элементов
   /* String currentTab = driverCh.getWindowHandle();
    Set<String> tabs = driverCh.getWindowHandles();

    for (String tab : tabs) {
        if (!currentTab.equals(tab)) {
            driverCh.switchTo().window(tab);
        }
    }
*/

//  попытка2 обойти "НЕПОИСК" элементов
        driverCh.switchTo().defaultContent();

// приостановка процесса
        Thread.sleep(5000);
// поиск фрейма с нужным элементом
        driverCh.switchTo().frame(driverCh.findElement(By.xpath("//input[@id='input_1629']")));
//
// приостановка процесса
        Thread.sleep(5000);
        // попытка найти поле для ввода
        WebElement instance = driverCh.findElement(By.xpath("//input[@name='quantity' and @id='input_1629']"));
// приостановка процесса
        Thread.sleep(5000);
//ввод в поле кол-ва
        instance.sendKeys("2");


    }
}




