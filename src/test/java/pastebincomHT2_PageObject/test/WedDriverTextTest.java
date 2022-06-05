package pastebincomHT2_PageObject.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pastebincomHT2_PageObject.page.OpenPage;

public class WedDriverTextTest {

    public String url = "https://pastebin.com/"; // URL куда ходим
    public static String textForFill =
            "git config --global user.name  \"New Sheriff in Town\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                    "git push origin master --force";                                   // вводимый текст в New Past
    private WebDriver driverCh;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {

        driverCh = new ChromeDriver();
    }

    @Test(description = "There is the text", priority = 3)
    public void checkTextTest() {

        driverCh.get(url);

        String text = new OpenPage(driverCh)
                .openPage()
                .filledMainPage()
                .checkTest();

        Assert.assertEquals(text, textForFill);
    }

    @AfterMethod(alwaysRun = true, description = "Quit the browser and setUp the object to null ")
    public void browserEnd() {
        //  driverCh.quit();
        driverCh = null;
        System.out.println("\t - = The checking Title/Name has been done = - 3");
    }


}
