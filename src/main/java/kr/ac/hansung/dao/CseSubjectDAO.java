package kr.ac.hansung.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.CseSubject;
import kr.ac.hansung.model.Term;

@Repository
//@Component("offerDAO")
//@Component
public class CseSubjectDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		// ?��?�� ?��肄��� 紐�媛�?�몄�? 由ы��
		String sqlStatement = "select count(*)from csesubject";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class); // Integer.class??
	}

	// querying and returning a single object

	public CseSubject getSubject(String subject) {
		String sqlStatement = "select * from csesubject where subject=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { subject }, 
				new CseSubjectMapper());
	}

	// querying and returning multiple objects

	public List<CseSubject> getSubjects() {
		String sqlStatement = "select * from csesubject";
		return jdbcTemplateObject.query(sqlStatement, new CseSubjectMapper());
	}
	public List<Term> getTermCreditOrderedByYT() {
		String sqlStatement = 
				"select distinct year, semester from csesubject order by year, semester";
		return jdbcTemplateObject.query(sqlStatement, new TermMapper());
	}

	public int getSumOfTermCredit(int year, int term){
		String sqlStatement="select sum(credit) from csesubject where year=? and semester=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, 
				new Object[] { year,term }, 
				Integer.class);
		
	}
	
	public List<String>getSection(){
		String sqlStatement="select distinct section from csesubject";
		return jdbcTemplateObject.queryForList(sqlStatement, String.class);
	}
	public int getSumofSectionCredit(String section){
		String sqlStatement="select sum(credit) from csesubject where section=?";
		return jdbcTemplateObject.queryForObject(sqlStatement,new Object[] {section},
				Integer.class);
		
	}
	
	//수강 신청 조회 --2017년 1학기에 신청할 예상 교과목 신청한 것 조회
	public List<CseSubject>getRegisteredSubject(){
		String sqlStatement ="select*from csesubject where year='2017'";
		return jdbcTemplateObject.query(sqlStatement, new CseSubjectMapper());
				
	}
	
	// 학기별 이수 학점 조회에서 과목 링크 상세보기 클릭했을 때
		public List<CseSubject> getSubject(int year, int semester) {
			String sqlStatement = "select * from csesubject where year=? and semester=?";
			return jdbcTemplateObject.query(sqlStatement, new Object[] { year, semester }, 
					new CseSubjectMapper());
		}
	public boolean insert(CseSubject csesubject){
		
		 int year = csesubject.getYear();
		 int semester=csesubject.getSemester();
		 String code=csesubject.getCode();
		 String subject=csesubject.getSubject();
		 String section=csesubject.getSection();
		 int credit=csesubject.getCredit();
		/*String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();*/
	/*	String sqlStatement = "insert into offers (name,email,text) values (?,?,?)"; //?->place holder ?��?��!
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{name,email,text}) ==1);*/
		
		String sqlStatement = "insert into csesubject (year,semester,code,subject,section,credit) "
				+ "values (?,?,?,?,?,?)"; //?->place holder ?��?��!
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{year,semester,code,subject,
				section,credit}) ==1);
	}
	
	public boolean update(CseSubject csesubject){
		
		 int year = csesubject.getYear();
		 int semester=csesubject.getSemester();
		 String code=csesubject.getCode();
		 String subject=csesubject.getSubject();
		 String section=csesubject.getSection();
		 int credit=csesubject.getCredit();
		 
		/*int id = offer.getId();
		String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();*/
		/*String sqlStatement = "update offers set name=?, email=? ,text=? where id=?"; //?->place holder ?��?��!
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{name,email,text,id}) ==1);
		*/
		String sqlStatement = "update csesubject set year=?, semester=? ,code=?,subject=? ,section=?,"
				+ "credit=? where id=?"; //?->place holder ?��?��!
		return (jdbcTemplateObject.update(sqlStatement, 
				new Object[]{year,semester,code,subject,
						section,credit}) ==1);
	}
	
	public boolean delete(String subject){
		String sqlStatement = "delete from csesubject where subject=?";
		return (jdbcTemplateObject.update(sqlStatement,new Object[]{subject}) ==1);
		
	}


	
}
