package pastebincomHT2_PageObject.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pastebincomHT2_PageObject.page.OpenPage;

public class WebDriverColoredTextTest {

    public String url = "https://pastebin.com/"; // URL куда ходим
    public static String hexColorInDevtools = "#c20cb9"; // цвет для сравнения в DevTools
    private WebDriver driverCh;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {

        driverCh = new ChromeDriver();
    }

    @Test(description = "the text is colored", priority = 2)
    public void checkColoredTextTest() {

        driverCh.get(url);

        String stringHexColor = new OpenPage(driverCh)
                .openPage()
                .filledMainPage()
                .checkColoredText();

        Assert.assertEquals(stringHexColor, hexColorInDevtools);
    }

    @AfterMethod(alwaysRun = true, description = "Quit the browser and setUp the object to null ")
    public void browserEnd() {
        //  driverCh.quit();
        driverCh = null;
        System.out.println("\t - = The checking Title/Name has been done = - 2");
    }


}
