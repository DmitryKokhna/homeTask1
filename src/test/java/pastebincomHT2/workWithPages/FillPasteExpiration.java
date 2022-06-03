package pastebincomHT2.workWithPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FillPasteExpiration {
    // ищем выпадающий список для Paste Expiration
    public WebDriver driverCh;



    public FillPasteExpiration fillPasteExpiration (){



    }
    WebElement findDropDown = driverCh.findElement(By.id("select2-postform-expiration-container"));
// кликаем на выпадающий список
        findDropDown.click();
    // ищем "10 мин" как не через абсолютный путь хз
    WebElement clickOn10Min = driverCh.findElement(By.xpath("/html/body/span[2]/span/span[2]/ul/li[3]"));
// кликаем на "10 мин"
        clickOn10Min.click();
}
