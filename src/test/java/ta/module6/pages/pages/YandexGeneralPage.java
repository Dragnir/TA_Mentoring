package ta.module6.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class YandexGeneralPage {

    private static final String NEW_MAIL = "dragnir@tut.by";
    private static final String DRAFT_FOLDER = "//*[text()='Test mail']";
    private static final String MAIL_CHECK = "//*[text()='dragnir@tut.by']";
    private static final String SEND_BUT = "//*[text()='Отправить']";
    private static final String SENT_MAIL = "//*[text()='Отправленные']";
    private static final String DRAFT = "//*[text()='Черновики']";
    private static final String DRAFT_EMPTY = "//*[text()='В папке «Черновики» нет писем.']";

    @FindBy(className = "mail-ComposeButton-Text")
    private WebElement NEW_CLICK;

    private WebDriver driver;

    public YandexGeneralPage(WebDriver driver){

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void createMail() {

        // Write new mail
        NEW_CLICK.click();

    }

    public boolean isSavedMailDisp() {

        WebElement savedMail = driver.findElement(By.xpath(DRAFT_FOLDER));
        savedMail.click();
        return savedMail.isDisplayed();
    }


    public boolean isContentMails() {

        // Check content of the saved mail present in Draft folder
        WebElement contetMail = driver.findElement(By.xpath(DRAFT_FOLDER));

        return contetMail.isDisplayed();
    }

    public boolean isContentMails2() {

        // Check content of the saved mail present in Draft folder
        WebElement contet2Mail = driver.findElement(By.xpath(MAIL_CHECK));
        Assert.assertEquals(NEW_MAIL, contet2Mail.getText());

        return contet2Mail.isDisplayed();
    }

    public void sendMail() {
        // Send mail
        WebElement sendMail = driver.findElement(By.xpath(SEND_BUT));
        sendMail.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public boolean isSentMail() {

        // Check content of the saved mail present in Draft folder
        WebElement sentFolder = driver.findElement(By.xpath(SENT_MAIL));
        sentFolder.click();
        WebElement sentMail = driver.findElement(By.xpath(DRAFT_FOLDER));

        return sentMail.isDisplayed();
    }

    public boolean checkSendMail(){

        // Go to draft folder and check that mail is Not available
        WebElement draftMails = driver.findElement(By.xpath(DRAFT));
        draftMails.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement emptyFolder = driver.findElement(By.xpath(DRAFT_EMPTY));

        return emptyFolder.isDisplayed();

    }

}

