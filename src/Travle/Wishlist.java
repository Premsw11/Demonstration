package Travle;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wishlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*  To make Logged in				*/
		UserLogin.login();
		
/*  Create driver and element reference for driver and element variable	respectively		*/
		WebDriver driver = UserLogin.driver;
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = UserLogin.element;

/*		continue after Login by clicking on Wishlist			*/
		element = driver.findElement(By.xpath("//a[@href='#wishlist']"));
		element.click();
		
/* 		All the items of Wishlist added travel						*/		
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='wishlist']/div/child::div"));
		System.out.println("Total count in wishlist:" +  elements.size());

		Iterator<WebElement> itrWishlist = elements.iterator();
		while(itrWishlist.hasNext()) {
			System.out.println(itrWishlist.next().getAttribute("id"));
		
		}
						
/*		Counter i is added in the xpath				*/		
		System.out.println("Names of the item added in the Wishlist");
		for(int i = 1; i<=elements.size(); i++) {
			String h1 = "//*[@id='wishlist']/div/div[";
			String l1 = "]/div[1]/a/b";
			String path = h1+i+l1;
			
/*    	Wait until text is present					*/			
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.findElement(By.xpath(path)).getText().length()!=0;
				}
			});
	
			String wishlistItemName = driver.findElement(By.xpath(path)).getText();
			System.out.println(wishlistItemName);
		}
	}

}
