package org.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalLibrary {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}
	
	public static void loadUrl(String url)
	{
		driver.get(url);
		maximize();
		implicitwait();
	}

	
	public static void maximize()
	{
		driver.manage().window().maximize();
	}
	
	public static void implicitwait()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void typeInput(WebElement element, String data)
	{
		element.sendKeys(data);
	}
	
	public static void click(WebElement element)
	{
		element.click();
	}
	
	public void clickJS(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public void selectByText(WebElement element, String data)
	{
		new Select(element).selectByVisibleText(data);
	}
}
