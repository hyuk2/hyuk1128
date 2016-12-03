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
	
	@RequestMapping("/termCredit")//학기별 이수 학점 조회
	public String showCreditPerSemester(Model model){
		//List<CseSubject>termCredit = cseSubjectService.getCurrent();//offers테이블에 있는 모든것을 리스트로 읽어옴
		//model.addAttribute("termCredit",termCredit);//읽어온 리스트를 모델에 저장
		List<Term>termList = cseSubjectService.getTermCredit();
		model.addAttribute("termCredit",termList);
		return "termCredit";//termCredit 뷰로 넘김.모델을 뷰로 넘겨 출력
	}
	//학기별 이수 학점 조회에서 상세보기
	@RequestMapping("/termCredit/forMore")
	public String showSubjectList(Model model,int year, int semester){
		List<CseSubject>subjectList = cseSubjectService.getMoreSubjectList(year, semester);
		
		model.addAttribute("subjectList",subjectList);
		
		return "forMore";
	}
	
	
	//이수 구분별 조회
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
	
	//수강 신청 내역 조회
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
