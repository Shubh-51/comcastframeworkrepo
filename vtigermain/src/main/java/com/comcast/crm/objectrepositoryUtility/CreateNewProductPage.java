package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	WebDriver driver=null;
	
	public CreateNewProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="discontinued")
	private WebElement editCheckbox;

	public WebElement getEditCheckbox() {
		return editCheckbox;
	}
	
	
}
