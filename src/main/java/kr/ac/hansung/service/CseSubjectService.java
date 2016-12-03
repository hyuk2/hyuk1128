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
	
	public List<CseSubject> getCurrent(){//dao Ȱ�� 
		return subjectDao.getSubjects();
	}

	//�б⺰ �̼����� ��ȸ(�⵵ �б� �̼����� �󼼺���)
	public List<Term> getTermCredit(){
		List<Term> termList = subjectDao.getTermCreditOrderedByYT();
		
		for(Term t:termList){
			int sumOfCredit = subjectDao.getSumOfTermCredit(t.getYear(), t.getSemester());
			t.setSumOfCredit(sumOfCredit);
		}
		return termList;
	}
	
	//�̼� ���к� ���
	public List<String>getSectionList(){
		List<String>sectionList = subjectDao.getSection();
		return sectionList;
	}
	
	//�̼� ���к� ��ȸ�ϱ�
	public int[] getSumOfSectionCredit(List<String>section){
		int len = section.size();
		int [] sumOfCredit = new int[len];
		for(int i=0;i<len;i++){
			sumOfCredit[i] = subjectDao.getSumofSectionCredit(section.get(i));
		}
		return sumOfCredit;
	}
	//���� ��û ���
	public List<CseSubject> getRegisteredSubject() {
		List<CseSubject>subjectList = subjectDao.getRegisteredSubject();
		return subjectList;
	}

	// �б⺰ �̼� ���� ��ȸ����  �󼼺��� ��ũ Ŭ��
	public List<CseSubject> getMoreSubjectList(int year, int semester) {
		List<CseSubject> subjectList = subjectDao.getSubject(year, semester);
		return subjectList;
	}
	

	

	public void insert(CseSubject subject) {
		subjectDao.insert(subject);
		
	}
	
	
	
	

}
