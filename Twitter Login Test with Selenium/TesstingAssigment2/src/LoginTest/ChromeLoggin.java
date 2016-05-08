/**
 * 
 */
package LoginTest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Reader.LoginItem;

/**
 * @author almgwary
 * Dec 11, 2015  4:16:48 PM  
 * TesstingAssigment2  LoginTest  
 * ChromeLoggin.java
 */
public class ChromeLoggin {
	
	 File file = new File("C:/Selenium/Chrome/chromedriver.exe");
	 WebDriver  webDriver  ;
	
	public ChromeLoggin() {
		
	}
	
	public Boolean check ( LoginItem item) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		WebDriver  webDriver = new ChromeDriver();
		webDriver.get("https://mobile.twitter.com/session/new");
		//System.out.println(webDriver.findElement(By.xpath("//*[@id='session[username_or_email]']")).getText()+"####");
		webDriver.findElement(By.id("session[username_or_email]")).sendKeys(item.userName);;
		webDriver.findElement(By.id("session[password]")).sendKeys(item.password);
		webDriver.findElement(By.id("signupbutton")).click();
		webDriver.get("https://mobile.twitter.com/account");
		//System.out.println(webDriver.getCurrentUrl());
		//System.out.println(webDriver.findElement(By.xpath("//span[contains(text(), 'Amr Abd-Alaziz')]")).getText());
		if(webDriver.getCurrentUrl().toString().equals("https://mobile.twitter.com/account"))
		{
			webDriver.close();
			return true ;
		}
		 
		
		webDriver.close();
		return false ;
	}
}
