package com.yedam.app.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	

	public List<BoardVO> getBoardAll();
	
	public BoardVO getBoardInfo(BoardVO boardVO);
	
	public int insertBoardInfo(BoardVO boardVO);
	
	public Map<String, Object> updateBoardInfo(BoardVO boardVO);
	
	public boolean deleteBoardInfo(int boardNO);
}
