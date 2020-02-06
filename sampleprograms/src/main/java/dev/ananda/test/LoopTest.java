/**
 * 
 */
package dev.ananda.test;

/**
 * Created by Ananda on 30-Oct-2019 
 */

public class LoopTest {

	/**
	 * @param args
	 */
	
	public static void generateSeq(int a, int b, int n){
		int sum = a;
		for(int k=0; k<n; k++){
			sum += Math.pow(2,k)*b;
			System.out.print(sum+" ");
		}
	}
	
	public static void main(String[] args) {
		generateSeq(5, 3, 5);
	}
}
