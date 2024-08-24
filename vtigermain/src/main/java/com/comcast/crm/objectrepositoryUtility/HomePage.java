package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Organizations")
	private WebElement orglink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactlink;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement productLink;
	
	public WebElement getMorelink() {
		return morelink;
	}
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutlink;
	
	public WebElement getAdminimg() {
		return adminimg;
	}
	
	

	public WebElement getProductLink() {
		return productLink;
	}



	public WebElement getSignoutlink() {
		return signoutlink;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}
	@FindBy(linkText="More")
	private WebElement morelink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignlink;
	
	
	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}
	
	public void NavigateToCampaignPage() {
		Actions act=new Actions(driver);
		act.moveToElement(morelink).perform();
		campaignlink.click();
		
	}
	
	public void logout() {
		Actions act=new Actions(driver);
		act.moveToElement(adminimg).perform();
		signoutlink.click();
	}
	
}
