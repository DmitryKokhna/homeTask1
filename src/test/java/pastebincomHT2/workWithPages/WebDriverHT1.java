package pastebincomHT2.workWithPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHT1 {

    /**
     * переменные
     */
    public static String textForPutting =
            "git config --global user.name  \"New Sheriff in Town\n" +
             "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\n" +
              "git push origin master --force";

    public static String nameTitle = "how to gain dominance among developer";


    public static void main(String[] args) {

        WebDriver driverCh = new ChromeDriver();
// открываем
        driverCh.get("https://pastebin.com/");
// поиск поля для ввода
        WebElement textField = driverCh.findElement(By.xpath("//*[@id='postform-text' and @name='PostForm[text]']"));
// на влякий случай очищаем
        textField.clear();
// вводим текст
        textField.sendKeys(textForPutting);

        // ищем выпадающий список для Syntax Highlighting
        WebElement findDropDownSyntaxHighlighting = driverCh.findElement(By.id("select2-postform-format-container"));
        // кликаем на выпадающий список Syntax Highlighting
        findDropDownSyntaxHighlighting.click();
        // выбираем в Syntax Highlighting параметр Bash
        WebElement clickBash = driverCh.findElement(By.xpath("/html/body/span[2]/span/span[2]/ul/li[2]/ul/li[1]"));
// кликаем на Bash мин
        clickBash.click();


// ищем выпадающий список для Paste Expiration
        WebElement findDropDown = driverCh.findElement(By.id("select2-postform-expiration-container"));
// кликаем на выпадающий список
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
      //  buttonSubmit.click();

// для красоты
        System.out.println();
        System.out.println("The task has been done");
    }
}
