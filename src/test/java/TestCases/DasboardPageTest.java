package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.DashboardPage;
import Pages.LoginPage;

public class DasboardPageTest extends TestBase {
	LoginPage login;
	DashboardPage dash;
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		 login = new LoginPage();
		dash = new DashboardPage();
		login.loginToApp();
	}
	
	@Test (enabled = false)
	public void verifyusernameTest() throws InterruptedException 
	{
		String value = dash.verifyusername();
		Assert.assertEquals(value, "Rushikesh Sanjay Adhav");
	}
	@Test (enabled = false)
	public void verifyemailidTest() throws InterruptedException
	{
		String value =  dash.verifyemailid();
		Assert.assertEquals(value,"rushikeshadhav999@gmail.com");
	}
	@Test
	public void placeGttOrderTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		dash.placeGttOrder();
	}
	
	@AfterMethod
	public void exit()
	{
		driver.close();  //firefox madhe close method nai ahe quit use karavi lagal
	}
}
