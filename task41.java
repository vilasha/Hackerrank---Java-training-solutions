/*	Java BitSet

	Java's BitSet class implements a vector of bit values (i.e.:  () or  ()) that grows as needed, allowing us to easily manipulate bits while optimizing space (when compared to other collections). Any element having a bit value of  is called a set bit.

	Given  BitSets,  and , of size  where all bits in both BitSets are initialized to , perform a series of  operations. After each operation, print the number of set bits in the respective BitSets as two space-separated integers on a new line.

	Input Format

	The first line contains  space-separated integers,  (the length of both BitSets  and ) and  (the number of operations to perform), respectively. 
	The  subsequent lines each contain an operation in one of the following forms:

	AND 
	OR 
	XOR 
	FLIP
	SET 
	In the list above,  is the integer  or , where  denotes  and  denotes . 
	 is an integer denoting a bit's index in the BitSet corresponding to .

	For the binary operations , , and , operands are read from left to right and the BitSet resulting from the operation replaces the contents of the first operand. For example:

	AND 2 1
	 is the left operand, and  is the right operand. This operation should assign the result of  to .

	Constraints

	Output Format

	After each operation, print the respective number of set bits in BitSet  and BitSet  as  space-separated integers on a new line.	*/
	
import java.util.*;

public class task41 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BitSet B1 = new BitSet(N);
        BitSet B2 = new BitSet(N);

        int M = sc.nextInt();
        String operation;
        int param1, param2;
        BitSet bs1, bs2;
        for (int i = 0; i < M; i++) {
            operation = sc.next();
            param1 = sc.nextInt();
            param2 = sc.nextInt();
            bs1 = (param1 == 1) ? B1 : B2;
            bs2 = (param2 == 1) ? B1 : B2;
            switch (operation) {
                case "AND":
                    bs1.and(bs2);
                    break;
                case "OR":
                    bs1.or(bs2);
                    break;
                case "XOR":
                    bs1.xor(bs2);
                    break;
                case "FLIP":
                    bs1.flip(param2);
                    break;
                case "SET":
                    bs1.set(param2);
                    break;
            }
            System.out.println(B1.cardinality() + " " + B2.cardinality());
        }
        sc.close();
    }
}