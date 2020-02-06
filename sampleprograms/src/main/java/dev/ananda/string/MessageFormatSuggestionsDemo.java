package dev.ananda.string;

import java.text.MessageFormat;

public class MessageFormatSuggestionsDemo {
	public static void main(String[] args) {
		String month = "May";
		int year = 2019;
		
		String yearStr = MessageFormat.format("This is {0} month of {1} year ", month, year);
		
		System.out.println(yearStr);
	}
}
