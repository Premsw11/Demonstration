package Pack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {

	public static void main(String[] args) {
		System.setProperty("driver.chrome.driver", "F:\\I\\EclipseWorkSpace\\Demo121\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://trello.com/");
//		driver.manage().window().maximize();
		WebElement webel = driver.findElement(By.xpath("//a[@href='/login?returnUrl=%2F']"));
		webel.click();
		webel = driver.findElement(By.xpath("//span[contains(text(),'Log in with Google')]"));
		webel.click();
		webel = driver.findElement(By.xpath("//input[@id='Email']"));
		webel.sendKeys("premsw11@gmail.com");
		webel = driver.findElement(By.xpath("//input[@id='next']"));
		webel.click();
		webel = driver.findElement(By.xpath("//input[@id='Passwd']"));
		webel.sendKeys("92149474665");
		webel = driver.findElement(By.xpath("//input[@id='PersistentCookie']"));
		webel.click();
		webel = driver.findElement(By.xpath("//input[@id='signIn']"));
		webel.click();
		webel = driver.findElement(By.xpath("//div[@id='header']/div/a/span[2]"));
		webel.click();
		webel = driver.findElement(By.xpath("//*[@id='boards-drawer']/div/div[2]/div[1]/div/div[3]/div[2]/div[2]/ul/li/div/a/span[2]/span"));
		webel.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement src = driver.findElement(By.xpath("//a[@href='/c/CKYoTIno/1-test-this']"));
		System.out.println("src"+src.getText());
		WebElement trg = driver.findElement(By.xpath("//*[@id='board']/div[2]/div/a"));
		System.out.println("trg" + trg.getText());
		Actions a1 = new Actions(driver);
		Actions dragAndDrop = a1.clickAndHold(src).moveToElement(trg).release(trg);
		dragAndDrop.build().perform();
		
		
		
	}

}
