/*  Java String Reverse
	Given a string , print Yes if it is a palindrome, print No otherwise.

	Constraints

	 will consist at most  lower case english letters.
	Sample Input

	madam
	Sample Output

	Yes  */
	
import java.util.Scanner;

public class task17 {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A = sc.next();
        String reverse = new StringBuffer(A).reverse().toString();
        if (A.equals(reverse))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}