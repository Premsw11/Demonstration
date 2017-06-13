import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;

public class MulWindow {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("driver.chrome.driver", "F:\\I\\EclipseWorkSpace\\Demo121\\chromedriver.exe");
		System.out.println(System.getProperty("driver.chrome.driver"));
		WebDriver webd = new ChromeDriver();
		webd.navigate().to("http://www.rediff.com/");
		webd.manage().window().maximize();
		Thread.sleep(10000);
		String parentWindowHandle = webd.getWindowHandle();
		System.out.println("Parent Handle" + parentWindowHandle);
		Set<String> windowhandel = webd.getWindowHandles();
		Iterator<String> itr = windowhandel.iterator();
		String p = itr.next();
		String childWindowHandle = itr.next();
		System.out.println(windowhandel.size());
		System.out.println("Child Handle" + childWindowHandle);
		webd.switchTo().window(childWindowHandle);
		System.out.println(webd.getTitle());
		webd.manage().window().maximize();
		webd.close();
		webd.switchTo().window(parentWindowHandle);
		System.out.println(webd.getTitle());
		
	}

}
