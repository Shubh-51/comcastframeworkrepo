package paclistener.testng;


import org.testng.annotations.Test;

public class ActivateSim1 {

	@Test(retryAnalyzer=com.comcast.crm.listenerutility.RetryListnerImp.class)
	public void activateSimTest() {
		System.out.println("Execute ActivateSim");
		
		//Assert.assertEquals("", "login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");

	}

}
