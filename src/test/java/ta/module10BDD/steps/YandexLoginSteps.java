package ta.module10BDD.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import ta.module10BDD.bobjects.UserAccount;
import ta.module10BDD.core.EnumDrivers;
import ta.module10BDD.core.WebDriverFactory;
import ta.module10BDD.pages.YandexLoginPage;

public class YandexLoginSteps {

	private String login = "vadim.kuryan.vka";
	private String password = "Vka_6463296";
	private static WebDriver driver = WebDriverFactory.getDriverIns(EnumDrivers.CHROME);
	private static final String URL_YANDEX = "https://passport.yandex.by/passport?mode=auth&from=mail&retpath=https%3A%2F%2Fmail.yandex.by&origin=hostroot_by_nol_mobile_enter";

	@Given("^user navigates to Yandex mail$")
	public void navigate_to_home_page() {
		driver.get(URL_YANDEX);
	}

	@When("^enters user credentials and submits login form$")
	public void enter_user_credentials() {
		UserAccount account = new UserAccount();
		account.setLogin(login);
		account.setPassword(password);

		YandexLoginPage loginPage = new YandexLoginPage(driver);
		loginPage.loginUser(account);

	}

	@Then("^yandex mail home page is displayed$")
	public void verify_login_is_completed() {

		System.out.println("Login was completed correctly.");

	}
}
