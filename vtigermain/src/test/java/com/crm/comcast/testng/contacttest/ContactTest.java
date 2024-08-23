package com.crm.comcast.testng.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;

import org.testng.annotations.Test;


import com.comcast.crm.basetest.BaseClass1;
import com.comcast.crm.objectrepositoryUtility.ContactInfoPage;
import com.comcast.crm.objectrepositoryUtility.ContactPage;
import com.comcast.crm.objectrepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OrganizationPage;

public class ContactTest extends BaseClass1{
	@Test(groups={"smoketest","regressiontest"})
	public void createContactTest() throws EncryptedDocumentException, IOException {
		
		//navigate to contact module
		
		HomePage hp=new HomePage(driver);
		hp.getContactlink().click();
		
		//click on new Create button present on contact page
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreatecontactbtn().click();
		
		//Create New Contact b/e you are in new Create contact page
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		
		String conname=elib.getDataFromExcelFile("contact", 1, 2)+jlib.getRandomNumber();
		cncp.createNewContact(conname);
		
		//Verify contact name in Contact info page header
		ContactInfoPage cip=new ContactInfoPage(driver);
		String headerinfo=cip.getHeaderinfo().getText();
		
		if(headerinfo.contains(conname)) {
			System.out.println(conname+" is created======PASS");
		}else {
			System.out.println(conname+"is not created=======FAIL");
		}
		String actconname=driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actconname.equals(conname)) {
			System.out.println(conname+" is verifed====PASS");
		}else {
			System.out.println(conname+" is not verifed====FAIL");
		}
	}
	
	@Test(groups="regressiontest")
	public void createContactWithSupportDateTest() throws EncryptedDocumentException, IOException {
		
		//Navigate to contact module
		String conname=elib.getDataFromExcelFile("contact",1, 2)+jlib.getRandomNumber();;
		HomePage hp=new HomePage(driver);
		hp.getContactlink().click();
		
		//click on contact button(plus icon)
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreatecontactbtn().click();
		
		//enter all the details and create new contact with support date.
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		String startdate=jlib.getSystemDateDDMMYYYY();
		String enddate=jlib.getRequriedDateYYYYMMDD(30);
		cncp.createNewContactWithSupportDate(conname, startdate, enddate);
		
		//verify all the details 
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String headerinfo=cip.getHeaderinfo().getText();
		if(headerinfo.contains(conname)) {
			System.out.println(conname+" is created======PASS");
		}else {
			System.out.println(conname+"is not created=======FAIL");
		}
		String actstartdate=cip.getEditstartdate().getText();
		String actenddate=cip.getEditenddate().getText();
		if(actstartdate.equals(startdate) && actenddate.equals(enddate)) {
			System.out.println(startdate+" is verified =====PASS");
			System.out.println(enddate+" is verified =====PASS");
		}else {
			System.out.println(startdate+" is not verified =====FAIL");
			System.out.println(enddate+" is not verified =====FAIL");
		}
		
	}
	@Test(groups="regressiontest")
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		//navigate to the Organization module
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();
		
		//click on organization button(plus icon)
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateneworgbutton().click();
		
		
		//create new organization page
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		String orgname=elib.getDataFromExcelFile("contact", 7, 3).toString()+jlib.getRandomNumber();
		cnop.createOrg(orgname);
		Thread.sleep(2000);
		//click on contact
		hp.getContactlink().click();
		
		//click on the contact button(plus icon)
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreatecontactbtn().click();
		
		//Enter all the details
		
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		String conname=elib.getDataFromExcelFile("contact", 7, 2)+jlib.getRandomNumber();
		cncp.createNewContactWithOrg(conname, orgname);
		
		//verify
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String headerinfo=cip.getHeaderinfo().getText();

		if(headerinfo.contains(conname)) {
			System.out.println(conname+" is created======PASS");
		}else {
			System.out.println(conname+"is not created=======FAIL");
		}
		String actorgname=cip.getEditorgname().getText();
		
		if(actorgname.trim().equals(orgname)) {
			System.out.println(orgname+" is verifed====PASS");
		}else {
			System.out.println(orgname+" is not verifed====FAIL");
		}
		
	}
	
		
	
}
