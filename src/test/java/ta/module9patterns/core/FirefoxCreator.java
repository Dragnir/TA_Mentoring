package ta.module9patterns.core;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxCreator extends DriverCreator {

	@Override
	public WebDriver createDriver() {

		FirefoxBinary binary = new FirefoxBinary(new File("c:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		FirefoxOptions options = new FirefoxOptions().setBinary(binary);
		FirefoxProfile profile = new FirefoxProfile(new File(
				"c:\\Users\\Vadzim_Kuryan\\Documents\\FF_custom_profile\\"));
		options.setProfile(profile);
		driver = new FirefoxDriver(options);
		return driver;
	}
}
