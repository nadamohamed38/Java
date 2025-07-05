package backend;

import java.util.ArrayList;

public class Student {
	private int student_ID;
	private String studentName;
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	private float avg;
	private Subject highest;
	private Subject lowest;
	
	public Student(int id,String name , ArrayList<Subject> subjects) {
		this.setStudent_ID(id);
		this.studentName = name;
		this.subjects = subjects;
		setAvg();
		setHighest();
		setLowest();
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}

	public int getStudent_ID() {
		return student_ID;
	}

	public void setStudent_ID(int student_ID) {
		this.student_ID = student_ID;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg() {
		
		float sum = 0;
		for(int i =0 ; i < subjects.size();i++) {
			sum+=subjects.get(i).getScore();
		}
		this.avg = sum / subjects.size();
	}

	public Subject getHighest() {
		return highest;
	}

	public void setHighest() {
		Subject max = subjects.get(0);
		for(int i =1 ; i < subjects.size();i++) {
			if(subjects.get(i).getScore() > max.getScore()) {
				max = subjects.get(i);
			}
		}
		this.highest = max;
	}

	public Subject getLowest() {
		return lowest;
	}

	public void setLowest() {
		Subject min = subjects.get(0);
		for(int i =1 ; i < subjects.size();i++) {
			if(subjects.get(i).getScore() < min.getScore()) {
				min = subjects.get(i);
			}
		}
		this.lowest = min;
	}

}
