package ta.module8frameworks.utils;

import org.testng.Assert;

public class ValidationUtil {

	public void logAssert(boolean var){

		Assert.assertTrue(var);
		System.out.println("All good");

	}

}
