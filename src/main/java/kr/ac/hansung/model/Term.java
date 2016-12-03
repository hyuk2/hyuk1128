package kr.ac.hansung.model;

public class Term {
	
	private int year;
	private int semester;
	private int sumOfCredit;
	
	public Term(){}
	public Term(int year, int semester, int sumOfCredit) {
		super();
		this.year = year;
		this.semester = semester;
		this.sumOfCredit = sumOfCredit;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getSumOfCredit() {
		return sumOfCredit;
	}
	public void setSumOfCredit(int sumOfCredit) {
		this.sumOfCredit = sumOfCredit;
	}
	
	

}
