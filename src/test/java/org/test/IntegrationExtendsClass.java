package org.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntegrationExtendsClass extends ExcelIntegration{
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse\\Practise\\ChromeServer\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	
	WebElement userName = driver.findElement(By.id("email"));
	userName.sendKeys(getData(1,0));
	
	WebElement passWord = driver.findElement(By.id("pass"));
	passWord.sendKeys(getData(1,1));
	}

}
