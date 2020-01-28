package com.sec.admin.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec.admin.dao.BoardDao;
import com.sec.domain.Board;
import com.sec.vo.BoardVO;

@Service
public class BoardBizImpl implements BoardBiz {
	//껍데기 impl을 먼저 만들고 alt+ shift+T
	
		@Autowired
		private BoardDao boardDao;
		
		@Override
		public List<BoardVO> getBoardList(BoardVO board){
			return (List<BoardVO>)boardDao.getBoardList(board);
		}
		
		@Override
		public void insertBoard(BoardVO board) {
			boardDao.insertBoard(board);
		}
		
		@Override
		public BoardVO getBoard(BoardVO board) {
			return boardDao.getBoard(board);
		}
		
		@Override
		public void updateBoard(BoardVO board) {
			boardDao.updateBoard(board);
			
		}
		
		@Override
		public void deleteBoard(BoardVO board) {
			boardDao.deleteBoard(board);
		}

}
