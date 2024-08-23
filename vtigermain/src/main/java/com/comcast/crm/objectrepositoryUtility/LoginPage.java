package com.comcast.crm.objectrepositoryUtility;
/**
 * @author shubh
 * 
 * Contains LoginPage Element & Business Library like login to application
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	//rule1:create a Separate java Class
	//rule2:Object creation
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement usernameedit;
	
	@FindBy(name="user_password")
	private WebElement passwordedit;
	
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	//rule3:Object Initialization (this is done in test Script)
	//rule4:Object Encapsulation

	public WebElement getUsernameedit() {
		return usernameedit;
	}

	public WebElement getPasswordedit() {
		return passwordedit;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	//rule5:Object utilization
	
/**
 * login to application based on url ,password ,username argument
 * @param url
 * @param username
 * @param password
 * 
 */
	public void loginToApp(String url,String username,String password) {
		windowMaximize(driver);
		waitForPageToLoad(driver);
		driver.get(url);
		usernameedit.sendKeys(username);
		passwordedit.sendKeys(password);
		loginbutton.click();
	}
}
