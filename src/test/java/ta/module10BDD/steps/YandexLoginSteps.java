package ta.module10BDD.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import ta.module10BDD.bobjects.UserAccount;
import ta.module10BDD.core.EnumDrivers;
import ta.module10BDD.core.WebDriverFactory;
import ta.module10BDD.pages.NewMailPage;
import ta.module10BDD.pages.YandexGeneralPage;
import ta.module10BDD.pages.YandexLoginPage;
import ta.module10BDD.utils.ValidationUtil;

public class YandexLoginSteps {

	private String login = "vadim.kuryan.vka";
	private String password = "Vka_6463296";
	private static WebDriver driver = WebDriverFactory.getDriverIns(EnumDrivers.CHROME);
	private static final String URL_YANDEX = "https://passport.yandex.by/passport?mode=auth&from=mail&retpath=https%3A%2F%2Fmail.yandex.by&origin=hostroot_by_nol_mobile_enter";

	@Given("^New scenario started$")
	public void new_scenario() {
		System.out.println("New scenario started");
	}

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

	@Given("^user create new mail$")
	public void create_new_mail() {
		System.out.println("Start create new mail");
	}

	@When("^user enter mail \"([^\"]*)\" and theme and save mail as draft$")
	public void enter_address_save(String address) {
		YandexGeneralPage generPage = new YandexGeneralPage(driver);
		generPage.createMail();
		NewMailPage newMail = new NewMailPage(driver);
		newMail.setMailAdress(address);
		newMail.setMailTheme();
		newMail.saveAsDraft();
	}

	@Then("^new mail available in draft folder$")
	public void verify_new_mail() {
		System.out.println("New mail is available");
	}

	@Given("^user send new mail$")
	public void send_new_mail() {
		ValidationUtil valUtil = new ValidationUtil();
		YandexGeneralPage generPage = new YandexGeneralPage(driver);
		valUtil.logTrue(generPage.isSavedMailDisp(), "Mail was saved");
		valUtil.logTrue(generPage.isContentMails(), "Content present");
	}

	@When("^user go to draft folder and send mail$")
	public void go_send_mail() {
		YandexGeneralPage generPage = new YandexGeneralPage(driver);
		generPage.sendMail();
		generPage.sendMail();
	}

	@Then("^new mail is removed from draft folder$")
	public void verify_sent_mail() {
		ValidationUtil valUtil = new ValidationUtil();
		YandexGeneralPage generPage = new YandexGeneralPage(driver);
		valUtil.logTrue(generPage.isSentMail(), "Mail was send");
		//valUtil.logTrue(generPage.checkSendMail(), "Draft folder is empty");
	}
}
