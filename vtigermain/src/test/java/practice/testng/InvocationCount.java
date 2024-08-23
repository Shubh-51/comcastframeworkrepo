package practice.testng;

import org.testng.annotations.Test;

public class InvocationCount {
	@Test(invocationCount=10)
	public void createOrderTest() {
		System.out.println("Execute createOrderTest=====>123");
	}
	
	@Test(enabled=false)
	public void BillingAnOrderTest() {
		System.out.println("Execute BillingAnOrder====>123");
	}
}
