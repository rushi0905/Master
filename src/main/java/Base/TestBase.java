package Base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase {
	
	public static WebDriver driver;
	//ChromeOptions options;
	
	public String readPropertyFile(String value) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("E:\\2022 workspace\\RushiFrameWork\\src\\main\\java\\Config\\Config.Properties");
		prop.load(file);
		return prop.getProperty(value);
	}
	public void initialization() throws IOException
	{
		String browsername = readPropertyFile("browser");	
		if(browsername.equalsIgnoreCase("chrome"))
		{
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications"); 
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver(o);
 
		}
		else if(browsername.equalsIgnoreCase("firefox")) //(cross browser testing sathi config.properties file madhe browser name change karav lagal)
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.msedge.driver", "msedgedriver.exe");
			driver = new EdgeDriver();
		}  
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get(readPropertyFile("url"));
		
	} 
	
	public String readexcelFile(int rowNum ,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("E:\\2022 workspace\\RushiFrameWork\\TestData\\Book1.xlsx");
		 Sheet excelfile = WorkbookFactory.create(file).getSheet("sheet1");
		 String value = excelfile.getRow(rowNum).getCell(cellNum).getStringCellValue();
		 return value;  //excel file chya value return karnyasathi
	 
	}

}
