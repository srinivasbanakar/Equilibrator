package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base implements IAutoConst
{
	
	static 
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE );
	}
	static 
	{
		System.setProperty(FIREFOX_KEY,FIREFOX_VALUE );
	}
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void open()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	@AfterMethod
	public void close(ITestResult testResult)
	{
		String name = testResult.getName();
		int status=testResult.getStatus();
		if (status==1)
		{
			Reporter.log("Test "+name+" is PASSED",true);
			
		}
		else
		{
			Reporter.log("Test "+name+" is FAILED/SKIPPED",true);
			String path=IMG_PATH+name+".png";
			FWUtil.getPhoto(driver, path);
		}
		driver.close();
	}

}
