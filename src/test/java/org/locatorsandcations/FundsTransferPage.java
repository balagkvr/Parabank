package org.locatorsandcations;

import org.base.GlobalLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundsTransferPage extends GlobalLibrary{
	
	public FundsTransferPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="amount")
	private WebElement amount_txt;
	
	@FindBy(xpath="//input[@value='Transfer']")
	private WebElement transfer_btn;
	
	public WebElement getAmount_txt() {
		return amount_txt;
	}
	
	public WebElement getTransfer_btn() {
		return transfer_btn;
	}
	
	public void enterAmount(String amount)
	{
		typeInput(amount_txt, amount);
	}
	
	public void clickOnTransfer()
	{
		click(getTransfer_btn());
	}
}