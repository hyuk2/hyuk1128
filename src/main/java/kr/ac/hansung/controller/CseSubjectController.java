package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.model.CseSubject;
import kr.ac.hansung.model.Term;
import kr.ac.hansung.service.CseSubjectService;

@Controller

public class CseSubjectController {
	
private CseSubjectService cseSubjectService;
	

	@Autowired
	public void setCseSubjectService(CseSubjectService cseSubjectService) {
		this.cseSubjectService = cseSubjectService;
	}
	
	@RequestMapping("/termCredit")//�б⺰ �̼� ���� ��ȸ
	public String showCreditPerSemester(Model model){
		//List<CseSubject>termCredit = cseSubjectService.getCurrent();//offers���̺� �ִ� ������ ����Ʈ�� �о��
		//model.addAttribute("termCredit",termCredit);//�о�� ����Ʈ�� �𵨿� ����
		List<Term>termList = cseSubjectService.getTermCredit();
		model.addAttribute("termCredit",termList);
		return "termCredit";//termCredit ��� �ѱ�.���� ��� �Ѱ� ���
	}
	//�б⺰ �̼� ���� ��ȸ���� �󼼺���
	@RequestMapping("/termCredit/forMore")
	public String showSubjectList(Model model,int year, int semester){
		List<CseSubject>subjectList = cseSubjectService.getMoreSubjectList(year, semester);
		
		model.addAttribute("subjectList",subjectList);
		
		return "forMore";
	}
	
	
	//�̼� ���к� ��ȸ
	@RequestMapping("/categoryCredit")
	public String showCreditPerCategory(Model model){
		
		List<String>sectionList = cseSubjectService.getSectionList();
		/////////////////????
		int[]sectionCredit = cseSubjectService.getSumOfSectionCredit(sectionList);
		int sum=0;
		for(int i=0;i<sectionCredit.length;i++){
			sum += sectionCredit[i];
			}
		
		model.addAttribute("sectionCredit",sectionCredit);
		model.addAttribute("sectionList",sectionList);
		model.addAttribute("sum",sum);
		return "categoryCredit";
	}
	@RequestMapping("/signUp")
	public String signUp(){
		return "signUp";
	}
	
	//���� ��û ���� ��ȸ
	@RequestMapping("/checkSignUpResult")
	public String checkSignUpResult(Model model){
		
		List<CseSubject>RegisteredList = cseSubjectService.getRegisteredSubject();
		model.addAttribute("RegisteredList",RegisteredList);
		return "result";
	}
	
	@RequestMapping("/doResister")
	public String doRegister(Model model, CseSubject cseSubject){
		cseSubjectService.insert(cseSubject);
		return "cseSubjectCreated";
	}

}
