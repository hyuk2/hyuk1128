package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CseSubjectDAO;
import kr.ac.hansung.model.CseSubject;
import kr.ac.hansung.model.Term;

@Service
public class CseSubjectService {
	
	public CseSubjectDAO subjectDao;

	@Autowired
	public void setOfferDao(CseSubjectDAO subjectDao) {
		this.subjectDao = subjectDao;
	}
	
	public List<CseSubject> getCurrent(){//dao 활용 
		return subjectDao.getSubjects();
	}

	//학기별 이수학점 조회(년도 학기 이수학점 상세보기)
	public List<Term> getTermCredit(){
		List<Term> termList = subjectDao.getTermCreditOrderedByYT();
		
		for(Term t:termList){
			int sumOfCredit = subjectDao.getSumOfTermCredit(t.getYear(), t.getSemester());
			t.setSumOfCredit(sumOfCredit);
		}
		return termList;
	}
	
	//이수 구분별 목록
	public List<String>getSectionList(){
		List<String>sectionList = subjectDao.getSection();
		return sectionList;
	}
	
	//이수 구분별 조회하기
	public int[] getSumOfSectionCredit(List<String>section){
		int len = section.size();
		int [] sumOfCredit = new int[len];
		for(int i=0;i<len;i++){
			sumOfCredit[i] = subjectDao.getSumofSectionCredit(section.get(i));
		}
		return sumOfCredit;
	}
	//수강 신청 목록
	public List<CseSubject> getRegisteredSubject() {
		List<CseSubject>subjectList = subjectDao.getRegisteredSubject();
		return subjectList;
	}

	// 학기별 이수 학점 조회에서  상세보기 링크 클릭
	public List<CseSubject> getMoreSubjectList(int year, int semester) {
		List<CseSubject> subjectList = subjectDao.getSubject(year, semester);
		return subjectList;
	}
	

	

	public void insert(CseSubject subject) {
		subjectDao.insert(subject);
		
	}
	
	
	
	

}
