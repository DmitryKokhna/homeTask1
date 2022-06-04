package HTtry.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class OpenPage {
    public WebDriver driverCh;
    public String url = "https://pastebin.com/"; // URL куда ходим
    public String textForFill =
            "git config --global user.name  \"New Sheriff in Town\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                    "git push origin master --force";                                   // вводимый текст в New Past
    public  String nameTitle = "how to gain dominance among developer"; // вводимый текст в Title/Name
    public String syntaxHighlighting = "//li[contains(text(),'Bash')]"; // переменная для типа синтаксиса
    public String pasteExpiration = "//li[contains(text(),'10 Minutes')]";  // переменная для срока

    public OpenPage(WebDriver driverCh) {
        this.driverCh = driverCh;
        PageFactory.initElements(driverCh, this);
    }


    public OpenPage openPage(){
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
        return this;
    }



   public ResultPage filledMainPage() {
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

       return new ResultPage(driverCh, textForFill, nameTitle, syntaxHighlighting, pasteExpiration );
   }

}
