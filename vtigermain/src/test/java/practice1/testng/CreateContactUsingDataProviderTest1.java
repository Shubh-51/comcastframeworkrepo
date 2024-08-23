package practice1.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactUsingDataProviderTest1 {
	
	@Test(dataProvider="getData")
	public void createContactTest(String firstname,String lastname,long phoneno) {
		System.out.println(firstname +" ====="+lastname+" phone number "+phoneno);
	}
	
	@DataProvider
	public Object[][] getData() {
		
		//[] 1st denote number of row
		//[] 2nd denote number of column
		
		Object[][] arr=new Object[3][3];
		arr[0][0]="deepak";
		arr[0][1]="Hr";
		arr[0][2]=9987987806l;
		arr[1][0]="sam";
		arr[1][1]="Hd";
		arr[1][2]=9987777806l;
		arr[2][0]="shubh";
		arr[2][1]="maurya";
		arr[2][2]=9987988806l;
	return arr;
	}
}
