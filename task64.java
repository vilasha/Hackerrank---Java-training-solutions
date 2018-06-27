/*	Java SHA-256

	Cryptographic hash functions are mathematical operations run on digital data; by comparing the computed hash (i.e., the output produced by executing a hashing algorithm) to a known and expected hash value, a person can determine the data's integrity. For example, computing the hash of a downloaded file and comparing the result to a previously published hash result can show whether the download has been modified or tampered with. In addition, cryptographic hash functions are extremely collision-resistant; in other words, it should be extremely difficult to produce the same hash output from two different input values using a cryptographic hash function.

	Secure Hash Algorithm 2 (SHA-2) is a set of cryptographic hash functions designed by the National Security Agency (NSA). It consists of six identical hashing algorithms (i.e., SHA-256, SHA-512, SHA-224, SHA-384, SHA-512/224, SHA-512/256) with a variable digest size. SHA-256 is a -bit ( byte) hashing algorithm which can calculate a hash code for an input of up to bits. It undergoes  rounds of hashing and calculates a hash code that is a -digit hexadecimal number.

	Given a string, , print its SHA-256 hash value.

	Input Format

	A single alphanumeric string denoting .

	Constraints

	String  consists of English alphabetic letters (i.e.,  and/or decimal digits (i.e.,  through ) only.
	Output Format

	Print the SHA-256 encryption value of  on a new line.	*/
	
import java.io.*;
import java.util.*;
import java.security.*;

public class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        sc.close();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(S.getBytes());
        byte[] byteData = md.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++)
            hexString.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        System.out.println(hexString.toString());
    }
}