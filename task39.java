/*	Java Sort

	You are given a list of student information: ID, FirstName, and CGPA. Your task is to rearrange them according to their CGPA in decreasing order. If two student have the same CGPA, then arrange them according to their first name in alphabetical order. If those two students also have the same first name, then order them according to their ID. No two students have the same ID.

	Hint: You can use comparators to sort a list of objects. See the oracle docs to learn about comparators.

	Input Format

	The first line of input contains an integer , representing the total number of students. The next  lines contains a list of student information in the following structure:

	ID Name CGPA
	Constraints

	The name contains only lowercase English letters. The  contains only integer numbers without leading zeros. The CGPA will contain, at most, 2 digits after the decimal point.

	Output Format

	After rearranging the students according to the above rules, print the first name of each student on a separate line.	*/
	
import java.util.*;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

class Sorter implements Comparator<Student> {
    public int compare(Student a, Student b) {
        if (a.getCgpa() != b.getCgpa())
            return (a.getCgpa() > b.getCgpa()) ? -1 : 1;
        else if (!a.getFname().equalsIgnoreCase(b.getFname()))
            return a.getFname().compareTo(b.getFname());
        else
            return a.getId() - b.getId();
    }
}

public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
        
        Sorter sorter = new Sorter();
        Collections.sort(studentList, sorter);
      
      	for(Student st: studentList)
            System.out.println(st.getFname());
	}
}