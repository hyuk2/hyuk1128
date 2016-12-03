package kr.ac.hansung.model;



public class CseSubject {
	//private int id;
	
	
	/*private String name;

	private String email;
	

	private String text;
	*/
	private int year;
	private int semester;
	private String code;
	private String subject;
	private String section;
	private int credit;
	
	
	
	public CseSubject(){}

	
	
	public CseSubject(int year, int semester, String code, String subject, String section, int credit) {
		super();
		this.year = year;
		this.semester = semester;
		this.code = code;
		this.subject = subject;
		this.section = section;
		this.credit = credit;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "CSE Subject [year=" + year + ", semester=" + semester + ", "
				+ "code=" + code + ", "
				+ "subject=" + subject +"section="+section+"credit="+credit+ "]";
	}

	
	

}
