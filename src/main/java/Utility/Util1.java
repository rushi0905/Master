package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class Util1 extends TestBase {
	
	//it take screenshot only failed test cases
	public static void screenshot(String name) throws IOException 
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("E:\\2022 workspace\\RushiFrameWork\\Screenshot/"+name+".jpeg");
		FileHandler.copy(source, dest);
	}

}
