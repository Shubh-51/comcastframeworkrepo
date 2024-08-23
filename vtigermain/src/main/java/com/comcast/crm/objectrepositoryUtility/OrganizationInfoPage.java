package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerinfo;
	
	@FindBy(id="dtlview_Phone")
	private WebElement editphoneinfo;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement editorginfo;
	
	@FindBy(id="dtlview_Industry")
	private WebElement editindustrydd;
	
	@FindBy(id="dtlview_Type")
	private WebElement edittypedd;
	
	
	
	public WebElement getEditindustrydd() {
		return editindustrydd;
	}

	public WebElement getEdittypedd() {
		return edittypedd;
	}

	public WebElement getEditphoneinfo() {
		return editphoneinfo;
	}

	public WebElement getEditorginfo() {
		return editorginfo;
	}



	public WebElement getHeaderinfo() {
		return headerinfo;
	}
	
}
