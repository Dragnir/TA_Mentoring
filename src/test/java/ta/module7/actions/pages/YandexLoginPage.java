package ta.module7.actions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class YandexLoginPage extends AbstractPage {

    private static final String LOGIN = "vadim.kuryan.vka";
    private static final String LOGIN_LOCATOR = "passport-Input-Controller";
    private static final String PASSWORD = "Vka_6463296";
    private static final By PASSWORD_LOCATOR = By.name("passwd");
    private static final String SUBMIT = "passport-Button-Text";

    public YandexLoginPage(WebDriver driver){
        super(driver);
    }

    public void setLogin() {

        // Find and set login
        WebElement loginButton = driver.findElement(By.className(LOGIN_LOCATOR));
        hightlightElement(loginButton);
        loginButton.sendKeys(LOGIN);
    }

    public void setPassword() {

        // Find and set password
        WebElement passwordButton = driver.findElement(PASSWORD_LOCATOR);
        hightlightElement(passwordButton);
        passwordButton.sendKeys(PASSWORD);

    }

    public void logIn() {

        // Find and click on submit button
        WebElement submitButton = driver.findElement(By.className(SUBMIT));
        new Actions(driver).moveToElement(submitButton).build().perform();
        new Actions(driver).click(submitButton).build().perform();

    }
}
