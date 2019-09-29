package library;

import java.lang.reflect.Method;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
 

public class KeywordLibrary 
{
	static WebDriver driver; 
	public static  void controller(String methodNmae, String arg1, String arg2, String arg3) throws Exception, SecurityException
	{
		Method method = KeywordLibrary.class.getDeclaredMethod(methodNmae, String.class, String.class, String.class );
		method.invoke(KeywordLibrary.class, arg1, arg2, arg3);
	}
	
	public static void launchBrowser(String arg1, String arg2, String arg3)
	{
		if (arg1.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\New folder (2)\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if (arg1.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver();
		}
		driver.get(arg2);
		
	}
	
	
	public static void enterText(String arg1, String arg2, String arg3) 
	{
		if(arg1.equals("name"))
		{
			driver.findElement(By.name(arg2)).sendKeys(arg3);
			
		}
		else if (arg1.equals("id"))
		{
			driver.findElement(By.id(arg2)).sendKeys(arg3);
		}
		else if (arg1.equals("xpath"))
		{
			driver.findElement(By.xpath(arg2)).sendKeys(arg3);
		}
	}
	
	public static void clickButton(String arg1, String arg2, String arg3) 
	{
		if(arg1.equals("name"))
		{
			driver.findElement(By.name(arg2)).click();
			
		}
		else if (arg1.equals("id"))
		{
			driver.findElement(By.id(arg2)).click();
		}
		else if (arg1.equals("xpath"))
		{
			driver.findElement(By.xpath(arg2)).click();
		}
	}
	
	
	public static void windowSwitch(String arg1, String arg2, String arg3)
	{
		String parantWindowId = driver.getWindowHandle();
		
		Set<String> allWindowId=driver.getWindowHandles();
		System.out.println(allWindowId);
		
		for (String window :allWindowId)
		{
			if(!window.equals(parantWindowId))
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains(arg1))
				{
					driver.findElement(By.xpath(arg2)).click();
				}
				
				
			}
		}
		driver.switchTo().window(parantWindowId);

	
	}
	
	public static void alert(String arg1 , String arg2 , String arg3) throws Exception
	{
		Alert alert = driver.switchTo().alert();
		
		String text = alert.getText();
		
		System.out.println(text);
		Thread.sleep(3000);
		alert.dismiss();
	}
	
	public static void refresh(String arg1 , String arg2 , String arg3)
	{
		driver.navigate().refresh();
	}
	
	public static void getText(String arg1 , String arg2 , String arg3)
	{
		if(arg1.equals("id")){
		String  text = driver.findElement(By.id(arg2)).getText(); 
		System.out.println(text);
		}
		
		
	}
	
	public static void wait(String arg1 , String arg2 , String arg3) throws Exception
	{
		Thread.sleep(5000);
	}
	
	
	
	public static void mouseHover(String arg1 , String arg2 , String arg3) throws Exception
	{  
		if(arg1.equals("click"))
		{
		WebElement link = driver.findElement(By.xpath(arg2));
		Actions action = new Actions(driver);
		action.moveToElement(link).build().perform();
		}
		else if(arg1.equals("scrollDown"))
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,250)");
			Thread.sleep(2000);
		}
		else if (arg1.endsWith("rightClick"))
		{
			WebElement link = driver.findElement(By.xpath(arg2));
			Actions action = new Actions(driver);
			
			action.contextClick(link).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
			
		}
		
		
	}
	
	public static void getData(String arg1 , String arg2 , String arg3)
	{
		String allData=driver.findElement(By.xpath(arg1)).getText();
		System.out.println(allData);
	}
	
}
