package com.bridgeimpact.renewal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeimpact.renewal.dao.BoardDAO;
import com.bridgeimpact.renewal.dto.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
    private BoardDAO boardDAO;
    
	
	@Override
	public List<BoardVO> selectAllBoard(String delGb) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectAllBoard(delGb);
	}
	

	@Override
	public List<BoardVO> selectAllBoard() throws Exception {
		return boardDAO.selectAllBoard();
	}


	@Override
	public void insertBoard(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.insertBoard(board);
	}


	@Override
	public int checkBoardId(String id) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardCntById(id);
	}


	@Override
	public int closeBoard(String id) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.deleteBoardById(id);
	}


	@Override
	public int openBoard(String id) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.unDeleteBoardById(id);
	}


	@Override
	public int checkBoardStatusById(String id) throws Exception {
		// TODO Auto-generated method stub
		int boardDelgbResult = 0;
		
		if ("N".equals(boardDAO.selectBoardDelgbById(id))) {
			boardDelgbResult = 1;
		}
		return boardDelgbResult;
	}


	@Override
	public BoardVO getBoardByid(String id) throws Exception {
		return boardDAO.selectBoardById(id);
	}



}
