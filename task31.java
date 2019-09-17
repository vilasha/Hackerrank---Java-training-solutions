/*	Java Arraylist

	Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you this feature. Try to solve this problem using Arraylist.

	You are given  lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in  position of  line. 

	Take your input from System.in.

	Input Format
	The first line has an integer . In each of the next  lines there will be an integer  denoting number of integers on that line and then there will be  space-separated integers. In the next line there will be an integer  denoting number of queries. Each query will consist of two integers  and .

	Constraints

	Each number will fit in signed integer.
	Total number of integers in  lines will not cross .

	Output Format
	In each line, output the number located in  position of  line. If there is no such position, just print "ERROR!"  */
	
import java.util.*;

public class task31 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            numbers.add(new ArrayList<Integer>());
            for (int j = 0; j < d; j++)
                numbers.get(i).add(sc.nextInt());
        }
        int q = sc.nextInt();
        int x;
        int y;
        for (int i = 0; i < q; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            try {
                System.out.println(numbers.get(x - 1).get(y - 1));
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }
        sc.close();
    }
}