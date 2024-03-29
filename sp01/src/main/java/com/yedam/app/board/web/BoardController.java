package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	
	//전체조회 : URI - boardList / RETURN - board/boardList
		@GetMapping("boardList")
		public String getBoardAll(Model model) {
			List<BoardVO> list = boardService.getBoardAll();
			model.addAttribute("boardList", list);
			return "board/boardList";
		}
	//단건조회 : URI - boardInfo / PARAMETER - BoardVO / RETURN - board/boardInfo
		@GetMapping("boardInfo")
		public String getBoardInfo(BoardVO boardVO, Model model ) {
			BoardVO findVO = boardService.getBoardInfo(boardVO);
			model.addAttribute("boardInfo", findVO);
			return "board/boardInfo";
		} 
	//등록 - 페이지 : URI - boardInsert / RETURN -board/boardInsert
		@GetMapping("boardInsert")
		public String insertBoardForm() {
			return "board/boardInsert";
		}
	//등록 - 처리 : URI - boardInsert / PARAMETER - BoardVO / RETURN - 전체조회 호출
		@PostMapping("boardInsert")
		public String boardInsertProcess(BoardVO boardVO) {
			boardService.insertBoardInfo(boardVO);
			return"redirect:boardList";
		}
	//수정 - 페이지 : URI - boardUpdate / RETURN -board/boardUpdate
		@GetMapping("boardUpdate")
		public String UpdateBoardForm(BoardVO boardVO, Model model) {
			BoardVO findVO = boardService.getBoardInfo(boardVO);
			model.addAttribute("boardInfo", findVO);
			return "board/boardUpdate";
		}
	//수정 - 처리 : URI - boardUpdate / PARAMETER - BoardVO / RETURN - 수정결과 데이터 (Map)
		@PostMapping("boardUpdate")
		@ResponseBody
		public Map<String, Object> getBoardUpdate( @RequestBody BoardVO boardVO) {
			return boardService.updateBoardInfo(boardVO);
		}
	//삭제	
		 @GetMapping("boardDelete")
		 public String boardDelete(@RequestParam Integer bno) { //requestParam을 쓰느 순간 필수값이 됨 저 부분이 없이 값을 넘기면 오류가 됨
			 boardService.deleteBoardInfo(bno);
			 return "redirect:boardList";
		 }
}
