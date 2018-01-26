package ta.module8frameworks.utils;

import org.testng.Assert;

public class ValidationUtil {

	public void logAssert(boolean var){

		Assert.assertTrue(var);
		System.out.println("Mail was saved");

	}

	public void assertContent(boolean var){

		Assert.assertTrue(var);
		System.out.println("Content present");

	}

	public void assertSend(boolean var){

		Assert.assertTrue(var);
		System.out.println("Mail was send");

	}

	public void assertDraft(boolean var){

		Assert.assertTrue(var);
		System.out.println("Draft folder is empty");

	}

}
