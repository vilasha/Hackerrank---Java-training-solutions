/*	Java Dequeue

	In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).

	Deque interfaces can be implemented using various types of collections such as LinkedList or ArrayDeque classes. For example, deque can be declared as:

	Deque deque = new LinkedList<>();
	or
	Deque deque = new ArrayDeque<>();
	You can find more details about Deque here.

	In this problem, you are given  integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size .

	Note: Time limit is  second for this problem.

	Input Format

	The first line of input contains two integers  and : representing the total number of integers and the size of the subarray, respectively. The next line contains  space separated integers.

	Constraints




	The numbers in the array will range between .

	Output Format

	Print the maximum number of unique integers among all possible contiguous subarrays of size .	*/
	
import java.util.*;

public class task40 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = in.nextInt();
        int m = in.nextInt();

        int maxUnique = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            if (map.containsKey(num))
                map.put(num, map.get(num).intValue() + 1);
            else
                map.put(num, 1);

            if (deque.size() == m + 1) {
                int key = deque.removeFirst();
                int v = map.get(key);
                if (v == 1)
                    map.remove(key);
                else
                    map.put(key, v - 1);
            }

            int currentUnique = map.size();
            if (currentUnique > maxUnique)
                maxUnique = currentUnique;
        }
        System.out.println(maxUnique);
    }
}