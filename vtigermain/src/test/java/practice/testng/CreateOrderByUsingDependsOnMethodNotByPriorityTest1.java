package practice.testng;

import org.testng.annotations.Test;

public class CreateOrderByUsingDependsOnMethodNotByPriorityTest1 {
	@Test
	public void createOrderTest() {
		System.out.println("Execute createOrderTest=====>123");
	}
	
	@Test(dependsOnMethods="createOrderTest")
	public void BillingAnOrderTest() {
		System.out.println("Execute BillingAnOrder====>123");
	}
}
