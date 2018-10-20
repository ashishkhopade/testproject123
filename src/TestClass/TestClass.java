package TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {

	public WebDriver driver;

	@BeforeTest
	public void startApp() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "F:\\STUDY\\SOFTWEAR TESTING\\softwear\\geckodriver.exe");

		// to pen browser 
		WebDriver driver=new FirefoxDriver();

		// open url
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);



	}

	@Test(priority=2)
	public void testCase() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("nitinbhandari.engg@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("feelmylove");
		driver.findElement(By.id("u_0_2")).click();
		Thread.sleep(3000);

	}

	@Test(priority=1)
	public void invalidlogin() throws InterruptedException
	{
		driver.findElement(By.id("email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.id("u_0_2")).click();
		Thread.sleep(3000);
	}
	@AfterTest
	public void CloseApp() {
		driver.quit();

	}


}
