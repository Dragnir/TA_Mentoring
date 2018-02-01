package ta.module9patterns.core;

import org.openqa.selenium.WebDriver;
import static ta.module9patterns.core.EnumDrivers.CHROME;

public class WebDriverFactory {

	private static WebDriver driver;

	public static WebDriver getDriverIns(EnumDrivers browser) {

		if (browser == CHROME) {

			driver = Singleton.getCromeDriverIns();
		}

		else {

			driver = Singleton.getFirefoxDriverIns();

		}

		return driver;
	}

}
