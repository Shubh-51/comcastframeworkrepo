package paclistener.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass1;


//i am not writing @Listeners tag to take screenshot at run time 
//creating suite and use listeners tag inside xml file;


public class InvoiceTest1 {
	public class InvoiceTest extends BaseClass1 {
		@Test
		public void createInvoiceTest() {
			System.out.println("Execute createInvoiceTest");
			String acttitle=driver.getTitle();
			Assert.assertEquals(acttitle, "login");
			System.out.println("Step-1");
			System.out.println("Step-2");
			System.out.println("Step-3");
			System.out.println("Step-4");
			
		}
		
		@Test
		public void createInvoiceWithContactTest() {
			System.out.println("Execute createInvoiceTestWithPhoneno");
			System.out.println("Step-1");
			System.out.println("Step-2");
			System.out.println("Step-3");
			System.out.println("Step-4");
		}
	}
}
