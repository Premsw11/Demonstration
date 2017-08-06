package DataliciousTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;




public class Assignment {

	public static void main(String args[]) throws FileNotFoundException {

		/*   definition of Task 1 is started here  */
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//ExeFiles//Linuxchromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
		element.sendKeys("Datalicious");
		element = driver.findElement(By.xpath("//input[@name='btnK']"));
		element.submit();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name='btnK']")));
		element = driver.findElement(By.xpath("//*[@class='srg']/div[1]/div[1]/div[1]/h3/a"));
		element.click();
		System.out.println("Homepage of Datalicious is displayed");

		/*   definition of Task 1 is completed  here  */


		/*   definition of Task 2 is started  here  */

		// definition to make webDriver wait till the google-analytics and dc.optima calls finishes
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Boolean flag1 = false;
		while(flag1 != true) {
			flag1 = (Boolean) js.executeScript("function toFinishGoogleCalls() {" +
					"var len1 = 0;" +
					"var len2 = 0;" +
					"var a = document.scripts;" +
					"var doc = [];" +
					"for(var i = 0; i < a.length; i++) {" +
					"	if(a[i].src.includes('google-analytics')) {" +
					"		doc.push(a[i].src); }" +
					"}" +
					"len1 = doc.length;" +
					"" +
					"var b = window.performance.getEntries();" +
					"var perf = [];" +
					"for(var i = 0; i < b.length; i++) {" +
					"	if(b[i].name.includes('google-analytics')) {" +
					"		perf.push(b[i].name); }" +
					"}" +
					"len2 = perf.length;" +
					"if(len2 > len1) {" +
					"	return true;" +
					"}" +
					"else {" +
					"	return false;" +
					"}" +
					"}" +
					"return toFinishGoogleCalls()");
		}
		
		Boolean flag2 = false;
		while(flag2 != true) {
			flag2 = (Boolean) js.executeScript("function toFinishOptimaCalls() {" +
                    "var len1 = 0;" +
                    "var len2 = 0;" +
                    "var a = document.scripts;" +
                    "var doc = [];" +
                    "for(var i = 0; i < a.length; i++) {" +
                    "   if(a[i].src.includes('dc.optima')) {" +
                    "       doc.push(a[i].src); }" +
                    "}" +
                    "len1 = doc.length;" +
                    "" +
                    "var b = window.performance.getEntries();" +
                    "var perf = [];" +
                    "for(var i = 0; i < b.length; i++) {" +
                    "   if(b[i].name.includes('dc.optima')) {" +
                    "       perf.push(b[i].name); }" +
                    "}" +
                    "len2 = perf.length;" +
                    "if(len2 > len1) {" +
                    "   return true;" +
                    "}" +
                    "else {" +
                    "   return false;" +
                    "}" +
                    "}" +
                    "return toFinishOptimaCalls()");
		}



		ArrayList<String> p = (ArrayList<String>)js.executeScript("function myFunction() {" +
				"    var sc = window.performance.getEntries();" +
				"    var ep = [];" +
				"    for (var i = 0; i < sc.length; i++) {" +
				"        if (sc[i].name.includes('google-analytics')) {" +
				"            ep.push(sc[i].name);" +
				"        }" +
				"        if (sc[i].name.includes('dc.optimahub.com')) {" +
				"            ep.push(sc[i].name);" +
				"        }" +
				"    }" +
				"    return ep;" +
				"}" +
				"return myFunction();" );

		System.out.println("value of dt is "+p);
		String googleAnalyticsEP = null;
		String dcOptimaEP = null;
		for(int i = 0; i < p.size(); i++) {
			if(p.get(i).contains("google-analytics")) {
				if(p.get(i).contains("dt") && p.get(i).contains("dp")) {
					googleAnalyticsEP = p.get(i);
				}
				else if(p.get(i).contains("dt") || p.get(i).contains("dp")) {
					googleAnalyticsEP = p.get(i);
				}
			}
			else if(p.get(i).contains("dc.optimahub.com")) {
				if(p.get(i).contains("?")) {
					dcOptimaEP = p.get(i);
				}
			}
		}
		System.out.println("Value of google analytics endpoint is "+ googleAnalyticsEP);
		System.out.println("Value of dcOptimaEP  endpoint is "+ dcOptimaEP);

		/*   definition of Task 2 is completed  here  */


		/*   definition of Task 3 is started here  *///

		String dt = null;
		String dp = null;
		if(googleAnalyticsEP.contains("dt")) {
			dt = googleAnalyticsEP.split("dt")[1].split("&")[0];
		}
		if(googleAnalyticsEP.contains("dp")) {
			dp = googleAnalyticsEP.split("dp")[1].split("&")[0];
		}

		System.out.println("value of dt is "+dt);
		System.out.println("value of dp is "+dp);

		//Write into the CSV file

		PrintWriter pw = new PrintWriter(new File(System.getProperty("user.dir")+"//Data//Endpoint.csv"));
		StringBuilder sb = new StringBuilder();
		sb.append("dt");
		sb.append(",");
		sb.append("dp");
		sb.append("\n");
		sb.append(dt);
		sb.append(",");
		sb.append(dp);
		pw.write(sb.toString());
		pw.close();
		System.out.println("writing in the CSV file is done");


		/*   definition of Task 3 is completed  here  */
	}
}