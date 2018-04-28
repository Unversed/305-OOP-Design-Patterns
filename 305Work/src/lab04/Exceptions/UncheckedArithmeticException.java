package lab04.Exceptions;

public class UncheckedArithmeticException {

	public static void main(String args[]) {
		int num1 = 10;
		int num2 = 0;
		/*
		 * Since I'm dividing an integer with 0 it should throw ArithmeticException
		 */
		int res = num1 / num2;
		System.out.println(res);
	}
}
