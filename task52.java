/*	Java Exception Handling
	You are required to compute the power of a number by implementing a calculator. Create a class MyCalculator which consists of a single method long power(int, int). This method takes two integers,  and , as parameters and finds . If either or  is negative, then the method must throw an exception which says "". Also, if both  and  are zero, then the method must throw an exception which says ""

	For example, -4 and -5 would result in .

	Complete the function power in class MyCalculator and return the appropriate result after the power operation or an appropriate exception as detailed above.

	Input Format

	Each line of the input contains two integers,  and . The locked stub code in the editor reads the input and sends the values to the method as parameters.

	Constraints

	Output Format

	Each line of the output contains the result , if both  and  are positive. If either  or  is negative, the output contains "n and p should be non-negative". If both  and  are zero, the output contains "n and p should not be zero.". This is printed by the locked stub code in the editor.	*/
	
import java.util.Scanner;

class MyCalculator1 {
    int power(int n, int p) throws Exception {
        if (n < 0 || p < 0)
            throw new Exception("n or p should not be negative.");
        if (n == 0 && p == 0)
            throw new Exception("n and p should not be zero.");
        return (int)Math.pow(n, p);
    }
}

public class task52 {
    public static final MyCalculator1 my_calculator = new MyCalculator1();
    public static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (in .hasNextInt()) {
            int n = in .nextInt();
            int p = in .nextInt();
            
            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}