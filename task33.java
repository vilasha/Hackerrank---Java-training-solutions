/*	Java List

	For this problem, we have  types of queries you can perform on a List:

	Insert  at index :

	Insert
	x y
	Delete the element at index :

	Delete
	x
	Given a list, , of  integers, perform  queries on the list. Once all queries are completed, print the modified list as a single line of space-separated integers.

	Input Format

	The first line contains an integer,  (the initial number of elements in ). 
	The second line contains  space-separated integers describing . 
	The third line contains an integer,  (the number of queries). 
	The  subsequent lines describe the queries, and each query is described over two lines:

	If the first line of a query contains the String Insert, then the second line contains two space separated integers , and the value  must be inserted into  at index .
	If the first line of a query contains the String Delete, then the second line contains index , whose element must be deleted from .
	Constraints



	Each element in is a 32-bit integer.
	Output Format

	Print the updated list  as a single line of space-separated integers. */
	
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class task33 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.nextLine();
        s = sc.nextLine();
        List<Integer> L = Stream.of(s.split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            String operation = sc.next();
            int index = sc.nextInt();
            if ("Insert".equals(operation))
                L.add(index, sc.nextInt());
            if ("Delete".equals(operation))
                L.remove(index);
        }
        sc.close();
        String result = L.stream().map(Object::toString).collect(Collectors.joining(" ")).toString();
        System.out.println(result);
    }
}