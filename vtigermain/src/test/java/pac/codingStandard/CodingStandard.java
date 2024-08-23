package pac.codingStandard;


import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass1;
import com.comcast.crm.objectrepositoryUtility.LoginPage;

public class CodingStandard extends BaseClass1{
	/**
	 * Scenario :login()==>NaviagteContact==>createContact()==>verify
	 */
	@Test
	public void codinStandard() {
		/**
		 * Step 1:login to application
		 */
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(null, null, null);
	}
}
