package ta.module8frameworks.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ta.module8frameworks.bobjects.NewMail;
import ta.module8frameworks.bobjects.UserAccount;
import ta.module8frameworks.pages.NewMailPage;
import ta.module8frameworks.pages.YandexGeneralPage;
import ta.module8frameworks.pages.YandexLoginPage;
import ta.module8frameworks.utils.ValidationUtil;

import java.util.concurrent.TimeUnit;

public class YandexMailNew {

    private static final String URL_YANDEX = "https://passport.yandex.by/passport?mode=auth&from=mail&retpath=https%3A%2F%2Fmail.yandex.by&origin=hostroot_by_nol_mobile_enter";
    private static final String DRIVER_LOCATION = "d:\\_WebDriver\\chromedriver.exe" ;
    private WebDriver driver;
    private UserAccount account;
    private String login = "vadim.kuryan.vka";
    private String password = "Vka_6463296";

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

        account = new UserAccount();
        account.setLogin(login);
        account.setPassword(password);

        YandexLoginPage loginPage = new YandexLoginPage(driver);
        ValidationUtil valUtil = new ValidationUtil();

        loginPage.loginUser(account);

        YandexGeneralPage generPage = new YandexGeneralPage(driver);
        generPage.createMail();

        NewMailPage newMail = new NewMailPage(driver);
        newMail.setMailAdress();
        newMail.setMailAdress2();
        newMail.setMailTheme();
        newMail.saveAsDraft();

        valUtil.logAssert(generPage.isSavedMailDisp());
        valUtil.logAssert(generPage.isContentMails());

        generPage.sendMail();

        valUtil.logAssert(generPage.isSentMail());
        valUtil.logAssert(generPage.checkSendMail());

        }

    @AfterClass(description = "Close Browser")
    public  void quitDriver() {

        // Logout from yandex mail.
        driver.quit();

    }
}
