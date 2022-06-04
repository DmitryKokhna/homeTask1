package pastebincomHT2.GroupOfTests;


import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;


public class WebDriverHT2 {

    /**
     * переменные
     */

    public WebDriver driverCh;
    public static String url = "https://pastebin.com/"; // URL куда ходим
    public static String textForFill =
            "git config --global user.name  \"New Sheriff in Town\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                    "git push origin master --force"; // вводимый текст в New Past

    public static String syntaxHighlighting = "//li[contains(text(),'Bash')]"; // переменная для  типа синтаксиса
    public static String pasteExpiration = "//li[contains(text(),'10 Minutes')]";  // переменная для срока
    public static String nameTitle = "how to gain dominance among developer"; // вводимый текст в Title/Name
    public static String hexColorInDevtools = "#c20cb9"; // цвет для сравнения в DevTools
    public static final int numberOfChecking = 3; // количество проверок всего
    public static int numberOfCheckingRest = 3; // количество ставшихся проверок. не очень красиво
    public static int checkTitle = 0; // проверка на Title/Name
    public static int checkColor = 0; // проверка на цвет
    public static int checkText = 0; // проверка на текст (код)

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {

        driverCh = new ChromeDriver();
    }


    @Test(description = "Check Title, syntax highlighted, text is correct")
    public void checkAllReq() throws InterruptedException {

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

        /**
         *  тест 1
         */

//Поле "Paste Name / Title"
 // расположение элемента NameTitle
        WebElement elementNameTitle = driverCh.findElement(By.xpath("//div[@class=\"info-top\"]//*[text()=\"how to gain dominance among developer\"]"));
// достаем из элемента текст
        String textFromElementNameTitle = elementNameTitle.getText();

// проверяем чтобы пройти все 3 проверки. Это первая.
        if (textFromElementNameTitle.equals(nameTitle)) {
            checkTitle = 1;
            numberOfCheckingRest = numberOfCheckingRest - 1;
        }

// Основной ассерт 1
        Assert.assertEquals(textFromElementNameTitle, nameTitle);
        System.out.println("Первый прошел");


        /**
         *  тест 2
         */

//Проверяем, что текст цветной (на части текста)
// получаем элемент с частью текста
        WebElement colorText = driverCh.findElement(By.xpath("//ol[@class=\"bash\"]//*[contains(text(),\"git config\")]"));
// часть строки по которой определяем, что текст окрашен
        String coloredString = colorText.getText();

// ложим в строку RGB текст
        String stringWithRGB = colorText.getCssValue("color");
// конвертируем для сравнения с DevTools
        String stringHexColor = Color.fromString(stringWithRGB).asHex();

// Проверяем, чтобы пройти все 3 проверки. Это вторая.
        if (stringHexColor.equals(hexColorInDevtools)) {
            checkColor = 1;
            numberOfCheckingRest = numberOfCheckingRest - 1;
        }

// Основной ассерт 2
        Assert.assertEquals(stringHexColor, hexColorInDevtools);
        System.out.println("Второй прошел");


        /**
         *  тест 3
         */
// Проверяем введенный текст
// получаем элемент в котором текст
        String textFieldAfterSent = driverCh.findElement(By.xpath("//ol[@class=\"bash\"]")).getText();

// Проверяем, чтобы пройти все 3 проверки. Это третья.
        if (textFieldAfterSent.equals(textForFill)) {
            checkText = 1;
            numberOfCheckingRest = numberOfCheckingRest - 1;
        }
// Основной ассерт 3
        Assert.assertEquals(textFieldAfterSent, textForFill);
        System.out.println("Третий прошел");


// Сумма проверок для себя
        System.out.println("Проверок всего - " + numberOfChecking);
        System.out.println("Проверок пройдено всего - " + (checkTitle + checkColor + checkText));
        System.out.println("Проверок осталось - " + numberOfCheckingRest);

    }

    @AfterMethod(alwaysRun = true, description = "Quit the browser and setUp the object to null ")
    public void browserEnd() {
        //  driverCh.quit();
        driverCh = null;
    }
}
