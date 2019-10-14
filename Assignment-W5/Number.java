package AED.Assignment5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Number {
	
	public static int count(int a ,int b) {
		int value = 0;
		try {
		 value = a/b;
			System.out.println("value is "+value);

		}
		catch(ArithmeticException e) {
			System.out.println("can not be divided by zero "+a +" "+b);
		}
		
		catch(Exception e ) {
			System.out.println("For any other exception");
			e.printStackTrace();
		}
		
		
		return value;

	}
	
	public static void main(String[] args) {
		System.out.println("Handling Arithmatic and general exception without user input");
		int quotient = count(21,0);
		
		System.out.println("taking inputs from user,  exceptions can be input mismatch and number format");    
		
		Scanner sc = new Scanner(System.in);
				int a =0,b=0;
		
		
		try {
			System.out.println("Enter first number :");
			a = sc.nextInt(); //if we pass string we will get input mismatch exception
		//	a = Integer.parseInt(sc.next());
			System.out.println("Enter Second number :");

			//b = sc.nextInt();
			b = Integer.parseInt(sc.next()); // if we pass string here, we will get number format exception
			
		}
		catch(InputMismatchException ex) {
			System.out.println("input mismatch exception "+ex.getMessage());
		}
		catch(NumberFormatException ex) {
			System.out.println("Number format exception "+ex.getMessage());
		}
		
		int quotient1 = count(a,b);

		
		
	}
	
	

}
