package timeConversion;

import java.text.DecimalFormat;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test1 = "07:45:12 AM";
		String test2 = "07:45:12 PM";
		
		String am = "AM";
		String pm = "PM";
		
		String[] split = test1.split(":");
		
		String amPm = split[2].substring(3,5);
		
		int hour = Integer.parseInt(split[0]);
		int min = Integer.parseInt(split[1]);
		int sec = Integer.parseInt(split[2].substring(0, 2));
	
		DecimalFormat ft = new DecimalFormat("00");
		
		if (amPm.equals(am)) {
			System.out.println(ft.format(hour) + ":" + ft.format(min) + ":" + ft.format(sec));
		} else {
			hour = hour + 12;
			System.out.println(ft.format(hour) + ":" + ft.format(min) + ":" + ft.format(sec));
		}
		
	}

}
