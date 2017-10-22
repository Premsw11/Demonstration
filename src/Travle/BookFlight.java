package Travle;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.event.DocumentEvent.ElementChange;

import org.apache.xml.serialize.ElementState;
import org.omg.PortableServer.Current;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class BookFlight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*  To make Logged in				*/
				UserLogin.login();

/*  Create driver and element reference for driver and element variable	respectively		*/
				WebDriver driver = UserLogin.driver;
//				WebDriverWait wait = new WebDriverWait(driver,20);
				WebElement element = UserLogin.element;


//		System.setProperty("webdriver.chrome.driver", "F:\\IT\\EclipseWorkSpace\\Demo121\\lib\\chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "F:\\IT\\EclipseWorkSpace\\Demo121\\lib\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//		WebElement element;
//		driver.get("http://www.phptravels.net/flight");
//		WebDriverWait wait = new WebDriverWait(driver,10);
		
				
/*		continue after Login by clicking on flights			*/
		element = driver.findElement(By.xpath("//a[@href='http://www.phptravels.net/flight']"));
		element.click();

/*  	This page has iframe that's why we are having issue in first time			*/		
		System.out.println("Total frames on the page : " +(driver.findElements(By.xpath("//iframe")).size()));
		driver.switchTo().frame(0);
		
		WebDriver driver1 = new ChromeDriver();
		 
/*		Using Actions class since it was also writing in the destination input box			*/		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//input[@name='origin_name']")));
		actions.click();
		actions.sendKeys("New Delhi");
		actions.build().perform();

/*		Explicit wait for an element to be available				*/
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mewtwo-autocomplete']")));
		element = driver.findElement(By.xpath("//div[@class='mewtwo-autocomplete']"));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='mewtwo-autocomplete']/ul/child::li/span[1]/span[1]")));

/*		List of all suggested origins			*/
		List<WebElement> list = new ArrayList<WebElement>();
		list = element.findElements(By.xpath("//ul/child::li/span[1]/span[1]"));
		Iterator<WebElement> itr = list.iterator();
		System.out.println("All the suggested origins : " +list.size());
		while(itr.hasNext()) {
			element =  itr.next();
			if(element.getText().contains("Delhi")){
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				break;
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*		Type destination			*/
		actions.moveToElement(driver.findElement(By.xpath("//input[@name='destination_name']")));
		actions.click();
		actions.sendKeys("Jaipur");
		actions.build().perform();
				
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//div[@class='mewtwo-autocomplete']/ul/child::li/span[1]/span[1]"), "Jaipur"));
			
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
/*		wait new suggestions are to appear on page			*/		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mewtwo-autocomplete']")));
		element = driver.findElement(By.xpath("//div[@class='mewtwo-autocomplete']"));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='mewtwo-autocomplete']/ul/child::li/span[1]/span[1]")));

/*		Iterate through all the suggestion for destination			*/		
		List<WebElement> list1 = new ArrayList<WebElement>();
		list1 = element.findElements(By.xpath("//ul/child::li/span[1]/span[1]"));
		Iterator<WebElement> itr1 = list1.iterator();
		System.out.println("All the suggested destinations : " +list1.size());
		while(itr1.hasNext()) {
			element =  itr1.next();
			if(element.getText().contains("Jaipur")){
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				break;
			}
			System.out.println(element.getText());
		}
				
/*		Set the depart date					*/
		element = driver.findElement(By.xpath("//input[@id='flights-dates-depart-prepop-whitelabel_en']"));
		element.click();
			
/*		wait for calendar pop up to appear				*/		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='mewtwo-modal mewtwo-modal--whitelabel_en']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='mewtwo-modal mewtwo-modal--whitelabel_en']")));

		String depart_date = "3/Aug/2017";
		String[] depart_date_array = depart_date.split("/");
		
/*		previous month and next month button		*/
		WebElement last_Month = driver.findElement(By.xpath("//*[@class='mewtwo-datepicker-prev-month-control']"));
		WebElement first_Displayed_Month = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/span[2]/span[1]"));
		WebElement next_Month = driver.findElement(By.xpath("//*[@class='mewtwo-datepicker-next-month-control']"));

		
		while(!first_Displayed_Month.getText().contains(depart_date_array[2])) {
			next_Month.click();
		}
		while(!first_Displayed_Month.getText().contains(depart_date_array[1])) {
			next_Month.click();
		}
		List<WebElement> dateList = new ArrayList<WebElement>(); 
		dateList =  driver.findElements(By.xpath("//*[@class='mewtwo-modal-wrapper mewtwo-modal--max']/div[1]/div[1]/div[2]/div[1]/div[1]/table/tr/td"));
		Iterator<WebElement> dateItr = 	dateList.iterator();
		while(dateItr.hasNext()) {
			element = dateItr.next();
			if(element.getText().trim().contentEquals(depart_date_array[0])) {
				element.click();
				break;
			}
		}
		
/*		To click on Return ticket is not needed				*/
		wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("//span[contains(text(),'Return ticket is not needed')]"), "Return ticket is not needed"));
		element = driver.findElement(By.xpath("//span[contains(text(),'Return ticket is not needed')]"));
		element.click();
		
		
		
		element = driver.findElement(By.xpath("//*[@class='mewtwo-flights-trip_class-wrapper']"));
		element.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='mewtwo-passengers']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='mewtwo-passengers']")));

/*		To click on search button			*/		
		element = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
		element.click();

/*		Wait until all the flight links are displayed*/
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(("//*[@class='tickets-container js-tickets-container']/div[@role='tickets_container']/child::div"))));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(("//*[@class='tickets-container js-tickets-container']/div[@role='tickets_container']/child::div"))));
		
/*		Create list of all flights suggestion			*/		
		List<WebElement> flight = new ArrayList<WebElement>();
		flight = driver.findElements(By.xpath(("//*[@class='tickets-container js-tickets-container']/div[@role='tickets_container']/child::div/div[@class='ticket-scroll-container']/div[1]/div[1]/a")));
		System.out.println("number of links for fligths: "+flight.size());

/*		Number of windows					s			*/
		Set<String> setWindows1 = new HashSet<String>();
		setWindows1 = driver.getWindowHandles();
		System.out.println("size of w1"+"\t"+setWindows1.size());
		
		System.out.println(Calendar.getInstance().getTimeInMillis());
		System.out.println("100% working trick   :"+driver.findElement(By.xpath("//*[contains(text(),'Please wait while we are looking for other flight options for you.')]")).getText());
		
/*		wait till the particular text is invisible			*/
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'Please wait while we are looking for other flight options for you.')]")));
		
		System.out.println(Calendar.getInstance().getTimeInMillis());
		
/*		Click on the selected link 			*/
		Iterator<WebElement> itrFlight = flight.iterator();
		while(itrFlight.hasNext()) {
			element = itrFlight.next();
			
/*		Added explicit wait to wait for element to be present		*/		
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			System.out.print("Prize of the flight ticket   :"+element.findElement(By.xpath(".//span/strong")).getText());
			System.out.println("\t" +(element.findElement(By.xpath(".//following-sibling::div/a/div"))).getText());

/*		Click on the first link which is of vayama			*/			
			if(element.findElement(By.xpath(".//following-sibling::div/a/div")).getText().trim().contains("on Vayama")) {
			wait.until(ExpectedConditions.elementToBeClickable(element));	
			element.click();
			System.out.println("clicked on selected flight link");
			break;
			}
								
		}
		
/*		Get all windows handles	after clicking	*/
		Set<String> setWindows2 = new HashSet<String>();
		setWindows2 = driver.getWindowHandles();
		System.out.println("size of w2" + "\t" + setWindows2.size());
		
/*		get new window handle			*/
		setWindows2.removeAll(setWindows1);
		Iterator itrWindow = setWindows2.iterator();
		System.out.println("final size must be 1 and is "+ "\t"+setWindows2.size());
		driver.switchTo().window((String) itrWindow.next());
		
/*		Let the DOM load			*/		
//		UserLogin.waitforPageLoad(driver);
		
/*		wait till the particular text is invisible	(Implicitly waiting for page to display)		*/
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Redirecting')]")));
		System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Redirecting')]"))));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'Redirecting')]")));
		System.out.println(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'Redirecting')]"))));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Loading...')]")));
		System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Loading...')]"))));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'Loading...')]")));
		System.out.println(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'Loading...')]"))));
		
/*		Reached on the Passenger page 		*/		
		System.out.println(driver.getCurrentUrl());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='passengerGenderMale0']")));
		
		Actions action = new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver ;

		
		jse.executeScript("document.getElementById('passengerGenderMale0').checked='true';");
		jse.executeScript("document.getElementsByClassName('checkbox-radio-text')[0].click();");
		action.sendKeys(Keys.TAB).perform();
		
		actions.moveToElement((WebElement)jse.executeScript("return document.getElementById('passengerFirstName0');")).click().build().perform();
		jse.executeScript("document.getElementById('passengerFirstName0').value='Prem';");
		action.sendKeys(Keys.TAB).perform();
		
		actions.moveToElement((WebElement)jse.executeScript("return document.getElementById('passengerLastName0');")).click().build().perform();
		jse.executeScript("document.getElementById('passengerLastName0').value='Suwalka';");
		action.sendKeys(Keys.TAB).perform();
		
		element = driver.findElement(By.xpath("//input[@id='passengerDob0_ctrl']"));
		element.sendKeys("05301994");
		
/*		wait till the Next button is present and then enabled			*/
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Next')]")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Next')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Next')]")));
		
		element = driver.findElement(By.xpath("//*[contains(text(),'Next')]"));
		element.click();
		
/*		Fill the contact details			*/
		System.out.println("<b>Fill in the contact details page</b>");
				
		action.moveToElement((WebElement) jse.executeScript("return document.getElementsByClassName('Select-value-label')[0];")).click().perform();
		element = (WebElement) jse.executeScript("return document.getElementsByClassName('Select-input')[0].getElementsByTagName('Input')[0];");
		element.sendKeys("India");
		action.sendKeys(element, Keys.ARROW_DOWN).perform();
		action.sendKeys(element, Keys.ENTER).perform();
		action.sendKeys(Keys.TAB).perform();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		element = (WebElement) jse.executeScript("return document.getElementById('contactStreet')");
		action.moveToElement(element).click().build().perform();
		element.sendKeys("Bawari Ka Chok");
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.TAB).perform();
		
		element = (WebElement) jse.executeScript("return document.getElementById('contactCity')");
		action.moveToElement(element).click().build().perform();
		element.sendKeys("Tonk");
		action.sendKeys(Keys.TAB).perform();

		element = (WebElement) jse.executeScript("return document.getElementsByClassName('dropdown__trigger')[1]");
		actions.moveToElement(element).perform();
		jse.executeScript("arguments[0].click();", element);
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='dropdown__element dropdown__element--open dropdown__element--open-down']/div[@class='dropdown__options-container']/ul/child::li")));
		
		Object obj = jse.executeScript("function a() {" +
				"var state = document.getElementsByClassName('dropdown__options')[1].getElementsByTagName('li');" +
				"var i;" +
				"for(i=0;i<state.length;i++) {" +
				"var statename = state[i].innerText.toString().trim();" +
				"if(statename=='Rajasthan') {" +
				"return state[i];" +
				"break;" +
				"}}" +
				"return i;" +
				"}" +
				"return a();");

		actions.moveToElement((WebElement) obj).click().build().perform();
		jse.executeScript("arguments[0].scrollIntoView(true)", obj);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jse.executeScript("arguments[0].click()", obj);
		
		element = (WebElement) jse.executeScript("return document.getElementById('contactPostalCode')");
		action.moveToElement(element).click().build().perform();
		element.sendKeys("304024");
		action.sendKeys(Keys.TAB).perform();
		
		element = (WebElement) jse.executeScript("return document.getElementById('contactEmail')");
		action.moveToElement(element).click().build().perform();
		element.sendKeys("prem@gmail.com");
		action.sendKeys(Keys.TAB).perform();
		
		element = (WebElement) jse.executeScript("return document.getElementById('contactRepeatEmail')");
		action.moveToElement(element).click().build().perform();
		element.sendKeys("prem@gmail.com");
		action.sendKeys(Keys.TAB).perform();
		
		element = (WebElement) jse.executeScript("return document.getElementsByClassName('Select-value-label')[1]");
		action.moveToElement(element).click().build().perform();
		jse.executeScript("document.getElementsByClassName('Select-value-label')[1].innerText='India +(91)';");
		action.sendKeys(Keys.TAB).perform();
		
		element = (WebElement) jse.executeScript("return document.getElementById('contactPhoneNumberHome')");
		action.moveToElement(element).click().build().perform();
		element.sendKeys("9479754805");
		
		element = (WebElement) jse.executeScript("return document.getElementsByClassName('small-100 tiny-100 submit-button align-center')[0];");
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		element = (WebElement) jse.executeScript("return document.getElementsByClassName('small-100 tiny-100 submit-button align-center')[0];");
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Loading...')]")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'Loading...')]")));
		
		
		jse.executeScript("document.getElementsByClassName('price-container__input')[0].click();");
		jse.executeScript("document.getElementsByClassName('submit-button')[0].click();");
		
		
		//  Reached to the summary page just before the payment page
	
	}
}
