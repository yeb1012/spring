package com.yedam.app;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardVO;
import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class MapperTest2 {
	
	@Autowired
	BoardMapper boardMapper;
	
	//전체조회
	@Test
	public void selectAll() {
		List<BoardVO> list = boardMapper.selectBoardList();
		assertTrue(!list.isEmpty());
	}
	
	//단건조회
	//@Test
	public void selectInfo() {
		BoardVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		BoardVO findVO = boardMapper.selectBoard(empVO);
		assertEquals(findVO.getLastName(), "King");
	}
	
	//등록
	//@Test
	public void insertInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("kdong@google.com");
		empVO.setHireDate(new Date("24/01/15"));
		empVO.setJobId("IT_PROG");
		empVO.setSalary(10000);
		
		int result = boardMapper.insertEmpInfo(empVO);
		assertNotEquals(result, 0);
		//assertNotEquals(empVO.getEmployeeId(), 0);
	}
	
	//수정
	//@Test
	public void updateInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(207);
		EmpVO findVO = boardMapper.selectBoard(empVO);
		findVO.setLastName("Kang");
		int result = boardMapper.updateEmpInfo(findVO);
		assertNotEquals(result, 0);
	}
	
	
	//삭제
	//@Test
	public void deleteInfo() {
		int result = boardMapper.deleteEmpInfo(207);
		assertNotEquals(result, 0);
	}
	
}
