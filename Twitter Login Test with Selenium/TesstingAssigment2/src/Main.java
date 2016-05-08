 

/**
 * @author almgwary
 * Dec 9, 2015  1:24:05 AM  
 * TesstingAssigment2    
 * Main.java
 */


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import LoginTest.ChromeLoggin;
import LoginTest.FireFoxLoggin;
import LoginTest.IELoggin;
import Reader.Exel;
import Reader.LoginItem;
import jxl.read.biff.BiffException;

import org.openqa.selenium.chrome.ChromeDriver;;

public class Main {

	 
	public static void main(String[] args) throws BiffException, IOException, InterruptedException {
		
	 
		
		// reading eamail and passwords from excel 
		Exel exel = new Exel();
		ArrayList<LoginItem> loginItems = exel.read();
		
		// opject for each brwoser
		ChromeLoggin chromeLoggin = new ChromeLoggin();
		IELoggin ieLoggin = new IELoggin();
		FireFoxLoggin fireFoxLoggin = new FireFoxLoggin();
		// loop for evry account and check it in 3 browser
		
		for(LoginItem item : loginItems){
			System.out.println( "checking.... \nName["+item.userName + "]\nEmail[" + item.password+ "]");
			
			item.pass = chromeLoggin.check(item);
			System.out.println("ChromePass["+ item.pass+"]\n--------------------------");
			item.pass = ieLoggin.check(item);
			System.out.println("IEPass["+ item.pass+"]\n--------------------------");
			item.pass = fireFoxLoggin.check(item);
			System.out.println("FireFoxPass["+ item.pass+"]\n--------------------------");
			
		}
		
		
		
	}

}
