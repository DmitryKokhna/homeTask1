package HTtry.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ResultPage {

    public String textForFill;              // вводимый текст в New Past
    public String syntaxHighlighting; // переменная для  типа синтаксиса
    public String pasteExpiration;  // переменная для срока
    public String nameTitle; // вводимый текст в Title/Name
    private WebDriver driverCh;

    public ResultPage(WebDriver driverCh, String textForFill, String nameTitle, String syntaxHighlighting, String pasteExpiration) {
        this.driverCh = driverCh;
        this.textForFill = textForFill;
        this.nameTitle = nameTitle;
        this.syntaxHighlighting = syntaxHighlighting;
        this.pasteExpiration = pasteExpiration;
        PageFactory.initElements(driverCh, this);
// ждем загрузки элемента
        driverCh.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new WebDriverWait(driverCh, Duration.ofSeconds(2)).until(ExpectedConditions.presenceOfElementLocated(By.className("bash")));
    }

    public String checkTitleName() {

// расположение элемента NameTitle
        WebElement elementNameTitle = driverCh.findElement(By.xpath("//div[@class=\"info-top\"]//*[text()=\"how to gain dominance among developer\"]"));

// достаем из элемента текст
        return elementNameTitle.getText();
    }

}
