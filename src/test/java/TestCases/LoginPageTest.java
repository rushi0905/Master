package TestCases;

import java.io.IOException;




import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class LoginPageTest extends TestBase {

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
	}
	
	 
	@Test  (dependsOnMethods = {"verifyTitleTest"})
	public void verifykiteLogoTest()
	{
		boolean value = login.verifykiteLogo();  //ith call karnyasathi object create kela
		//Assert.assertEquals(true, value);
		Assert.assertTrue(value);
	}
	@Test (dependsOnMethods = {"verifyTitleTest"})
	public void verifyzerodhaLogoTest()
	{ 
		boolean value = login.verifyzerodhaLogo();
	//	Assert.assertFalse(value);
		Assert.assertTrue(value);
	}
	@Test  (enabled = false)
	public void loginToAppTest() throws InterruptedException, IOException
	{
		 String nickname = login.loginToApp();
		 Assert.assertEquals(nickname,"Rushikesh");
	}
	
	
	@AfterMethod
	public void exit()
	{
//		driver.close();
		driver.quit();
	}
	
}
