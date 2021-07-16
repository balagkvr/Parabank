package org.locatorsandcations;

import org.base.GlobalLibrary;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends GlobalLibrary {

	public RegistrationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="customer.firstName")
	private WebElement firstname_txt;
	
	@FindBy(id="customer.lastName")
	private WebElement lastname_txt;
	
	@FindBy(id="customer.address.street")
	private WebElement address_txt;
	
	@FindBy(id="customer.address.city")
	private WebElement city_txt;
	
	@FindBy(id="customer.address.state")
	private WebElement state_txt;
	
	@FindBy(id="customer.address.zipCode")
	private WebElement zipcode_txt;
	
	@FindBy(id="customer.phoneNumber")
	private WebElement phone_txt;
	
	@FindBy(id="customer.ssn")
	private WebElement ssn_txt;
	
	@FindBy(id="customer.username")
	private WebElement username_txt;
	
	@FindBy(id="customer.password")
	private WebElement password_txt;
	
	@FindBy(id="repeatedPassword")
	private WebElement confirmPassword_txt;
	
	@FindBy(xpath="//input[@value='Register']")
	private WebElement register_btn;
	
	public WebElement getFirstname_txt() {
		return firstname_txt;
	}

	public WebElement getLastname_txt() {
		return lastname_txt;
	}

	public WebElement getAddress_txt() {
		return address_txt;
	}

	public WebElement getCity_txt() {
		return city_txt;
	}

	public WebElement getState_txt() {
		return state_txt;
	}

	public WebElement getZipcode_txt() {
		return zipcode_txt;
	}

	public WebElement getPhone_txt() {
		return phone_txt;
	}

	public WebElement getSsn_txt() {
		return ssn_txt;
	}

	public WebElement getUsername_txt() {
		return username_txt;
	}

	public WebElement getPassword_txt() {
		return password_txt;
	}

	public WebElement getConfirmPassword_txt() {
		return confirmPassword_txt;
	}
	
	public WebElement getRegister_btn()
	{
		return register_btn;
	}	
	
	public void registerUser(String firstname, String lastname, String Address, String City, String State, String ZipCode, String Phone, String SSN, String Username, String Password, String ConfirmPassword) throws InterruptedException
	{		
		typeInput(getFirstname_txt(), firstname);
		typeInput(getLastname_txt(), lastname);
		typeInput(getAddress_txt(), Address);
		typeInput(getCity_txt(), City);
		typeInput(getState_txt(), State);
		typeInput(getZipcode_txt(), ZipCode);
		typeInput(getPhone_txt(), Phone);
		typeInput(getSsn_txt(), SSN);
		typeInput(getUsername_txt(), Username);
		typeInput(getPassword_txt(), Password);
		typeInput(getConfirmPassword_txt(), ConfirmPassword);
		Thread.sleep(2000);
		click(getRegister_btn());	
	}
}
