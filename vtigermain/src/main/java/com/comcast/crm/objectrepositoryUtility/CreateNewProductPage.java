package com.comcast.crm.objectrepositoryUtility;

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/Shubh-51/comcastframeworkrepo.git
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
	
<<<<<<< HEAD
	
	@FindBy(name="productname")
	private WebElement editProductName;

	public WebElement getEditProductName() {
		return editProductName;
	}
	
	
=======
	@FindBy(name="discontinued")
	private WebElement editCheckbox;

	public WebElement getEditCheckbox() {
		return editCheckbox;
	}
>>>>>>> branch 'master' of https://github.com/Shubh-51/comcastframeworkrepo.git
	
}
	

