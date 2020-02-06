/**
 * 
 */
package dev.ananda.reflectionapi;

/**
 * Created by Ananda on 07-Nov-2019 
 */

public class ReflectionTest {

	// creating a private field 
	private String s; 

	// creating a public constructor 
	public ReflectionTest()  {  s = "Viha"; } 

	// Creating a public method with no arguments 
	public void method1()  { 
		System.out.println("The string is " + s); 
	} 

	// Creating a public method with int as argument 
	public void method2(int n)  { 
		System.out.println("The number is " + n); 
	} 

	// creating a private method 
	private void method3() { 
		System.out.println("Private method invoked"); 
	}

}
