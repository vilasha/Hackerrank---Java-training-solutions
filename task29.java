/*	Java 2D Array

	You are given a  2D array. An hourglass in an array is a portion shaped like this:

	a b c
	  d
	e f g
	For example, if we create an hourglass using the number 1 within an array full of zeros, it may look like this:

	1 1 1 0 0 0
	0 1 0 0 0 0
	1 1 1 0 0 0
	0 0 0 0 0 0
	0 0 0 0 0 0
	0 0 0 0 0 0
	Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following:

	1 1 1     1 1 0     1 0 0
	  1         0         0
	1 1 1     1 1 0     1 0 0
	The sum of an hourglass is the sum of all the numbers within it. The sum for the hourglasses above are 7, 4, and 2, respectively.

	In this problem you have to print the largest sum among all the hourglasses in the array.

	Input Format

	There will be exactly  lines, each containing  integers seperated by spaces. Each integer will be between  and  inclusive.

	Output Format

	Print the answer to this problem on a single line. */
	
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    
    private static int hourglassSum (int[][] hourglass) {
        return Arrays.stream(hourglass).flatMapToInt(Arrays::stream).sum();
    }

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        scanner.close();
        int maxSum = -999;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                int[][] hourglass = new int[3][];
                hourglass[0] = Arrays.copyOfRange(arr[j], i, i + 3);
                hourglass[1] = new int[] {0, arr[j+1][i+1], 0};
                hourglass[2] = Arrays.copyOfRange(arr[j + 2], i, i + 3);
                int sum = hourglassSum(hourglass);
                maxSum = (sum > maxSum ? sum : maxSum);
            }
        System.out.println(maxSum);
    }
}
