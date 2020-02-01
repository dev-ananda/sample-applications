package dev.ananda.string;

public class StringEclispeTips {
	public static void main(String[] args) {
		String s1 = "Ananda";
		String s2 = "Viha";
		String s3 = "Gowda";

		// use ctrl + 1 to initiate the content assist
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(s1);
		stringBuilder.append(" ");
		stringBuilder.append(s2);
		stringBuilder.append(" ");
		stringBuilder.append(s3);
		String s4 = stringBuilder.toString();

		System.out.println("Concanted string = " + s4);

	}
}
