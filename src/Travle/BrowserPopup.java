package Travle;

import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrowserPopup {

	@Test
	public void closePopup() {
		System.setProperty("webdriver.chrome.driver", ".//ExeFiles//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File(".//ExeFiles//extension.crx"));
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.cleartrip.com/");
		
	}
}
