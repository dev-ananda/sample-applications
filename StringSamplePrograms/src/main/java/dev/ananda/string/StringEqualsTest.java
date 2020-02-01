package dev.ananda.string;

public class StringEqualsTest {

	public static void main(String[] args) {
		String s1 = "viha";
		String s2 = "viha";
		String s3 = new String("viha");

		System.out.println(" == opearator result for s1 and s2 : " + (s1 == s2));
		System.out.println(" == opearator result for s1 and s3 : " + (s1 == s3));

		System.out.println(" equals() method result for s1 and s2 : " + s1.equals(s2));

		System.out.println(" equals() method result for s1 and s3 : " + s1.equals(s3));

	}

}
