/*  Java Substring Comparisons
	We define the following terms:

	Lexicographical Order, also known as alphabetic or dictionary order, orders characters as follows: 
	For example, ball < cat, dog < dorm, Happy < happy, Zoo < ball.

	A substring of a string is a contiguous block of characters in the string. For example, the substrings of abc are a, b, c, ab, bc, and abc.
	Given a string, , and an integer, , complete the function so that it finds the lexicographically smallest and largest substrings of length .

	Input Format

	The first line contains a string denoting . 
	The second line contains an integer denoting .

	Constraints

	 consists of English alphabetic letters only (i.e., [a-zA-Z]).
	Output Format

	Return the respective lexicographically smallest and largest substrings as a single newline-separated string.

	Sample Input 0

	welcometojava
	3
	Sample Output 0

	ava
	wel  */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
        int subCount = s.length() - k + 1;
        for (int i = 0; i < subCount; i++) {
            if (smallest.compareTo(s.substring(i, i + k)) > 0)
                smallest = s.substring(i, i + k);
            if (largest.compareTo(s.substring(i, i + k)) < 0)
                largest = s.substring(i, i + k);
        }
        
        
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}