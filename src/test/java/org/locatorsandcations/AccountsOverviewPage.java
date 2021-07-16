package org.locatorsandcations;

import org.base.GlobalLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsOverviewPage extends GlobalLibrary {
	
	public AccountsOverviewPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='ng-binding']")
	private WebElement accountNo_link;

	public WebElement getAccountNo_link() {
		return accountNo_link;
	}
	
	public void clickonaccountnumberlink()
	{
		click(getAccountNo_link());
	}
	

}
