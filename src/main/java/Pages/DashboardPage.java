package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class DashboardPage extends TestBase {
	
	@FindBy (xpath="//div[@class=\"avatar\"]")private WebElement avatarIcon; 
	@FindBy (xpath="//h4[@class=\"username\"]")private WebElement username;
	@FindBy (xpath="//div[@class=\"email\"]")private WebElement emailid;
	@FindBy (xpath="//button[text()='Start investing ']") private WebElement startinvestingBtn;
	@FindBy (xpath="(//input[@icon=\"search\"])[2]") private WebElement searchShareBox;
	@FindBy (xpath="//ul[@class=\"omnisearch-results\"]//li[1]") private WebElement selectshare;
	@FindBy (xpath="//button[text()='Create GTT ']") private WebElement createGttBtn;
	@FindBy (xpath="//input[@label=\"Trigger price\"]") private WebElement triggerpriceTextBox;
	@FindBy (xpath="//input[@label=\"Qty.\"]")private WebElement qtyTextBox;
	@FindBy (xpath="//input[@label=\"Price\"]") private WebElement priceTextbox;
	@FindBy (xpath="//button[@class=\"button-outline cancel\"]") private WebElement cancelBtn;
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	public String verifyusername() throws InterruptedException
	{
		avatarIcon.click();
		Thread.sleep(2000);
		return username.getText();
	}
	public String verifyemailid() throws InterruptedException
	{
		avatarIcon.click();
		Thread.sleep(2000);
		return emailid.getText();
	}
	public void placeGttOrder() throws InterruptedException, EncryptedDocumentException, IOException
	{
		startinvestingBtn.click();
		Thread.sleep(2000);
//		searchShareBox.sendKeys("INFY");
		searchShareBox.sendKeys(readexcelFile(0,0));
		Thread.sleep(2000);
		selectshare.click();
		Thread.sleep(2000);
		createGttBtn.click();
		Thread.sleep(2000);
		triggerpriceTextBox.clear();
		Thread.sleep(2000);
//		triggerpriceTextBox.sendKeys("1500");
		triggerpriceTextBox.sendKeys(readexcelFile(0, 1));
		Thread.sleep(2000);
		qtyTextBox.clear();
		Thread.sleep(2000);
//		qtyTextBox.sendKeys("50");
		qtyTextBox.sendKeys(readexcelFile(0, 2));
		Thread.sleep(2000);
		priceTextbox.clear();
		Thread.sleep(2000);
//		priceTextbox.sendKeys("1499");
		priceTextbox.sendKeys(readexcelFile(0, 3));
		Thread.sleep(2000);
		cancelBtn.click();
	}
}
