package Reserve;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WebDriverCheckTitleNameFieldReserve {

    private WebDriver driverCh;
    @BeforeMethod(alwaysRun = true)
    public void browserSetUp(){
        driverCh= new ChromeDriver();
    }

    // открываем
    @Test (description = "test fill in Title/Name")
    public void checkTitleNameFieldTest () {



// ассерт
        Assert.assertEquals(textFromElementNameTitle, nameTitle, "The Title/Name field is incorrect");


    }

    @AfterMethod(alwaysRun = true, description ="Quit the browser and setUp the object to null ")
    public void browserEnd(){
        driverCh.quit();
        driverCh=null;
        System.out.println("\t - = The checking Title/Name has been done = -");
    }

}
