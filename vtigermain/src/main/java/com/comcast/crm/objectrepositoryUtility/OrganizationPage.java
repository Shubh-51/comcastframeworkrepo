package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createneworgbutton;
	
	@FindBy(name="search_text")
	private WebElement searchedit;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchdd;
	
	@FindBy(name="submit")
	private WebElement searchbtn;

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getSearchedit() {
		return searchedit;
	}

	public WebElement getSearchdd() {
		return searchdd;
	}

	public WebElement getCreateneworgbutton() {
		return createneworgbutton;
	}
	
}
