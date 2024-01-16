package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	//@Autowired
	//DeptService deptService;
	
	//GET : 단순조회, 빈페이지를 호출하는 경우(ex,회원가입, 게시물 작성)-post는 바디가 있어야한다 -> 뭔가 정보가 있어야 한다
	//POST : 데이터 조작관련(등록, 수정, 삭제) get보다 보안상 낫다
	
	//전체조회
		@GetMapping("empList")
		public String getEmpList(Model model) {
			List<EmpVO> list = empService.getEmpAll();
			model.addAttribute("empList", list);
			return "emp/empList";
			
		}
		
	//사원조회
		@GetMapping("empInfo")
		public String getEmpInfo(EmpVO empVO, Model model) {
			EmpVO findVO = empService.getEmpInfo(empVO);
			model.addAttribute("empInfo",findVO);		
			return "emp/empInfo";
		}
	//사원등록 - FORM
		@GetMapping("empInsert")
		public String insertEmpInfoForm() {
			
			return "emp/empInsert";
		}
	//사원등록 - PROCESS
		@PostMapping("empInsert") //같은 기능을 위해 만들어진 FORM과 PROCESS 경로 같음
		public String insertEmpInfoProcess(EmpVO empVO) {
			int empId = empService.insertEmpInfo(empVO);
			
			String path = null;
			if(empId > -1) {
				path = "redirect:empInfo?employeeId="+empId; //get방식으로 넘기는게 디폴트
			}else {
				path = "redirect:empList";
			}
			
			return path;
		}
	//사원수정 -PROCESS : Ajax => @ResponseBody
		//1) QueryString =>커맨드 객체
			 @PostMapping("empUpdate")
			 @ResponseBody
			 public Map<String, Object> empUpdateProcess(EmpVO empVO){
			 return empService.updateEmpInfo(empVO);
			}
		//2) JSON =>@RequestBody
			 @PostMapping("empUpdateAjax")
			 @ResponseBody
			 public Map<String, Object> empUpdateAjaxProcess(EmpVO empVO){
			 return empService.updateEmpInfo(empVO);
			}
	//사원삭제 -PROCESS

	
	
}
