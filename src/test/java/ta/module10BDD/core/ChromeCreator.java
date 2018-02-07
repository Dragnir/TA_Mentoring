package ta.module10BDD.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeCreator extends DriverCreator {

	private static final String DRIVER_LOCATION = "d:\\_WebDriver\\chromedriver.exe" ;

	@Override
	public WebDriver createDriver() {

		System.setProperty("webdriver.chrome.driver", DRIVER_LOCATION);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);

		return driver;
	}
}
