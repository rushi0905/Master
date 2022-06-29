package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy (xpath="//img[@alt=\"Kite\"]") WebElement kiteLogo;
	@FindBy (xpath="//img[@alt=\"Zerodha\"]") WebElement zerodhaLogo;
	@FindBy (xpath="//input[@id=\"userid\"]") WebElement useridTextbox;
	@FindBy (xpath="//input[@type=\"password\"]") WebElement passwordTextbox;
	@FindBy (xpath="//button[@type=\"submit\"]") WebElement loginBtn;
	@FindBy (xpath="//input[@id=\"pin\"]") WebElement pinTextbox;
	@FindBy (xpath="//button[@class=\"button-orange wide\"]") WebElement continueBtn;
	@FindBy (xpath="//span[@class=\"nickname\"]") WebElement nicknameLable;
	
	public LoginPage()     //to initialize element
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyTitle()
	
	{
		 return driver.getTitle();
	} 
	
	public boolean verifykiteLogo()
	{
		 return kiteLogo.isDisplayed();
	}
	public boolean verifyzerodhaLogo()
	{
		 return zerodhaLogo.isDisplayed();
	}
	public String loginToApp() throws InterruptedException, IOException
	{
		useridTextbox.sendKeys(readPropertyFile("username"));
		Thread.sleep(5000);
		passwordTextbox.sendKeys(readPropertyFile("password"));
		loginBtn.click();
		Thread.sleep(5000);
		pinTextbox.sendKeys(readPropertyFile("pin"));
		continueBtn.click();
		Thread.sleep(5000);
		return nicknameLable.getText();

		
	}
	
	
}







//Encapsulation = data(Private) + member function(Public)