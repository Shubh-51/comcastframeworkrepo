package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganizationPage {
	WebDriverUtility wlib=new WebDriverUtility();
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgnameedit;
	
	@FindBy(id="phone")
	private WebElement phoneedit;
	
	@FindBy(name="industry")
	private WebElement indusrtydd;
	
	@FindBy(name="accounttype")
	private WebElement typedd;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	public WebElement getOrgnameedit() {
		return orgnameedit;
	}
	
	

	public WebElement getPhoneedit() {
		return phoneedit;
	}



	public WebElement getTypedd() {
		return typedd;
	}



	public WebElement getSavebtn() {
		return savebtn;
	}
	public void createOrg(String orgname) {
		orgnameedit.sendKeys(orgname);
		savebtn.click();
	}
	
	public void createOrg(String orgname,String phoneno) {
		orgnameedit.sendKeys(orgname);
		phoneedit.sendKeys(phoneno);
		savebtn.click();
	}
	
	public void createOrg(String orgname,String indusrty,String type) {
		orgnameedit.sendKeys(orgname);
		wlib.select(indusrtydd,indusrty);
		wlib.select(typedd, type);
		savebtn.click();
	}
	
}
