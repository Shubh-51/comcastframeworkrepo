package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random=new Random();
		int randomnum=random.nextInt(1000);
	return randomnum;
	}
	public String getSystemDateDDMMYYYY() {
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String date=sim.format(dateobj);
	return date;
	}
	public String getRequriedDateYYYYMMDD(int days) {
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String date=sim.format(cal.getTime());
	return date;
	}
}
