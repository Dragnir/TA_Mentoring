package ta.module6.pages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexLoginPage {

    private static final String LOGIN = "vadim.kuryan.vka";
    private static final String LOGIN_LOCATOR = "passport-Input-Controller";
    private static final String PASSWORD = "Vka_6463296";
    private static final String PASSWORD_LOCATOR = "passwd";
    private static final String SUBMIT = "passport-Button-Text";
    private WebDriver driver;

    public YandexLoginPage(WebDriver driver){

        this.driver = driver;
    }

    public void logIn() {

        // Find and set login
        WebElement loginButton = driver.findElement(By.className(LOGIN_LOCATOR));
        loginButton.sendKeys(LOGIN);

        // Find and set password
        WebElement passwordButton = driver.findElement(By.name(PASSWORD_LOCATOR));
        passwordButton.sendKeys(PASSWORD);

        // Find and click on submit button
        WebElement submitButton = driver.findElement(By.className(SUBMIT));
        submitButton.click();

    }
}
