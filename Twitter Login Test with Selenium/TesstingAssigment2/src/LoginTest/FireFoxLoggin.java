/**
 * 
 */
package LoginTest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Reader.LoginItem;

/**
 * @author almgwary
 * Dec 11, 2015  4:16:48 PM  
 * TesstingAssigment2  LoginTest  
 * ChromeLoggin.java
 */
public class FireFoxLoggin {
	
	 File file = new File("C:/Selenium/IE/IEDriverServer.exe");
	 WebDriver  webDriver  ;
	
	public FireFoxLoggin() {
		
	}
	
	public Boolean check ( LoginItem item) throws InterruptedException{
		
		//System.setProperty("webdriver.firefox.driver", file.getAbsolutePath());
		WebDriver  webDriver = new FirefoxDriver();
		webDriver.get("https://mobile.twitter.com/session/new");
		//System.out.println(webDriver.findElement(By.xpath("//*[@id='session[username_or_email]']")).getText()+"####");
		webDriver.findElement(By.id("session[username_or_email]")).sendKeys(item.userName);;
		webDriver.findElement(By.id("session[password]")).sendKeys(item.password);
		
		webDriver.findElement(By.id("signupbutton")).click();
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
