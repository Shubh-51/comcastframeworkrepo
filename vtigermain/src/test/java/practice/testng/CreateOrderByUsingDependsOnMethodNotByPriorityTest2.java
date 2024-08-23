package practice.testng;

import org.testng.annotations.Test;

public class CreateOrderByUsingDependsOnMethodNotByPriorityTest2 {
	
	//Negative scenario
	
	@SuppressWarnings("null")
	@Test
	public void createOrderTest() {
		System.out.println("Execute createOrderTest=====>123");
		
		String str=null;
		System.out.println(str.equals("123"));
	}
	
	@Test(dependsOnMethods="createOrderTest")
	public void BillingAnOrderTest() {
		System.out.println("Execute BillingAnOrder====>123");
	}
}
