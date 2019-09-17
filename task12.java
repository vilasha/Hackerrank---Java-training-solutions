/*  Java Date and Time
	The Calendar class is an abstract class that provides methods for converting between a specific instant in time and a set of calendar fields such as YEAR, MONTH, DAY_OF_MONTH, HOUR, and so on, and for manipulating the calendar fields, such as getting the date of the next week.

	You are given a date. You just need to write the method, , which returns the day on that date. To simplify your task, we have provided a portion of the code in the editor.

	For example, if you are given the date , the method should return  as the day on that date.

	image

	Input Format

	A single line of input containing the space separated month, day and year, respectively, in   format.

	Constraints

	Output Format

	Output the correct day in capital letters.

	Sample Input

	08 05 2015
	Sample Output

	WEDNESDAY */

import java.util.Scanner;
import java.time.LocalDate;

public class task12 {
    
    private static String getDay(String day, String month, String year) {
        LocalDate localDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        return (localDate.getDayOfWeek()).toString();
    }
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        
        System.out.println(getDay(day, month, year));
    }
}