/*	Java 1D Array (Part 2)

	Let's play a game on an array! You're standing at index  of an -element array named . From some index  (where ), you can perform one of the following moves:

	Move Backward: If cell  exists and contains a , you can walk back to cell .
	Move Forward:
	If cell  contains a zero, you can walk to cell .
	If cell  contains a zero, you can jump to cell .
	If you're standing in cell  or the value of , you can walk or jump off the end of the array and win the game.
	In other words, you can move from index  to index , , or  as long as the destination index is a cell containing a . If the destination index is greater than , you win the game.

	Given  and , complete the function in the editor below so that it returns true if you can win the game (or false if you cannot).

	Input Format

	The first line contains an integer, , denoting the number of queries (i.e., function calls). 
	The  subsequent lines describe each query over two lines:

	The first line contains two space-separated integers describing the respective values of  and .
	The second line contains  space-separated binary integers (i.e., zeroes and ones) describing the respective values of .
	Constraints

	It is guaranteed that the value of  is always .
	Output Format

	Return true if you can win the game; otherwise, return false.	*/
	
import java.util.*;

public class task32 {

    public static boolean canWin(int leap, int[] game) {
        int N = game.length;
        /* attainability is a map, which indicates whether a cell could be reached or not
         * value -1 = cell can't be reached
         * 1 = cell is reachable
         * 0 = we don't know yet */
        int[] attainability = new int[N];
        for (int i = 0; i < N; i++)
            attainability[i] = (game[i] == 0) ? 0 : -1;
        attainability[0] = 1;
        boolean hadChanges;
        do {
            hadChanges = false;
            for (int i = 0; i < N; i++) {
                if (attainability[i] == 1) {
                    if (i > 0 && game[i-1] == 0 && attainability[i-1] == 0) {
                        attainability[i-1] = 1;
                        hadChanges = true;
                    }
                    if (i < N-1 && game[i+1] == 0 && attainability[i+1] == 0) {
                        attainability[i+1] = 1;
                        hadChanges = true;
                    }
                    if (i < N-leap && game[i+leap] == 0 && attainability[i+leap] == 0) {
                        attainability[i+leap] = 1;
                        hadChanges = true;
                    }
                }
            }
        }
        while (hadChanges);
        if (attainability[N-1] == 1)
            return true;
        for (int i = N-1; i > N - leap - 1; i--)
            if (attainability[i] == 1)
                return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}