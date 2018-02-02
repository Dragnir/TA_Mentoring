package ta.module9patterns.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ta.module9patterns.bobjects.UserAccount;
import ta.module9patterns.core.EnumDrivers;
import ta.module9patterns.core.Singleton;
import ta.module9patterns.core.WebDriverFactory;
import ta.module9patterns.pages.NewMailPage;
import ta.module9patterns.pages.YandexGeneralPage;
import ta.module9patterns.pages.YandexLoginPage;
import ta.module9patterns.utils.ValidationUtil;

import java.util.concurrent.TimeUnit;

public class YandexMailNew {

    private static final String URL_YANDEX = "https://passport.yandex.by/passport?mode=auth&from=mail&retpath=https%3A%2F%2Fmail.yandex.by&origin=hostroot_by_nol_mobile_enter";
    private WebDriver driver;
    private UserAccount account;
    private String login = "vadim.kuryan.vka";
    private String password = "Vka_6463296";

    @BeforeClass(description = "Start Browser")
    public void getUrl(){

        driver = WebDriverFactory.getDriverIns(EnumDrivers.CHROME);

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

        valUtil.logAssert(generPage.isSavedMailDisp(), "Mail was saved");
        valUtil.logAssert(generPage.isContentMails(), "Content present");

        generPage.sendMail();

        valUtil.logAssert(generPage.isSentMail(), "Mail was send");
        valUtil.logAssert(generPage.checkSendMail(), "Draft folder is empty");

        }

    @AfterClass(description = "Close Browser")
    public  void quitDriver() {

        // Logout from yandex mail.
        driver.quit();

    }
}
