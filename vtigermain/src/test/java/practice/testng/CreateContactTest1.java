package practice.testng;

import org.testng.annotations.Test;

public class CreateContactTest1 {
	
		@Test
		public void createContactTest() {
			System.out.println("Execute login");
			System.out.println("Naviagte to contact");
			System.out.println("Execute Create a Contact");
			System.out.println("Execute the verify contact  ");
			System.out.println("Execute logout");
			
		}
		
		@Test
		private void createContactWithPhoneNumber() {
			System.out.println("Exceute this also");
			
		}
}
