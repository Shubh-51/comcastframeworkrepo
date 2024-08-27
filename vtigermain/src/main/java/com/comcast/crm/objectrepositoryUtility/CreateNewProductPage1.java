package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage1 {
WebDriver driver=null;
	
	public CreateNewProductPage1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

	
	@FindBy(name="productname")
	private WebElement editProductName;

	public WebElement getEditProductName() {
		return editProductName;
	}
	
	

	@FindBy(name="discontinued")
	private WebElement editCheckbox;

	public WebElement getEditCheckbox() {
		return editCheckbox;
	}

	
}
