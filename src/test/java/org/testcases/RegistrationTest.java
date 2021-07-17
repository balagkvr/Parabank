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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTest extends GlobalLibrary {

	Properties prop;
	FileInputStream fis;

	@BeforeClass
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

	@Test(priority = 1, dataProviderClass = org.utilities.TestUtils.class, dataProvider = "dp")
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

	@Test(priority = 2, dataProviderClass = org.utilities.TestUtils.class, dataProvider = "dp")
	public void fundTransfer(Hashtable<String, String> data) throws InterruptedException {

		System.out.println("inside funds transfer test method");
		AccountServicesMenuPage acs = new AccountServicesMenuPage();
		acs.clickOnFundsTransferLink();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@ng-if='showForm']/h1")).getText(),"Transfer Funds");
		Thread.sleep(2000);

		FundsTransferPage ft = new FundsTransferPage();		
		ft.enterAmount(data.get("Amount"));
		//Thread.sleep(2000);

		ft.clickOnTransfer();
		//Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Transfer Complete!')]")).getText()
				.equals("Transfer Complete!"), "Fund transfer not successful");
	}

	@Test(priority = 3, dataProviderClass = org.utilities.TestUtils.class, dataProvider = "dp")
	public void accountActivity(Hashtable<String, String> data) throws InterruptedException {

		System.out.println("inside account activity test method");
		AccountServicesMenuPage acs = new AccountServicesMenuPage();
		acs.clicOnAccountOverviewLink();
		Thread.sleep(2000);

		AccountsOverviewPage ao = new AccountsOverviewPage();
		ao.clickonaccountnumberlink();
		Thread.sleep(2000);

		AccountDetailsPage adp = new AccountDetailsPage();
		String amount = adp.verifyaccountactivity(data.get("ActivityPeriod"),data.get("Type"));
		String amt = amount.substring(1, 4);
		System.out.println("amount activity seen is " + amt);

		Assert.assertEquals(amt, "120", "Fund transfer and account activity not matching");

	}

	@AfterClass
	public void teardown() {
		driver.close();
	}
}