package org.locatorsandcations;

import org.base.GlobalLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDetailsPage extends GlobalLibrary {

	public AccountDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="month")
	private WebElement activityPeriod_dd;
	
	@FindBy(id="transactionType")
	private WebElement Type_dd;
	
	@FindBy(xpath="//input[@value='Go']")
	private WebElement go_btn;
	
	@FindBy(xpath="//table[@id='transactionTable']/tbody/tr[1]/td[3]")
	private WebElement transactionTable;

	public WebElement getActivityPeriod_dd() {
		return activityPeriod_dd;
	}

	public WebElement getType_dd() {
		return Type_dd;
	}

	public WebElement getGo_btn() {
		return go_btn;
	}

	public WebElement getTransactionTable() {
		return transactionTable;
	}
	
	public String verifyaccountactivity(String activityPeriod, String Type)
	{
		selectByText(getActivityPeriod_dd(), activityPeriod);
		selectByText(getType_dd(), Type);
		click(getGo_btn());
		return getTransactionTable().getText();
	}
}
