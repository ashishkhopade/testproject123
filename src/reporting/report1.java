package reporting;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class report1 {

	ExtentReports report;
	ExtentTest logger;
	public static WebDriver driver;
	
	@BeforeTest
	public void starttest() throws InterruptedException
	{
		report=new ExtentReports("F:\\STUDY\\SOFTWEAR TESTING\\selenium topic wize notes\\myreport.html");
	    logger = report.startTest("login verification");
	    System.setProperty("webdriver.gecko.driver","F:\\STUDY\\SOFTWEAR TESTING\\softwear\\geckodriver.exe");
	    driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(2000);                  
	 
	}
	@Test
	public void verify_title() throws IOException
	{
		logger.log(LogStatus.INFO,"BROWSER STARTED");
		String title=driver.getTitle();
		String ExpectedTitle="hjj";
		if(title.equals(ExpectedTitle))
		{
		
		logger.log(LogStatus.PASS,"Title Verified");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Failed Log");
			String abc=capturescreenshot(driver,"screenshot123");
		}
		}
		
	
	


	@AfterMethod
	public  void endtest()
	{
		report.endTest(logger);
		report.flush();
		driver.get("F:\\STUDY\\SOFTWEAR TESTING\\selenium topic wize notes\\myreport.html");
	}
	
	public String capturescreenshot(WebDriver driver,String name) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("F:/ "+name+".png"));
		System.out.println("Screen shot taken");
		return name ;
		
		
		
		
	}
}

