package backend;

import java.util.ArrayList;
import java.util.Scanner;

public class Student_Tracker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		ArrayList<Subject> subs = new ArrayList<Subject>();
		int x = 1;
		System.out.println("enter student name");
		String n = s.next();
		System.out.println("enter student id");
		int id = s.nextInt();
		while(x!=7) {
			System.out.println("enter subject no "+x+"'s name");
			String name = s.next();
			System.out.println("enter subject no "+x+"'s score");
			int score = s.nextInt();
			subs.add(new Subject(name, score));
			x++;
		}
		Student student = new Student(id, n, subs);
		System.out.println(student.getStudentName());
		System.out.println(student.getStudent_ID());
		for(int i = 0 ; i< student.getSubjects().size();i++) {
			System.out.println(student.getSubjects().get(i).getSubjectName()+" "+student.getSubjects().get(i).getGarde());
		}
		System.out.println(student.getAvg());
		System.out.println(student.getHighest().getSubjectName()+" "+student.getHighest().getScore());
		System.out.println(student.getLowest().getSubjectName()+" "+student.getLowest().getScore());
	}

}
