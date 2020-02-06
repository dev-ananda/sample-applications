package dev.ananda.string;

public class StringProcessingPerformanceTest {

	public static void main(String[] args) {
		String str = "";
		long startTime = System.nanoTime();
		for (int i = 0; i < 10; i++) {
			str = str + i;
		}
		long endTime = System.nanoTime();
		System.out.println(
				String.format("String opetation with + operator took [%d] nano seconds", (endTime - startTime)));

		StringBuilder builder = new StringBuilder();
		startTime = System.nanoTime();
		for (int i = 0; i < 10; i++) {
			builder.append(i);
		}
		endTime = System.nanoTime();
		System.out.println(
				String.format("String opetation with StringBuilder took [%d] nano seconds", (endTime - startTime)));

		StringBuffer strBuffer = new StringBuffer();
		startTime = System.nanoTime();
		for (int i = 0; i < 10; i++) {
			strBuffer.append(i);
		}
		endTime = System.nanoTime();
		System.out.println(
				String.format("String opetation with StringBuffer took [%d] nano seconds", (endTime - startTime)));
	}

}
