package org.locatorsandcations;

import org.base.GlobalLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends GlobalLibrary {
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement username_txt;
	
	@FindBy(name="password")
	private WebElement password_txt;
	
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement submit_btn;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement register_link;
	
	public WebElement getUsername_txt() {
		return username_txt;
	}

	public WebElement getPassword_txt() {
		return password_txt;
	}

	public WebElement getSubmit_btn() {
		return submit_btn;
	}

	public WebElement getRegister_link() {
		return register_link;
	}
	
	public void clickOnRegisterLink()
	{
		click(getRegister_link());
	}
}
