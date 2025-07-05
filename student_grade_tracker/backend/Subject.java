package backend;

public class Subject {
	private String subjectName;
	private char garde;
	private int score;
	
	public Subject(String subjectName , int score) {
		this.setSubjectName(subjectName);
		this.score = score;
		this.setGarde(calcGrade());
	}
	
	public char calcGrade() {
		if(this.score >= 90) {
			return 'A';
		}
		if(this.score >= 80) {
			return 'B';
		}
		if(this.score >= 70) {
			return 'C';
		}
		if(this.score >= 60) {
			return 'D';
		}else {
			return 'F';
		}
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public char getGarde() {
		return garde;
	}

	public void setGarde(char garde) {
		this.garde = garde;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
}
