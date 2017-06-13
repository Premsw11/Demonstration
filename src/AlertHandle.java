import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("driver.chrome.driver", "F:\\I\\EclipseWorkSpace\\Demo121\\chromedriver.exe");
		System.out.println(System.getProperty("driver.chrome.driver"));
		WebDriver webd = new ChromeDriver();
		webd.navigate().to("http://t4t5.github.io/sweetalert/");
		webd.manage().window().maximize();
		Thread.sleep(10000);
		String parentWindowHandle = webd.getWindowHandle();
		System.out.println("Parent Handle" + parentWindowHandle);
		Set<String> windowhandel = webd.getWindowHandles();
		Iterator<String> itr = windowhandel.iterator();
		String p = itr.next();
//		String childWindowHandle = itr.next();
		System.out.println(windowhandel.size());
//		System.out.println("Child Handle" + childWindowHandle);
		WebElement webel = webd.findElement(By.xpath("html/body/div[1]/button"));
		Actions builder = new Actions(webd);
		builder.moveToElement(webel).click().perform();
		Thread.sleep(5000);
		Alert alert = webd.switchTo().alert();
		alert.dismiss();
		webel = webd.findElement(By.xpath("html/body/div[2]/button"));
		
	}

}
