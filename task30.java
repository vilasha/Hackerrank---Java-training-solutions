/*	Java Subarray
	
	We define the following:

	A subarray of an -element array is an array composed from a contiguous block of the original array's elements. For example, if , then the subarrays are , , , , , and . Something like  would not be a subarray as it's not a contiguous subsection of the original array.
	The sum of an array is the total sum of its elements.
	An array's sum is negative if the total sum of its elements is negative.
	An array's sum is positive if the total sum of its elements is positive.
	Given an array of  integers, find and print its number of negative subarrays on a new line.

	Input Format

	The first line contains a single integer, , denoting the length of array . 
	The second line contains  space-separated integers describing each respective element, , in array .

	Constraints

	Output Format

	Print the number of subarrays of  having negative sums.  */

import java.util.*;
import java.util.stream.IntStream;

public class task30 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.nextLine();
        s = sc.nextLine();
        int[] arr = Arrays.stream(s.split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        sc.close();
        long result = IntStream.range(0, n)
            .flatMap(from -> IntStream.rangeClosed(from + 1, n)
                     .map(to -> Arrays.stream(arr, from, to)
                         .sum()))
            .filter(sum -> sum < 0)
            .count();
        System.out.println(result);
    }
}