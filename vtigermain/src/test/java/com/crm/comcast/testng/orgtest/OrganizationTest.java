package com.crm.comcast.testng.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationPage;

public class OrganizationTest extends BaseClass {
	
	@Test(groups="smoketest")
	public void createOrganizationTest() throws IOException {

		// read the data From Excel file By Using ExcelUtility

		String orgname = elib.getDataFromExcelFile("org", 1, 2) + jlib.getRandomNumber();

		// navigate to Organization page

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// click on "CreateOrganization" Button

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateneworgbutton().click();

		// enter all the details and Create new Organization

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgname);

		// verify the org name

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		String headerinfo = oip.getHeaderinfo().getText();

		if (headerinfo.contains(orgname)) {
			System.out.println(orgname + " is verifed====PASS");
		} else {
			System.out.println(orgname + " is not verifed====FAIL");
		}
		
	}
	@Test(groups="regressiontest")
	public void createOrgWithPhoneNumber() throws EncryptedDocumentException, IOException {
		
		//click on Organization link on home Page
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();
		//click on create Organization button(plus icon)in Organization Page
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateneworgbutton().click();
		//Create new Organization By entering all the details
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		String orgname=elib.getDataFromExcelFile("org", 1, 2).toString()+jlib.getRandomNumber();
		String phoneno=elib.getDataFromExcelFile("org", 1, 5).toString();
		cnop.createOrg(orgname, phoneno);
		
		//Verify the details
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String headerinfo=oip.getHeaderinfo().getText();
		if(headerinfo.contains(orgname)) {
			System.out.println(orgname+" is created=======PASS");
		}else {
			System.out.println(orgname+" is not created=======FAIL");
		}
		String actorgname=oip.getEditorginfo().getText();
		String actphoneno=oip.getEditphoneinfo().getText();
		if(actorgname.equals(orgname)&& actphoneno.equals(phoneno)) {
			System.out.println(orgname+" is created with phoneNo =======PASS");
		}else {
			System.out.println(orgname+" is not created with PhoneNo=======FAIL");
		}
		
	}
	
	@Test(groups="regressiontest")
	public void createOrgWithIndustryDD() throws EncryptedDocumentException, IOException {
		//click on Organization link on home Page
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();
		
		// click on create Organization button(plus icon)in Organization Page
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateneworgbutton().click();
		
		// Create new Organization By entering all the details

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		String orgname=elib.getDataFromExcelFile("org", 1, 2).toString()+jlib.getRandomNumber();
		String industry=elib.getDataFromExcelFile("org", 1, 3).toString();
		String type=elib.getDataFromExcelFile("org", 1, 4).toString();
		cnop.createOrg(orgname, industry, type);
		
		//verify
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		
		String actualind=oip.getEditindustrydd().getText();

		if(actualind.equals(industry)) {
			System.out.println(industry+" information is  verified====PASS");
		}else {
			System.out.println(industry+" information is not verified====FAIL");
		}
		
		//verify org name info
		String actualtype=oip.getEdittypedd().getText();
		if(actualtype.equals(type)) {
			System.out.println(orgname+" information is  verified=======PASS");
		}else {
			System.out.println(orgname+" information is not verified====FAIL");
		}
	
		
	}




}
