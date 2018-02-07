package ta.module10BDD.utils;

import org.testng.Assert;

public class ValidationUtil {

	public void logTrue(boolean var, String message){

		System.out.println(message);
		Assert.assertTrue(var);

	}

}
