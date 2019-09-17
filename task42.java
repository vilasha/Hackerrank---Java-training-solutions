/*	Java Priority Queue

	In this problem we will test your knowledge on Java Priority Queue.

	There are a number of students in a school who wait to be served. Two types of events, ENTER and SERVED, can take place which are described below.

	ENTER: A student with some priority enters the queue to be served.
	SERVED: The student with the highest priority is served (removed) from the queue.
	A unique id is assigned to each student entering the queue. The queue serves the students based on the following criteria (priority criteria):

	The student having the highest Cumulative Grade Point Average (CGPA) is served first.
	Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
	Any students having the same CGPA and name will be served in ascending order of the id.
	Create the following two classes:

	The Student class should implement:
	The constructor Student(int id, String name, double cgpa).
	The method int getID() to return the id of the student.
	The method String getName() to return the name of the student.
	The method double getCGPA() to return the CGPA of the student.
	The Priorities class should implement the method List<Student> getStudents(List<String> events) to process all the given events and return all the students yet to be served in the priority order.
	Input Format

	The first line contains an integer, , describing the total number of events. Each of the  subsequent lines will be of the following two forms:

	ENTER name CGPA id: The student to be inserted into the priority queue.
	SERVED: The highest priority student in the queue was served.
	The locked stub code in the editor reads the input and tests the correctness of the Student and Priorities classes implementation.

	Constraints

	Output Format

	The locked stub code prints the names of the students yet to be served in the priority order. If there are no such student, then the code prints EMPTY.	*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student1 {
    private int id;
    private String name;
    private double cgpa;

    Student1(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCGPA() {
        return cgpa;
    }
}

class Priorities extends java.util.PriorityQueue<Student1> {
    
    Priorities() {
        super(999, new java.util.Comparator<Student1>() {
            public int compare(Student1 s1, Student1 s2) {
                if (s1.getCGPA() != s2.getCGPA())
                    return (s1.getCGPA() < s2.getCGPA()) ? 1 : -1;
                else if (!s1.getName().equals(s2.getName()))
                    return s1.getName().compareTo(s2.getName());
                else
                    return s1.getID() - s2.getID();
            }
        });
    }
    
    List<Student1> getStudents(List<String> events) {
        String[] params;
        for (String event : events) {
            params = event.split(" ");
            if ("ENTER".equals(params[0]))
                this.offer(new Student1(Integer.parseInt(params[3]), params[1], Double.parseDouble(params[2])));
            if ("SERVED".equals(params[0]))
                this.poll();
        }
        List<Student1> result = new ArrayList<>();
        while (!this.isEmpty())
            result.add(this.poll());
        return result;
    }
}

public class task42 {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student1> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student1 st: students) {
                System.out.println(st.getName());
            }
        }
    }
}