package generic;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FWUtil
{
	public static void getPhoto(WebDriver driver,String path) 
	{
		try
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile=new File(path);
			FileUtils.copyFile(srcFile, destFile);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
