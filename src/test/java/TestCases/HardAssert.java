package TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class HardAssert extends TestBase{
	
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
		 Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform",title );
		 System.out.println("This is verify title test");
	}
	@Test
	public void verifyzerodhaLogoTest()
	{
		boolean value=login.verifyzerodhaLogo();
		Assert.assertTrue(value);
	}
	@Test
	public void exit()
	{
		//driver.close();
		driver.quit();
	}
	
}
