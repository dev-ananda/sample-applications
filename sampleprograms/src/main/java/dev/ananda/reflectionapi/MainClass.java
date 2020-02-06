/**
 * 
 */
package dev.ananda.reflectionapi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Ananda on 07-Nov-2019 
 */

public class MainClass {

	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchFieldException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		// Creating object whose property is to be checked 
		ReflectionTest obj = new ReflectionTest(); 
  
        // Creating class object from the object using 
        // getclass method 
        Class cls = obj.getClass(); 
        Class cls1 = Class.forName("dev.ananda.reflectionapi.ReflectionTest");
        System.out.println("The name of class is " + 
                            cls.getName()); 
  
        // Getting the constructor of the class through the 
        // object of the class 
        Constructor constructor = cls.getConstructor(); 
        System.out.println("The name of constructor is " + 
                            constructor.getName()); 
  
        System.out.println("The public methods of class are : "); 
  
        // Getting methods of the class through the object 
        // of the class by using getMethods 
        Method[] methods = cls.getMethods(); 
  
        // Printing method names 
        for (Method method:methods) 
            System.out.println(method.getName()); 
  
        // creates object of desired method by providing the 
        // method name and parameter class as arguments to 
        // the getDeclaredMethod 
        Method methodcall1 = cls.getDeclaredMethod("method2", 
                                                 int.class); 
  
        // invokes the method at runtime 
        methodcall1.invoke(obj, 19); 
  
        // creates object of the desired field by providing 
        // the name of field as argument to the  
        // getDeclaredField method 
        Field field = cls.getDeclaredField("s"); 
  
        // allows the object to access the field irrespective 
        // of the access specifier used with the field 
        field.setAccessible(true); 
  
        // takes object and the new value to be assigned 
        // to the field as arguments 
        field.set(obj, "JAVA"); 
  
        // Creates object of desired method by providing the 
        // method name as argument to the getDeclaredMethod 
        Method methodcall2 = cls.getDeclaredMethod("method1"); 
  
        // invokes the method at runtime 
        methodcall2.invoke(obj); 
  
        // Creates object of the desired method by providing 
        // the name of method as argument to the  
        // getDeclaredMethod method 
        Method methodcall3 = cls.getDeclaredMethod("method3"); 
  
        // allows the object to access the method irrespective  
        // of the access specifier used with the method 
        methodcall3.setAccessible(true); 
  
        // invokes the method at runtime 
        methodcall3.invoke(obj); 

	}

}
