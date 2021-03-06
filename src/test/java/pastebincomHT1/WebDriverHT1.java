package pastebincomHT1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;


public class WebDriverHT1 {

/**
переменные
 */
   public static String textForPutting = "Hello from WedDiver. I can Win";
    public static String nameTitle = "helloweb";

    public static String url="https://pastebin.com/";


    public static void main(String[] args) throws IOException {

        WebDriver driverCh = new ChromeDriver();
// открываем
        driverCh.get(url);
// поиск поля для ввода
        WebElement textField = driverCh.findElement(By.xpath("//*[@id='postform-text' and @name='PostForm[text]']"));
// на всякий случай очищаем
        textField.clear();
// вводим текст
      textField.sendKeys(textForPutting);

// ищем выпадающий список
        WebElement findDropDown = driverCh.findElement(By.id("select2-postform-expiration-container"));
// кликаем на выпадающий список
        findDropDown.click();

// ищем 10 мин.
        WebElement clickOn10Min = driverCh.findElement(By.xpath("//li[contains(text(),'10 Minutes')]"));
// кликаем на "10 мин"
        clickOn10Min.click();

// ищем поле для Имени
        WebElement pasteNameTitle = driverCh.findElement(By.id("postform-name"));
// пишем в поле заданное имя
        pasteNameTitle.sendKeys(nameTitle);

// ищем кнопию "Отправить"
        WebElement buttonSubmit = driverCh.findElement(By.xpath("//*[@type='submit']"));
// кликаем кнопию отправить
        buttonSubmit.click();

// для красоты
        System.out.println("\nThe task has been done");
    }
}
