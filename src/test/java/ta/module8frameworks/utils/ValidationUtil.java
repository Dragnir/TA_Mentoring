package ta.module8frameworks.utils;

import org.testng.Assert;
import org.testng.Reporter;

public class ValidationUtil {

	public void logAssert(boolean var){

		Reporter.log("Check Mail", 2, true);
		Assert.assertTrue(var);

	}

}
