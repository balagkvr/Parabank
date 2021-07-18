package org.testcases;

import java.util.Hashtable;

import org.base.GlobalLibrary;
import org.locatorsandcations.AccountServicesMenuPage;
import org.locatorsandcations.FundsTransferPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FundsTransferTest extends GlobalLibrary{
	
	@Test(dataProviderClass = org.utilities.TestUtils.class, dataProvider = "dp")
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

}
