/*  Java Anagrams
	Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies. For example, the anagrams of CAT are CAT, ACT, TAC, TCA, ATC, and CTA.

	Complete the function in the editor. If  and  are case-insensitive anagrams, print "Anagrams"; otherwise, print "Not Anagrams" instead.

	Input Format

	The first line contains a string denoting . 
	The second line contains a string denoting .

	Constraints

	Strings  and  consist of English alphabetic characters.
	The comparison should NOT be case sensitive.
	Output Format

	Print "Anagrams" if  and  are case-insensitive anagrams of each other; otherwise, print "Not Anagrams" instead.

	Sample Input 0

	anagram
	margana
	Sample Output 0

	Anagrams  */
	
import java.util.List;
import java.util.Scanner;

public class task18 {
    static boolean isAnagram(String a, String b) {
        List<Character> aList = a.toLowerCase()
            .chars().mapToObj(e -> (char)e)
            .sorted()
            .collect(java.util.stream.Collectors.toList());
        List<Character> bList = b.toLowerCase()
            .chars().mapToObj(e -> (char)e)
            .sorted()
            .collect(java.util.stream.Collectors.toList());
        return aList.equals(bList);
    }
	    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}