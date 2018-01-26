package ta.module6.pages.tests;

import ta.module6.pages.pages.YandexCreateMailPage;
import ta.module6.pages.pages.YandexGeneralPage;
import ta.module6.pages.pages.YandexLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YandexMailNew {

    private static final String URL_YANDEX = "https://passport.yandex.by/passport?mode=auth&from=mail&retpath=https%3A%2F%2Fmail.yandex.by&origin=hostroot_by_nol_mobile_enter";
    private static final String DRIVER_LOCATION = "d:\\_WebDriver\\chromedriver.exe" ;
    private WebDriver driver;

    @BeforeClass(description = "Start Browser")
    public void getUrl(){

        System.setProperty("webdriver.chrome.driver", DRIVER_LOCATION);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        // Go to yandex mail
        driver.get(URL_YANDEX);

        // Set timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(description = "Test Yandex mail")
    public void CreateMail() {

        new YandexLoginPage(driver).logIn();

        YandexGeneralPage generPage = new YandexGeneralPage(driver);
        generPage.createMail();

        new YandexCreateMailPage(driver).createNewMail();

        Assert.assertTrue(generPage.isSavedMailDisp());
        Assert.assertTrue(generPage.isContentMails());
        Assert.assertTrue(generPage.isContentMails2());

        generPage.sendMail();

        Assert.assertTrue(generPage.isSentMail());
        Assert.assertTrue(generPage.checkSendMail());

        }

    @AfterClass(description = "Close Browser")
    public  void quitDriver() {

        // Logout from yandex mail.
        driver.quit();

    }
}
