package Travle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfileDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*  To make Logged in				*/
		UserLogin.login();	
		
/*  Create driver and element reference for driver and element variable	respectively		*/
		WebDriver driver = UserLogin.driver;
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = UserLogin.element;
		
/*		To create a log file				*/		
		DOMConfigurator.configure(".\\ConfigurationFiles\\log4j.xml");
		Log.startTestCase("ProfileDetails");

/*		To capture screenshot				*/		
		UserLogin.takeScreenshot("LoginPage");
		
/*		continue after Login by clicking on My Profile			*/
		element = driver.findElement(By.xpath("//a[@href='#profile']"));
		element.click();
						
/* 		Capture profile details				*/
		String First_Name = driver.findElement(By.xpath("//input[@name='firstname']")).getAttribute("value");
		String Last_Name = driver.findElement(By.xpath("//input[@name='lastname']")).getAttribute("value");
		String Phone = driver.findElement(By.xpath("//input[@name='phone']")).getAttribute("value");
		String Email = driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value");
		String Address1 = driver.findElement(By.xpath("//input[@name='address1']")).getAttribute("value");
		String Address2 = driver.findElement(By.xpath("//input[@name='address2']")).getAttribute("value");
		String City = driver.findElement(By.xpath("//input[@name='city']")).getAttribute("value");
		String State = driver.findElement(By.xpath("//input[@name='state']")).getAttribute("value");
		String Zip = driver.findElement(By.xpath("//input[@name='zip']")).getAttribute("value");
		Select select = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		String country = select.getFirstSelectedOption().getText();

		Log.info("Profile page is displayed");
		UserLogin.takeScreenshot("ProfilePage");
		
/* 		create header array for heading of captured details			*/
		String[] header = new String[10];
		header[0]="First_Name";
		header[1]="Last_Name";
		header[2]="Phone";
		header[3]="Email";
		header[4]="Address1";
		header[5]="Address2";
		header[6]="City";
		header[7]="State";
		header[8]="Zip";
		header[9]="country";
		
/*		Put the captured details in the details[]			*/
		String[] details = new String[10];
		details[0] = First_Name; 
		details[1] = Last_Name; 
		details[2] = Phone;
		details[3] = Email;
		details[4] = Address1;
		details[5] = Address2;
		details[6] = City;
		details[7] = State;
		details[8] = Zip;
		details[9] = country;
		for(String str : details) {
			System.out.println(str);
		}
		
/*		Create xls file	and write captured values and header			*/
		File file = new File("F:\\IT\\EclipseWorkSpace\\Demo121\\Data\\data.xls");
		FileInputStream inputStream = null;
		try {
			inputStream	 = new FileInputStream(file);
			HSSFWorkbook workbook = null;
			workbook = new HSSFWorkbook(inputStream);
			HSSFSheet sheet = workbook.getSheet("Sheet2");
			int index = workbook.getSheetIndex(sheet);
			workbook.removeSheetAt(index);
			sheet = workbook.createSheet("Sheet2");
			
			for(int i = 0; i<1; i++)	{
				HSSFRow row = sheet.createRow(i);
				for(int j = 0; j<header.length; j++) {
					HSSFCell cell = row.createCell(j);
					cell.setCellValue(header[j]);
				}
			}
			
			for(int i = 1; i<2; i++)	{
				HSSFRow row = sheet.createRow(i);
				for(int j = 0; j<details.length; j++) {
					HSSFCell cell = row.createCell(j);
					cell.setCellValue(details[j]);
				}
			}
			FileOutputStream outputStream = null;
			outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
			inputStream.close();
			System.out.println("Reached here");
		}
			catch(Exception e) {
				System.out.println(e.getStackTrace());
			}
	}

}
