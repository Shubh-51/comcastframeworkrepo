package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver=null;
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createcontactbtn;
	
	public WebElement getCreatecontactbtn() {
		return createcontactbtn;
	}
	
}
