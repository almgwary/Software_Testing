/**
 * 
 */
package LoginTest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Reader.LoginItem;

/**
 * @author almgwary
 * Dec 11, 2015  4:16:48 PM  
 * TesstingAssigment2  LoginTest  
 * ChromeLoggin.java
 */
public class IELoggin {
	
	 File file = new File("C:/Selenium/IE/IEDriverServer.exe");
	 WebDriver  webDriver  ;
	
	public IELoggin() {
		
	}
	
	public Boolean check ( LoginItem item) throws InterruptedException{
		
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		WebDriver  webDriver = new InternetExplorerDriver();
		webDriver.get("https://mobile.twitter.com/session/new");
		//System.out.println(webDriver.findElement(By.xpath("//*[@id='session[username_or_email]']")).getText()+"####");
		webDriver.findElement(By.id("session[username_or_email]")).sendKeys(item.userName);;
		webDriver.findElement(By.id("session[password]")).sendKeys(item.password);
		
		
		webDriver.findElement(By.xpath("//*[@id='main_content']/div[1]/form/span[2]/input")).click();;
		webDriver.get("https://mobile.twitter.com/account");
		System.out.println(webDriver.getCurrentUrl());
 		if(webDriver.getCurrentUrl().toString().equals("https://mobile.twitter.com/"))
		{
			webDriver.close();
			return true ;
		}
		 
		webDriver.close();
		return false ;
	}
}
