import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetElementsAndPutInXLS {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("At line 1");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//ExeFiles//Linuxgeckodriver");
		WebDriver objwD = new FirefoxDriver();
		objwD.navigate().to("https://www.flipkart.com/");
		objwD.manage().window().maximize();
		//Thread.sleep(1000);
				WebElement objWES = objwD.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[2]/a"));
				List<WebElement> objWE = objwD.findElements(By.xpath("//a"));
				System.out.println(objWES);
				//Thread.sleep(1000);
				for(WebElement we :objWE) {
					System.out.println(we.getText());
					}
				System.out.println(objWE.size());
				/* code to write into xls file */
				FileInputStream fis = new FileInputStream("F:\\IT\\EclipseWorkSpace\\Demo121\\data.xls");
				HSSFWorkbook wb = new HSSFWorkbook(fis);
				HSSFSheet sheet  = wb.getSheet("Sheet1");
				for(int i=0;i<objWE.size();i++){
				HSSFRow row = sheet.createRow(i);
				HSSFCell cell = row.createCell(0);
				String str = objWE.get(i).getText();
				cell.setCellValue(str);
				}
				FileOutputStream fos = new FileOutputStream("F:\\IT\\EclipseWorkSpace\\Demo121\\data.xls");
				
				wb.write(fos);
				
				fos.flush();
				fos.close();
				fis.close();
	}
}
