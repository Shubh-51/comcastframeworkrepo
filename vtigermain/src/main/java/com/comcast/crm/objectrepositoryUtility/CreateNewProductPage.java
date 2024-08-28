package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	WebDriver driver=null;
	public CreateNewProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createNewProductBtn;
	

	@FindBy(name="search_text")
	private WebElement editSearchTextfield;
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createproductbtn;
	

	
	public WebElement getCreateNewProductBtn() {
		return createNewProductBtn;
	}


	public WebElement getEditSearchTextfield() {
		return editSearchTextfield;
	}


	public WebElement getCreateproductbtn() {
		return createproductbtn;
	}
}
