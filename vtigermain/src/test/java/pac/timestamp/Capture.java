package pac.timestamp;

import java.util.Date;

public class Capture {
	public static void main(String[] args) {
		//String time=new Date().toString();
		//System.out.println(time);
		
		//any folder name do not accept spaces and special characters
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println(time);
		System.out.println("hi");
		System.out.println("hi");
	}
}
