package org.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

import org.base.GlobalLibrary;
import org.locatorsandcations.AccountDetailsPage;
import org.locatorsandcations.AccountServicesMenuPage;
import org.locatorsandcations.AccountsOverviewPage;
import org.locatorsandcations.FundsTransferPage;
import org.locatorsandcations.HomePage;
import org.locatorsandcations.RegistrationPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTest extends GlobalLibrary {

	Properties prop;
	FileInputStream fis;

	@BeforeSuite
	public void setup() throws IOException, InterruptedException {
		getDriver();
		prop = new Properties();
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\data.properties");
		prop.load(fis);
		String url = prop.getProperty("url");
		loadUrl(url);
		System.out.println("url loaded");
	}

	@Test(dataProviderClass = org.utilities.TestUtils.class, dataProvider = "dp")
	public void registration(Hashtable<String, String> data) throws InterruptedException {

		if (!data.get("runmode").equals("Y")) {
			throw new SkipException("skipping the test case as the runmode for data set is NO");
		}

		System.out.println("inside registration test method");
		HomePage hp = new HomePage();
		hp.clickOnRegisterLink();

		RegistrationPage rp = new RegistrationPage();
		rp.registerUser(data.get("firstname"), data.get("lastname"), data.get("Address"), data.get("City"),
				data.get("State"), data.get("ZipCode"), data.get("Phone"), data.get("SSN"), data.get("Username"),
				data.get("Password"), data.get("ConfirmPassword"));

		Assert.assertTrue(
				driver.findElement(By.xpath("//h1[contains(text(),'Welcome')]")).getText().contains("Welcome"),
				"Welcome message missing in landing page after making registration");
		Assert.assertEquals(prop.getProperty("register"), driver.getCurrentUrl(),
				"URL of landing page after registration is not matching");
		Assert.assertTrue(driver.getTitle().equals("ParaBank | Customer Created"),
				"invalid details passed to registration page");

	}

	@AfterSuite
	public void teardown() {
		driver.close();
	}
}