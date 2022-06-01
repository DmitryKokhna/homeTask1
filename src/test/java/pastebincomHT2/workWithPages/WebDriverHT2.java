package pastebincomHT2.workWithPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
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
    public static String hexcolorInDevtools="#c20cb9"; // цвет для сравнения
    public static int numberOfchecking=3;
    public static int checkTitle=0;
    public static int checkColor=0;
    public static int checkCode=0;

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
       System.out.println();


        // ждем загрузки элемента
               new WebDriverWait(driverCh, Duration.ofSeconds(2)).until(ExpectedConditions.presenceOfElementLocated(By.className("bash")));

        /**
         *  тест 1
         */

// расположение элемента NameTitle
        WebElement elementNameTitle=driverCh.findElement(By.xpath("//div[@class=\"info-top\"]//*[text()=\"how to gain dominance among developer\"]"));

        // достаем из элемента текст
        String textFromElementNameTitle=elementNameTitle.getText();

        // проверяем чтобы пройти все 3 проверки. Это первая.
  if(textFromElementNameTitle.equals(nameTitle)) {
      checkTitle=1;
      numberOfchecking=numberOfchecking-1;
         }


          Assert.assertEquals(textFromElementNameTitle,nameTitle);


        /**
         *  тест 2
         */

        // получаем элемент с частью текста
WebElement colorText=driverCh.findElement(By.xpath("//ol[@class=\"bash\"]//*[contains(text(),\"git config\")]"));
// часть строки по которой определяем , что текст окрашен
String coloredString= colorText.getText();

        // ложим в строку RGB текст
String stringWithRGB= colorText.getCssValue("color");

// конвертируем для сравнения с DevTools
        String stringHexColor = Color.fromString(stringWithRGB).asHex();

        // проверяем чтобы пройти все 3 проверки. Это вторая.
        if (stringHexColor.equals(hexcolorInDevtools)) {
            checkColor=1;
            numberOfchecking=numberOfchecking-1;
            }
               // Проверяем на цвет
        Assert.assertEquals(stringHexColor, hexcolorInDevtools);

        // Сумма проверок
System.out.println("Цвет соответствует " + "задан -"+ hexcolorInDevtools+ "; отображен - "+ stringHexColor );
System.out.println("Проверок пройдено - "+ (checkTitle+checkColor));
System.out.println("Проверок осталось - " + numberOfchecking);











    }
}
