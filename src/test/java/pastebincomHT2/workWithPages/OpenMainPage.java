package pastebincomHT2.workWithPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class OpenMainPage {

    public WebDriver driverCh;
    public static String url = "https://pastebin.com/";  // URL сайта


    public OpenMainPage(WebDriver driverCh) {
        this.driverCh = driverCh;
    }

    public OpenMainPage openPageMethod() {
        driverCh.get(url);
        driverCh.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        /*
         *  если без VPN,то код для кнопки AGREE закоментить
         */

        // обход ограничения посылок для VPN
        // даем время на появление появления PopUp окна

        // получаем кнопку AGREE

        WebElement agreeButton = driverCh.findElement(By.xpath("//*[@class=\"sc-ifAKCX ljEJIv\"]"));
        agreeButton.click();

        return this;
    }
}
