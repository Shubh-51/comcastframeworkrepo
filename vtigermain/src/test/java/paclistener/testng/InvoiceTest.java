package paclistener.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass1;
@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
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
