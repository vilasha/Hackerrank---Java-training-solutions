/*	Java MD5

	MD5 (Message-Digest algorithm 5) is a widely-used cryptographic hash function with a -bit hash value. Here are some common uses for MD5:

	To store a one-way hash of a password.
	To provide some assurance that a transferred file has arrived intact.
	MD5 is one in a series of message digest algorithms designed by Professor Ronald Rivest of MIT (Rivest, ); however, the security of MD5 has been severely compromised, most infamously by the Flame malware in . The CMU Software Engineering Institute essentially considers MD5 to be "cryptographically broken and unsuitable for further use".

	Given an alphanumeric string, , denoting a password, compute and print its MD5 encryption value.

	Input Format

	A single alphanumeric string denoting .

	Constraints

	String  consists of English alphabetic letters (i.e.,  and/or decimal digits (i.e.,  through ) only.
	Output Format

	Print the MD5 encryption value of  on a new line.	*/
	
import java.io.*;
import java.util.*;
import java.security.*;

public class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        sc.close();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(S.getBytes());
        byte[] byteData = md.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++)
            hexString.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        System.out.println(hexString.toString());
    }
}