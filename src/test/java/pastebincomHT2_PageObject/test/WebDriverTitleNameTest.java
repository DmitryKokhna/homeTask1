package pastebincomHT2_PageObject.test;

import pastebincomHT2_PageObject.page.OpenPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WebDriverTitleNameTest {
    public String url = "https://pastebin.com/"; // URL куда ходим
    public String nameTitle = "how to gain dominance among developer"; // вводимый текст в Title/Name
    private WebDriver driverCh;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {

        driverCh = new ChromeDriver();
    }

    @Test(description = "fill in Title/Name", priority = 1)
    public void checkTitleNameFieldTest() {

        // открываем
        driverCh.get(url);

        String textFromElementNameTitle = new OpenPage(driverCh)
                .openPage()
                .filledMainPage()
                .checkTitleName();

        Assert.assertEquals(textFromElementNameTitle, nameTitle, "The Title/Name field is incorrect");
    }

    @AfterMethod(alwaysRun = true, description = "Quit the browser and setUp the object to null ")
    public void browserEnd() {
        //  driverCh.quit();
        driverCh = null;
        System.out.println("\t - = The checking Title/Name has been done = -  TRY");
    }
}