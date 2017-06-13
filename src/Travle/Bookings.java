package Travle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bookings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*  To make Logged in				*/
		UserLogin.login();

/*  Create driver and element reference for driver and element variable	respectively		*/
		WebDriver driver = UserLogin.driver;
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = UserLogin.element;

/* 		You have been landed to the booking page				*/

/*		Total count of number of bookings						*/		
		List<WebElement> elements = new ArrayList<WebElement>();		
		elements = driver.findElements(By.xpath("//*[@id='bookings']/child::div[@class='row']"));
		int size = elements.size();
		System.out.println("Total no. of bookings: "+elements.size());
		
/* 		Total count of paid, unpaid,reserved and cancelled bookings							*/
		elements.addAll(size, driver.findElements(By.xpath(".//*[@id='bookings']/child::div[@class='row']/div[3]/h5/strong/span")));
		ListIterator<WebElement> liItr = elements.listIterator(size);
		int paidCount = 0;
		int ReservedCount = 0;
		int UnpaidCount = 0;
		int CancelledCount = 0;		
		String status = "";
		while(liItr.hasNext()) {
			status = liItr.next().getText();
			switch(status) {
			case "Paid" :  paidCount++;
			break;
			case "Reserved" : ReservedCount++;
			break;
			case "Unpaid" : UnpaidCount++;
			break;
			case "Cancelled" : CancelledCount++;
			break;
			}
		}
		System.out.println("total no. Paid booking: " +paidCount);	
		System.out.println("total no. of Reserved booking: " +ReservedCount);
		System.out.println("total no. of Unpaid booking: " +UnpaidCount);
		System.out.println("total no of Cancelled booking: " +CancelledCount);
		
	}

}
