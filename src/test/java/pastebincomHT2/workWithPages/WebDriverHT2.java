package pastebincomHT2.workWithPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebDriverHT2 {

    /**
     * переменные
     */
    public static String textForPutting =
            "git config --global user.name  \"New Sheriff in Town\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    public static String nameTitle = "how to gain dominance among developer";

    public static int numberOfchecking=3;
    public static int checkTitle;
    public static int checkSyntax;
    public static int checkCode;

    @Test (description = "Check Title, syntax highlighted, text is correct")
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
        // выбираем в Syntax Highlighting параметр "Bash"
        WebElement clickBash = driverCh.findElement(By.xpath("/html/body/span[2]/span/span[2]/ul/li[2]/ul/li[1]"));
// кликаем на Bash мин
        clickBash.click();


// ищем выпадающий список для Paste Expiration
        WebElement findDropDown = driverCh.findElement(By.id("select2-postform-expiration-container"));

// кликаем на выпадающий список
     findDropDown.click();

// ищем "10 мин" как не через абсолютный путь хз
       WebElement clickOn10Min = driverCh.findElement(By.xpath("/html/body/span[2]/span/span[2]/ul/li[3]"));

// кликаем на "10 мин"
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
      //  System.out.println();
        System.out.println("Checking1");

        // ждем загрузки элемента
               new WebDriverWait(driverCh, Duration.ofSeconds(2)).until(ExpectedConditions.presenceOfElementLocated(By.className("bash")));

// расположение элемента NameTitle
        WebElement elementNameTitle=driverCh.findElement(By.xpath("//div[@class=\"info-top\"]//*[text()=\"how to gain dominance among developer\"]"));

        // достаем из элемента текст
        String textFromElementNameTitle=elementNameTitle.getText();

  if(textFromElementNameTitle.equals(nameTitle)) {
      checkTitle=1;
      numberOfchecking=numberOfchecking-1;
         }
  else {
      checkTitle=0;
  }

          Assert.assertEquals(textFromElementNameTitle,nameTitle);


        System.out.println("Цвет проверка начало ");
WebElement colorText=driverCh.findElement(By.xpath("//ol[@class=\"bash\"]//*[contains(text(),\"git config\")]"));
String color= colorText.getCssValue("c");
System.out.println("Цвет "+color);








    }
}
