/**
 * 
 */
package dev.ananda.test;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Ananda on 30-Oct-2019 
 */

public class CurrencyFormatterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        // Write your code here.

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        String us = nf.format(payment);

        Locale inLocale = new Locale("en", "IN");

        nf = NumberFormat.getCurrencyInstance(inLocale);
        String india = nf.format(payment);

        nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = nf.format(payment);

        nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = nf.format(payment);
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);

	}

}
