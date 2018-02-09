package ta.module10BDD.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ta.module10BDD.core.EnumDrivers;
import ta.module10BDD.core.WebDriverFactory;

import java.util.concurrent.TimeUnit;

@CucumberOptions(strict = true, plugin = { "json:target/cucumber-report.json",
		"html:target/cucumber-report" }, tags = "@newMail", features = "src/test/resourses/test-classes/cucumber-features/yandex_basic.feature",
		glue = { "ta.module10BDD.steps" })

public class YandexCucumberTestNGTest extends AbstractTestNGCucumberTests {

	private static WebDriver driver = WebDriverFactory.getDriverIns(EnumDrivers.CHROME);

	@BeforeClass(description = "Start browser, add implicit wait and maximize window")
	public void startBrowser() {

		// set a certain implicit wait timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Maximize browser window
		driver.manage().window().maximize();
	}

	@AfterClass(description = "Stop Browser")
	public void stopBrowser() {
		driver.quit();
	}

}