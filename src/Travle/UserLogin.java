package Travle;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.logging.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.steadystate.css.util.Output;

public class UserLogin {
	public static WebDriver driver;
	public static WebElement element;
	
/*  	method for wait till the page gets loaded			(import com.google.common.base.Function;)  */
	public static void waitforPageLoad(WebDriver driver)  {
	Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
			.withTimeout(30, TimeUnit.SECONDS)
            .pollingEvery(5, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);
	wait1.until(new Function<WebDriver, Boolean>() {
		public Boolean apply(WebDriver driver) {
			System.out.println("current window state   :"+String.valueOf(((JavascriptExecutor)driver).executeScript("return document.readyState")));
			return String.valueOf(((JavascriptExecutor)driver).executeScript("return document.readyState")).equals("complete");
		}
	});
	}

/*		Capture Screenshot  				*/	
	public static void takeScreenshot(String screenshotName) {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(".\\Screenshot\\" +screenshotName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void login() {

		System.setProperty("webdriver.chrome.driver","F:\\IT\\EclipseWorkSpace\\Demo121\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
/* 		To make an explicit wait for 30 seconds			*/
		//selenium.logComment("Started");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.navigate().to("http://phptravels.com/");
		driver.manage().window().maximize();
		element = driver.findElement(By.xpath("//a[contains(text(),'Demo')]"));
		element.click();

/*		To take user Name and Password from the web      */
		element= driver.findElement(By.xpath("//*[@class=' wow fadeInUp col-md-12 animated']/div/div/div[2]/div[2]/div/div[3]/div[2]/div"));
		String[] data = element.getText().split("\\s");
		/*		To click on the link  			*/	
		element = driver.findElement(By.xpath("//a[@href='//www.phptravels.net']"));
		element.click();

/* 		To switch to newly open window				*/
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> itr = allWindows.iterator();
		String childWindow = null;;
		if (allWindows.size()==2) {
			System.out.println("Main window is :"+itr.next());
			childWindow = itr.next();
			System.out.println(childWindow);
		}
		System.out.println("1st window"+driver.getTitle());
		driver.switchTo().window(childWindow);
		System.out.println("2st window"+driver.getTitle());

		/*		To click on the Login link  			*/
		element = driver.findElement(By.xpath("//*[contains(text(),'My Account')]"));
		element.click();
		element = driver.findElement(By.xpath("//*[contains(text(),'Login')]"));
		element.click();

		/* 		To Enter userName and Password and make Login				*/
		element = driver.findElement(By.xpath("//input[@type='email']"));
		element.sendKeys(data[1]);
		element = driver.findElement(By.xpath("//input[@type='password']"));
		element.sendKeys(data[3]);
		element = driver.findElement(By.xpath("//button[@type='submit'and contains(text(),'Login')]"));
		element.click();

	
		/*  	TO ensure next page is fully download in order to continue with next class		*/	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'John')]")));
	
	}

}
