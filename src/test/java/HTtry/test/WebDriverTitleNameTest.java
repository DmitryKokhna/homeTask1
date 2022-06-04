package HTtry.test;

import HTtry.page.OpenPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class WebDriverTitleNameTest {
    public static String url = "https://pastebin.com/"; // URL куда ходим
    public static String textForFill =
            "git config --global user.name  \"New Sheriff in Town\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                    "git push origin master --force";                                   // вводимый текст в New Past
    public static String syntaxHighlighting = "//li[contains(text(),'Bash')]"; // переменная для типа синтаксиса
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

  String textFromElementNameTitle=new OpenPage(driverCh)
          .openPage()
                  .filledMainPage()
                          .checkTitleName();
  System.out.println(" СТРОКА" + textFromElementNameTitle);



        Assert.assertEquals(textFromElementNameTitle, nameTitle, "The Title/Name field is incorrect");
    }

    @AfterMethod(alwaysRun = true, description = "Quit the browser and setUp the object to null ")
    public void browserEnd() {
        //  driverCh.quit();
        driverCh = null;
        System.out.println("\t - = The checking Title/Name has been done = -");
    }
}