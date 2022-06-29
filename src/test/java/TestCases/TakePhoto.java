package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.Util1;

public class TakePhoto extends TestBase {

	LoginPage login;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new LoginPage();  //create object becoz non static method ahe verifykitelogo and verifyzerodhalogo
	}
	@Test 
	public void verifyTitleTest()
	{
		 String title = login.verifyTitle();
		 Assert.assertEquals("1Kite - Zerodha's fast and elegant flagship trading platform",title );
	}
	@Test
	public void verifykiteLogoTest()
	{
		boolean value = login.verifykiteLogo();  //ith call karnyasathi object create kela
		Assert.assertEquals(false, value);
	//	Assert.assertTrue(value);
	}
	@Test
	public void verifyzerodhaLogoTest()
	{ 
		boolean value = login.verifyzerodhaLogo();
	//	Assert.assertFalse(value);
		Assert.assertTrue(value);
	}
	
	@AfterMethod
	public void exit(ITestResult it) throws IOException
	{
		if(ITestResult.FAILURE == it.getStatus())
		{
			Util1.screenshot(it.getName());
		}
		driver.close();
	}
}























