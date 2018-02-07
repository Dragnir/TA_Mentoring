package ta.module10BDD.core;

import org.openqa.selenium.WebDriver;

public abstract class DriverCreator {
	protected WebDriver driver;

	public abstract WebDriver createDriver();
}
