package ta.module7.actions.tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ta.module7.actions.pages.CreateMailPage;
import ta.module7.actions.pages.YandexGeneralPage;
import ta.module7.actions.pages.YandexLoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GridYandexMailNew {

    private static final String URL_YANDEX = "https://passport.yandex.by/passport?mode=auth&from=mail&retpath=https%3A%2F%2Fmail.yandex.by&origin=hostroot_by_nol_mobile_enter";
    private WebDriver driver;

    @BeforeClass(description = "Start Browser")
    public void getUrl(){

        // init Webdriver
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.WINDOWS);
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        // Go to yandex mail
        driver.get(URL_YANDEX);

        // Set timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(description = "Test Yandex mail")
    public void CreateMail() {

        YandexLoginPage loginPage = new YandexLoginPage(driver);
        loginPage.setLogin();
        loginPage.setPassword();
        loginPage.logIn();

        YandexGeneralPage generPage = new YandexGeneralPage(driver);
        generPage.createMail();

        CreateMailPage createMailPage = new CreateMailPage(driver);
        createMailPage.setMailAdress();
        createMailPage.setCopyAddress();
        createMailPage.setMailTheme();
        createMailPage.saveAsDraft();

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
