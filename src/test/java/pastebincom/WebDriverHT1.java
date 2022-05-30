package pastebincom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHT1 {
    public static void main(String[] args) {

        WebDriver driverCh = new ChromeDriver();
//"//a[contains(text(),'paste')]")  ("postform-text") & By.name("PostForm[text])");

        //  searchPlusPasteButton.click();
        driverCh.get("https://pastebin.com/");
        WebElement textField = driverCh.findElement(By.xpath("//*[@id='postform-text' and @name='PostForm[text]']"));
        textField.clear();

        textField.sendKeys("I can Win");

              WebElement findDropDown = driverCh.findElement(By.id("select2-postform-expiration-container"));
              findDropDown.click();

WebElement clickOn10Min= driverCh.findElement(By.xpath("/html/body/span[2]/span/span[2]/ul/li[3]"));
clickOn10Min.click();

    }
}
