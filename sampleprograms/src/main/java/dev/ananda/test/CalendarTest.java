/**
 * 
 */
package dev.ananda.test;

import java.util.Calendar;

/**
 * Created by Ananda on 30-Oct-2019 
 */

public class CalendarTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
Calendar cal = Calendar.getInstance();
		
		cal.set(2015, 8-1, 5);
		
		String[] days = new String[] { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY",
		        "FRIDAY", "SATURDAY" };
		
		int day = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(days[day-1]);

	}

}
