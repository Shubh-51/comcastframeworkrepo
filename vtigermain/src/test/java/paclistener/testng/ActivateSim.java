package paclistener.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass1;
@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class ActivateSim extends BaseClass1 {

	
	@Test(retryAnalyzer=com.comcast.crm.listenerutility.RetryListnerImp.class)
	public void activateSimTest() {
		System.out.println("Execute ActivateSim");
		String acttitle=driver.getTitle();
		Assert.assertEquals(acttitle,"login");
		Assert.assertEquals("", "login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");

	}

	

}
