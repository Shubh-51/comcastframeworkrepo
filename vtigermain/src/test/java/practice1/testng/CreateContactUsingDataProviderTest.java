package practice1.testng;

import org.testng.annotations.Test;

public class CreateContactUsingDataProviderTest {
	
	//if you run this you get exception
	//Because you ask for data but there is no data
	
	@Test
	public void createContactTest(String firstname,String lastname) {
		System.out.println(firstname +" ====="+lastname);
	}
}
