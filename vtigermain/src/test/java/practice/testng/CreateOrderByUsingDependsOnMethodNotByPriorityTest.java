package practice.testng;

import org.testng.annotations.Test;

public class CreateOrderByUsingDependsOnMethodNotByPriorityTest {
	
	//Without using dependsOnMethod
	//if you execute this first billing going to be execute
	//b/e we know testng execute methods in alphabetical order
	
	@Test
	public void createOrderTest() {
		System.out.println("Execute createOrderTest=====>123");
	}
	
	@Test
	public void BillingAnOrderTest() {
		System.out.println("Execute BillingAnOrder====>123");
	}
	
}
