package pastebincomHT2.workWithPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FillSyntaxHighlighting {

    // ищем выпадающий список для Syntax Highlighting
    WebElement findDropDownSyntaxHighlighting = driverCh.findElement(By.id("select2-postform-format-container"));
    // кликаем на выпадающий список Syntax Highlighting
        findDropDownSyntaxHighlighting.click();
    // выбираем в Syntax Highlighting параметр "Bash"
    WebElement clickBash = driverCh.findElement(By.xpath("/html/body/span[2]/span/span[2]/ul/li[2]/ul/li[1]"));
// кликаем на Bash мин
        clickBash.click();
}
