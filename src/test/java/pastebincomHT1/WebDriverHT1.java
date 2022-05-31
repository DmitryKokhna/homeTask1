package pastebincomHT1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHT1 {

/**
переменные
 */
    public static String textForPutting = "Hello from WedDiver. I can Win";
    public static String nameTitle = "helloweb";


    public static void main(String[] args) {

        WebDriver driverCh = new ChromeDriver();
// открываем
        driverCh.get("https://pastebin.com/");
// поиск поля для ввода
        WebElement textField = driverCh.findElement(By.xpath("//*[@id='postform-text' and @name='PostForm[text]']"));
// на вcякий случай очищаем
        textField.clear();
// вводим текст
        textField.sendKeys(textForPutting);

// имем выпадающий список
        WebElement findDropDown = driverCh.findElement(By.id("select2-postform-expiration-container"));
// кликаем на авпадающий список
        findDropDown.click();

// ищем 10 мин. как не черех абсолютный путь хз
        WebElement clickOn10Min = driverCh.findElement(By.xpath("/html/body/span[2]/span/span[2]/ul/li[3]"));
// кликаем на 10 мин
        clickOn10Min.click();

// ищем поле для Имени
        WebElement pasteNameTitle = driverCh.findElement(By.id("postform-name"));
// пишем в поле заданное имя
        pasteNameTitle.sendKeys(nameTitle);

// ищем кнопию Отправить
        WebElement buttonSubmit = driverCh.findElement(By.xpath("//*[@type='submit']"));
// кликаем кнопию отправить
        buttonSubmit.click();

// для красоты
        System.out.println();
        System.out.println("The task has been done");
    }
}
