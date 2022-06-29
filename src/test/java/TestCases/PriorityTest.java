package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class PriorityTest {
	
	public class PriortyTest extends TestBase {

		LoginPage login;
		@BeforeMethod
		public void setup() throws IOException
		{
			initialization();
			login = new LoginPage();  //create object becoz non static method ahe verifykitelogo and verifyzerodhalogo
		}
		@Test (priority=-1,invocationCount=5)
		public void verifyTitleTest()
		{
			 String title = login.verifyTitle();
			 Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform",title );
			 Reporter.log("Execute verify title test");
		}
		
		 
		@Test  (priority = 0,timeOut = 500)
		public void verifykiteLogoTest()
		{
			boolean value = login.verifykiteLogo();  //ith call karnyasathi object create kela
			//Assert.assertEquals(true, value);
			Assert.assertTrue(value);
			Reporter.log("Execute kitelogo test");
		}
		@Test  (priority = 2)
		public void verifyzerodhaLogoTest()
		{
			boolean value = login.verifyzerodhaLogo();
		//	Assert.assertFalse(value);
			Assert.assertTrue(value);
			Reporter.log("Execute zerodhalogo test");
		}
		@Test  (priority = -3)
		public void loginToAppTest() throws InterruptedException, IOException
		{
			 String nickname = login.loginToApp();
			 Assert.assertEquals(nickname,"Rushikesh");
			 Reporter.log("Execute logintoapp test");
		}
		
		
		@AfterMethod
		public void exit()
		{
//			driver.close();
			driver.quit();
		}
		
	 }
	}
