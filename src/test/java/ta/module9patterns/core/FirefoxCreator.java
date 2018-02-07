package ta.module9patterns.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxCreator extends DriverCreator {

	@Override
	public WebDriver createDriver() {

		driver = new FirefoxDriver();
		return driver;
	}
}
