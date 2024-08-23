package com.crm.comcast.testngassert.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass1;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryUtility.ContactInfoPage;
import com.comcast.crm.objectrepositoryUtility.ContactPage;
import com.comcast.crm.objectrepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OrganizationPage;

import junit.framework.Assert;
/**
 * @author shubh
 */
@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class ContactTest extends BaseClass1 {
	@Test(groups={"smoketest","regressiontest"})
	public void createContactTest() throws EncryptedDocumentException, IOException {
		
		/* Step 1 :navigate to contact module*/
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to contact module");
		HomePage hp=new HomePage(driver);
		hp.getContactlink().click();
		
		/* Step 2: click on new Create button present on contact page*/
		
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to create contact button");

		ContactPage cp=new ContactPage(driver);
		cp.getCreatecontactbtn().click();
		
		/* Step 3:Create New Contact b/e you are in new Create contact page*/

		UtilityClassObject.getTest().log(Status.INFO,"Navigate to createnewcontact button");
		
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"Read the data from ExcelSheet and concatenate random number ");
		/*Step 4:Read the data from excel sheet */
		String conname=elib.getDataFromExcelFile("contact", 1, 3)+jlib.getRandomNumber();
		cncp.createNewContact(conname);
		
		/* Step5:Verify contact name in Contact info page header*/
		
		UtilityClassObject.getTest().log(Status.INFO,conname+ "create a new contact");
		ContactInfoPage cip=new ContactInfoPage(driver);
		String headerinfo=cip.getHeaderinfo().getText();
		boolean status=headerinfo.contains(conname);
		
		Assert.assertEquals(status,true);
		
		//Assert.assertTrue(status);
		
		String actconname=cip.getEditlastname().getText();
		Assert.assertEquals(actconname,conname);
		
	}
	
	@Test(groups="regressiontest")
	public void createContactWithSupportDateTest() throws EncryptedDocumentException, IOException {
		
		/* Step 1:Read the data From ExcelSheet */
		String conname=elib.getDataFromExcelFile("contact",1, 2)+jlib.getRandomNumber();
		/* Step 2:Navigate to contact module */
		HomePage hp=new HomePage(driver);
		hp.getContactlink().click();
		
		/* Step 2:click on contact button(plus icon) */
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreatecontactbtn().click();
		
		/* Step 3:enter all the details and create new contact with support date. */
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		String startdate=jlib.getSystemDateDDMMYYYY();
		String enddate=jlib.getRequriedDateYYYYMMDD(30);
		cncp.createNewContactWithSupportDate(conname, startdate, enddate);
		
		/* Step4:verify all the details */
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String headerinfo=cip.getHeaderinfo().getText();
		boolean status=headerinfo.contains(conname);
		SoftAssert sa=new SoftAssert();
		
		sa.assertTrue(status);
		String actstartdate=cip.getEditstartdate().getText();
		String actenddate=cip.getEditenddate().getText();
		sa.assertEquals(actstartdate, startdate);
		sa.assertEquals(actenddate, enddate);
		sa.assertAll();
		
		
	}
	@Test(groups="regressiontest")
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		/* Step1:navigate to the Organization module */
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();
		
		/* Step2:click on organization button(plus icon)*/
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateneworgbutton().click();
		
		
		/* Step3:create new organization page*/
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		/* Step 4:read the data from excelSheet */
		String orgname=elib.getDataFromExcelFile("contact", 7, 3).toString()+jlib.getRandomNumber();
		cnop.createOrg(orgname);
		
		/* Step 5:click on contact */
		Thread.sleep(2000);
		hp.getContactlink().click();
		
		/* Step 6:click on the contact button(plus icon) */
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreatecontactbtn().click();
		
		/* Step 7:Enter all the details */
		
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		String conname=elib.getDataFromExcelFile("contact", 7, 2)+jlib.getRandomNumber();
		cncp.createNewContactWithOrg(conname, orgname);
		
		/* Step 8: verify */
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String headerinfo=cip.getHeaderinfo().getText();

		boolean status=headerinfo.contains(conname);
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(status);
		String actorgname=cip.getEditorgname().getText().trim();
		sa.assertEquals(actorgname,orgname);
		
		
	}
}
