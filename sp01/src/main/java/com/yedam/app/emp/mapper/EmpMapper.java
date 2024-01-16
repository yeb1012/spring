package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	//전체조회
	public List<EmpVO> selectEmpList();
	
	//단건조회
	public EmpVO selectEmpInfo(EmpVO empvo);
	
	//등록
	public int insertEmpInfo(EmpVO empVO);
	
	//수정
	public int updateEmpInfo(EmpVO empvo);
	
	//삭제
	public int deleteEmpInfo(int empId);
	
	//수정: 변경 데이터만 수정
	public int updateEmpInfoDynamic(EmpVO empvo);
	//수정: 매개변수가 두개인 경우
	public int updateEmpSal(@Param("eid") int empId, @Param("info") EmpVO empVO);
	//
}
