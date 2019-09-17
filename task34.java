/*	Java Map

	You are given a phone book that consists of people's names and their phone number. After that you will be given some person's name as query. For each query, print the phone number of that person.

	Input Format

	The first line will have an integer  denoting the number of entries in the phone book. Each entry consists of two lines: a name and the corresponding phone number. 

	After these, there will be some queries. Each query will contain a person's name. Read the queries until end-of-file.

	Constraints:
	A person's name consists of only lower-case English letters and it may be in the format 'first-name last-name' or in the format 'first-name'. Each phone number has exactly 8 digits without any leading zeros.




	Output Format

	For each case, print "Not found" if the person has no entry in the phone book. Otherwise, print the person's name and phone number. See sample output for the exact format.

	To make the problem easier, we provided a portion of the code in the editor. You can either complete that code or write completely on your own.	*/
	
import java.util.*;

class task34 {
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
        HashMap<String,String> phoneBook = new HashMap<>();
		int n=in.nextInt();
		in.nextLine();
		for(int i = 0; i<n; i++) {
			String name=in.nextLine();
			String phone=in.nextLine();
            phoneBook.put(name, phone);
		}
		while (in.hasNext()) {
            String q = in.nextLine();
            System.out.println((phoneBook.get(q) == null) 
                               ? "Not found" : q + "=" + phoneBook.get(q));
        }
	}
}