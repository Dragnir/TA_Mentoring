package ta.module9patterns.core;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ChromeCreator extends DriverCreator {

	@Override
	public WebDriver createDriver() {

		ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(
				new File("d:\\_WebDriver\\chromedriver.exe")).build();
		try {
			service.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = new ChromeDriver(service);
		return driver;
	}
}
