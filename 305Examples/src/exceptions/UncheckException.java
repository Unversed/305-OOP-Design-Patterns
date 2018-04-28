package exceptions;

import java.util.Scanner;

public class UncheckException {
	public static void main (String args []) {
		
		int num1, num2;
		double result=1000;
		System.out.println ("please enter values for num1 and num2");
		Scanner reader =new Scanner (System.in);
		num1=reader.nextInt();
		num2=reader.nextInt();
		System.out.println(num1 + " " + num2);
		
		try {
			  result = num1/num2;
		}
		catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("num2 should not be zero");
		}
		
		System.out.println(result);
		
	}

}
