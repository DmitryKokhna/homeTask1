package Reserve;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WebDriverCheckTitleNameFieldTest {
    public static String url = "https://pastebin.com/"; // URL куда ходим
    public static String textForFill =
            "git config --global user.name  \"New Sheriff in Town\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                    "git push origin master --force";                                   // вводимый текст в New Past
    public static String syntaxHighlighting = "//li[contains(text(),'Bash')]"; // переменная для  типа синтаксиса
    public static String pasteExpiration = "//li[contains(text(),'10 Minutes')]";  // переменная для срока
    public static String nameTitle = "how to gain dominance among developer"; // вводимый текст в Title/Name

    private WebDriver driverCh;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {

        driverCh = new ChromeDriver();
    }

    @Test(description = "testOneByOne fill in Title/Name")
    public void checkTitleNameFieldTest() {

        // открываем
        driverCh.get(url);

        // даем время на появление появления PopUp окна
        driverCh.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        /**
         *  если без VPN,то код для кнопки AGREE закоментить
         */
// получаем кнопку AGREE
        WebElement agreeButton = driverCh.findElement(By.xpath("//*[@class=\"sc-ifAKCX ljEJIv\"]"));
        agreeButton.click();

//Поле "New Past"
// поиск поля для ввода
        WebElement textField = driverCh.findElement(By.xpath("//*[@id='postform-text' and @name='PostForm[text]']"));
// на всякий случай очищаем
        textField.clear();
// вводим текст
        textField.sendKeys(textForFill);


// Поле "Syntax Highlighting"
// ищем выпадающий список
        WebElement findDropDownSyntaxHighlighting = driverCh.findElement(By.id("select2-postform-format-container"));
// кликаем на выпадающий список
        findDropDownSyntaxHighlighting.click();

// ищем параметр "Bash"
        WebElement clickBash = driverCh.findElement(By.xpath(syntaxHighlighting));
// кликаем на "Bash"
        clickBash.click();


// Поле "Paste Expiration"
// ищем выпадающий список
        WebElement findDropDown = driverCh.findElement(By.id("select2-postform-expiration-container"));
// кликаем на выпадающий список
        findDropDown.click();
// ищем параметр "10 минут"
        WebElement clickOn10Min = driverCh.findElement(By.xpath(pasteExpiration));
// кликаем на "10 мин"
        clickOn10Min.click();

// Поле "Paste Name / Title"
// ищем поле
        WebElement pasteNameTitle = driverCh.findElement(By.id("postform-name"));
// пишем в поле параметр
        pasteNameTitle.sendKeys(nameTitle);

// Кнопка "Create New Past"
// ищем кнопию
        WebElement buttonSubmit = driverCh.findElement(By.xpath("//*[@type='submit']"));
// кликаем кнопию
        buttonSubmit.click();


// Страница после отправки
// ждем загрузки элемента
        driverCh.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new WebDriverWait(driverCh, Duration.ofSeconds(2)).until(ExpectedConditions.presenceOfElementLocated(By.className("bash")));



// ждем загрузки элемента
        new WebDriverWait(driverCh, Duration.ofSeconds(2)).until(ExpectedConditions.presenceOfElementLocated(By.className("bash")));


// расположение элемента NameTitle
        WebElement elementNameTitle = driverCh.findElement(By.xpath("//div[@class=\"info-top\"]//*[text()=\"how to gain dominance among developer\"]"));

// достаем из элемента текст
        String textFromElementNameTitle = elementNameTitle.getText();


// ассерт
        Assert.assertEquals(textFromElementNameTitle, nameTitle, "The Title/Name field is incorrect");
    }

    @AfterMethod(alwaysRun = true, description = "Quit the browser and setUp the object to null ")
    public void browserEnd() {
        //  driverCh.quit();
        driverCh = null;
        System.out.println("\t - = The checking Title/Name has been done = -");
    }
}