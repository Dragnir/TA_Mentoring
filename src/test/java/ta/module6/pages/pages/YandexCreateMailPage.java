package ta.module6.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class YandexCreateMailPage extends YandexAbstractPage {

    private static final String TEST_THEME = "Test mail";
    private static final String NEW_MAIL = "dragnir@tut.by";
    private static final String SEND_TO = "to";
    private static final String SUBJECT = "subj";

    @FindBy(xpath  = "//*[text()='Черновики']")
    private WebElement draft;

    @FindBy(xpath  = "//*[text()='Сохранить и перейти']")
    private WebElement save_go;

    public YandexCreateMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void createNewMail() {

        // Set mail address
        WebElement mailAddress = driver.findElement(By.name(SEND_TO));
        mailAddress.sendKeys(NEW_MAIL);

        // Set mail theme
        WebElement themeMail = driver.findElement(By.name(SUBJECT));
        themeMail.sendKeys(TEST_THEME);

        // Save as a draft
        draft.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        save_go.click();

    }
}
