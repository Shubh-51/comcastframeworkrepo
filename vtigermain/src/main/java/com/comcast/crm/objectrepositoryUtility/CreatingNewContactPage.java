package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewContactPage {
	WebDriverUtility wlib=new WebDriverUtility();
	WebDriver driver=null;
	public CreatingNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement editlastname;
	
	@FindBy(name="support_start_date")
	private WebElement editstartsupportdate;
	
	@FindBy(name="support_end_date")
	private WebElement editendsupportdate;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement lookup;
	
	@FindBy(name="search_text")
	private  WebElement editlookupsearch;
	
	@FindBy(name="search")
	private WebElement searchlookupbtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	
	public WebElement getEditlastname() {
		return editlastname;
	}

	public WebElement getEditstartsupportdate() {
		return editstartsupportdate;
	}

	public WebElement getEditendsupportdate() {
		return editendsupportdate;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public void createNewContact(String lastname) {
		editlastname.sendKeys(lastname);
		savebtn.click();
	}
	
	public WebElement getLookup() {
		return lookup;
	}

	

	public WebElement getEditlookupsearch() {
		return editlookupsearch;
	}

	public WebElement getSearchlookupbtn() {
		return searchlookupbtn;
	}

	public void createNewContactWithSupportDate(String lastname,String startdate,String enddate) {
		editlastname.sendKeys(lastname);
		editstartsupportdate.clear();
		editstartsupportdate.sendKeys(startdate);
		editendsupportdate.clear();
		editendsupportdate.sendKeys(enddate);
		savebtn.click();
	}
	
	public void createNewContactWithOrg(String lastname,String orgname) {
		editlastname.sendKeys(lastname);
		lookup.click();
		wlib.switchToTabOnURL(driver, "module=Accounts&action");
		editlookupsearch.sendKeys(orgname);
		searchlookupbtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		wlib.switchToTabOnURL(driver,"module=Contacts&action");
		savebtn.click();
	}
	
}
