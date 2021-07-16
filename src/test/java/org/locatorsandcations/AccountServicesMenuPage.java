package org.locatorsandcations;

import org.base.GlobalLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountServicesMenuPage extends GlobalLibrary {
	
	public AccountServicesMenuPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Transfer Funds']")
	private WebElement fundsTransfer_link;
	
	@FindBy(xpath="//a[text()='Accounts Overview']")
	private WebElement accountsOverview_link;

	public WebElement getFundsTransfer_link() {
		return fundsTransfer_link;
	}
	
	public WebElement getAccountsOverview_link() {
		return accountsOverview_link;
	}
	
	public void clickOnFundsTransferLink()
	{
		click(getFundsTransfer_link());
	}
	
	public void clicOnAccountOverviewLink()
	{
		click(getAccountsOverview_link());
	}
	


}
