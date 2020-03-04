package demo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomSignUp {

	@Test
	public void TestZoomSignup() throws InterruptedException {

		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		String baseURL = "https://zoom.us/";
		
		try {			
			//Go to URL - Zoom sign up
			driver.get("https://zoom.us/signup");
			Thread.sleep(3000);
			
			//signup link
			WebElement elementSignup = driver.findElement(By.xpath("//input[@id='email']"));
			elementSignup.clear();
			elementSignup.sendKeys("johih21934@webbamail.com"); 
			
			//button click
			WebElement elementButtonSignup = driver.findElement(By.xpath("//a[text()='Sign Up']"));	
			elementButtonSignup.click();
			Thread.sleep(3000);
			
			String actualUrl= baseURL  + "/emailsent?entry=signup"; //https://www.zoom.us/emailsent?entry=signup
			String expectedUrl= driver.getCurrentUrl(); 
			Assert.assertEquals(expectedUrl,actualUrl);

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		finally{
			driver.close();
			driver.quit();
		}				
	}
}
