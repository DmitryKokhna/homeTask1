package Reserve;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class WebDriverCheckTitleNameFieldTest {

    public static String url="https://pastebin.com/";  // URL сайта
    public static String nameTitle = "how to gain dominance among developer"; // вводимый текст в Title/Name
    public static String textForFill =
            "git config --global user.name  \"New Sheriff in Town\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                    "git push origin master --force";  // вводимый текст в  New Past


    private WebDriver driverCh;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp(){

        driverCh= new ChromeDriver();
    }

    // открываем
    @Test (description = "test fill in Title/Name")
    public void checkTitleNameFieldTest () {


        // открываем
        driverCh.get(url);


        /**
         *  если без VPN,то код для кнопки AGREE закоментить
         */

        // обход ограничения посылок для VPN
        // даем время на появление появления PopUp окна
        driverCh.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

// получаем кнопку AGREE
        WebElement  agreeButton=driverCh.findElement(By.xpath("//*[@class=\"sc-ifAKCX ljEJIv\"]"));
        agreeButton.click();


        // поиск поля для ввода Текста
        WebElement textField = driverCh.findElement(By.xpath("//*[@id='postform-text' and @name='PostForm[text]']"));
// на всякий случай очищаем
        textField.clear();
// вводим текст
        textField.sendKeys(textForFill);


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



// ждем загрузки элемента
        new WebDriverWait(driverCh, Duration.ofSeconds(2)).until(ExpectedConditions.presenceOfElementLocated(By.className("bash")));


// расположение элемента NameTitle
        WebElement elementNameTitle = driverCh.findElement(By.xpath("//div[@class=\"info-top\"]//*[text()=\"how to gain dominance among developer\"]"));

// достаем из элемента текст
        String textFromElementNameTitle = elementNameTitle.getText();


// ассерт
        Assert.assertEquals(textFromElementNameTitle, nameTitle, "The Title/Name field is incorrect");


    }

    @AfterMethod(alwaysRun = true, description ="Quit the browser and setUp the object to null ")
    public void browserEnd(){
      //  driverCh.quit();
        driverCh=null;
        System.out.println("\t - = The checking Title/Name has been done = -");
    }

}