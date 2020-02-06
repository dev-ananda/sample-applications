/**
 * 
 */
package dev.ananda.test;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by Ananda on 30-Oct-2019 
 */

public class NumberFormatTest {
	public static void main(String[] args) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		
		Locale indiaLocale = new Locale("en", "IN");
		
		nf = NumberFormat.getInstance(indiaLocale);
		
		nf = NumberFormat.getInstance(Locale.CHINA);
		
		nf = NumberFormat.getInstance(Locale.FRANCE);
		
		nf.setCurrency(Currency.getInstance(Locale.getDefault()));
		
		Currency.getInstance(Locale.FRANCE).getSymbol();
		
	}

}
