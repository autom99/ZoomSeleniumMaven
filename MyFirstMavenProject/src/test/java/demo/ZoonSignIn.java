package demo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoonSignIn {

	@Test
	public void TestZoomSignin() throws InterruptedException {

		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		String baseURL = "https://zoom.us/";
		  
		try {			
			//Go to URL - Zoom sign in
			driver.get("https://zoom.us/signin");
			Thread.sleep(2000);
			
			//signin username
			WebElement elementusername = driver.findElement(By.xpath("//input[@type='email'][@name='email']"));
			elementusername.clear();
			elementusername.sendKeys(new String[]{"hibogo1507@oppamail.com"}); 

			//signin password
			WebElement elementPassword = driver.findElement(By.xpath("//input[@type='password'][@name='password']"));
			elementPassword.clear();
			elementPassword.sendKeys("Zoom@1234"); 
			
			//button click SIGNIN
			WebElement elementButtonSignin = driver.findElement(By.xpath("//a[text()='Sign In']"));	
			elementButtonSignin.click();
			Thread.sleep(3000);
			
			String actualUrl= baseURL  + "/profile"; 
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
