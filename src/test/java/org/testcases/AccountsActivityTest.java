package org.testcases;

import java.util.Hashtable;

import org.locatorsandcations.AccountDetailsPage;
import org.locatorsandcations.AccountServicesMenuPage;
import org.locatorsandcations.AccountsOverviewPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountsActivityTest {
	
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


}
