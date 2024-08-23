package com.crm.generic.baseutility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass1 {
	
	@BeforeSuite
	public void bs() {
		System.out.println("====connection of db,config report======");
	}
	
	@BeforeClass
	public void bc() {
		System.out.println("======Lauch The browser======");
	}
	
	@BeforeMethod
	public void bm() {
		System.out.println("=========login=========");
	}
	@AfterMethod
	public void am() {
		System.out.println("===============logout============");
	}
	
	@AfterClass
	public void Ac() {
		System.out.println("======Close the Browser=======");
	}
	
	@AfterSuite
	public void As() {
		System.out.println("====Close DB,Report Backup=====");
	}
}
