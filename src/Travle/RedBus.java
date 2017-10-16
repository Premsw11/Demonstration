package Travle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.file.FileReader;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		
		List<WebElement> elementlist;
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.home")+"\\git\\Demonstration\\ExeFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/search?fromCityName=Kota%28Rajasthan%29&fromCityId=1443&toCityName=Jaipur&toCityId=807&onward=22-Sep-2017&opId=0&busType=Any");
		driver.manage().window().maximize();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement element = (WebElement) jse.executeScript("return document.getElementsByClassName('view-seats button to-be-hidden')[0]");
		element.click();
		
//		int i = 0;
//		while( i < 4) {
//		element =  (WebElement) jse.executeScript("return document.getElementsByTagName('iframe')["+i+"]");
//		System.out.println("return document.getElementsByTagName('iframe')["+i+"]");
//			System.out.println("iframe is  "+element);
//			driver.switchTo().frame(element);
//			
//			i++;
//			elementlist = driver.findElements(By.xpath("//*"));
//		Iterator itr = elementlist.iterator();
//	
//	
//		
//		while (itr.hasNext()) {
//			element = (WebElement) itr.next();
//			//if(element.getTagName().toString().trim() == "canvas")
//			System.out.println("elem is  "+element.getTagName());
//			//System.out.println("elem is  "+element.getText());
//			
//		}
//		driver.switchTo().defaultContent();
//		System.out.println("Moved to default content");
//		}
		//element = (WebElement) jse.executeScript("return document.getElementsByTagName('canvas')[0]");
		//System.out.println("lookkkk   "+element);
		//element.click();
		//element.g
		Thread.sleep(5000);
		element = driver.findElement(By.xpath("//*[@class='lower-canvas canvas-wrapper']/descendant::canvas"));
		System.out.println("elem is "+element);
		System.out.println("elem is "+element.getAttribute("text"));
		System.out.println("elem is "+element.getTagName());
		System.out.println("elem is tag "+element.getText());
		System.out.println("elem is "+element.getCssValue(""));
		element.click(); 
	}
}
