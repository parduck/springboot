package com.sec.admin.dao;

import java.util.List;

import com.sec.domain.Board;
import com.sec.vo.BoardVO;

public interface BoardDao {

	List<BoardVO> getBoardList(BoardVO board);

	void insertBoard(BoardVO board);

	BoardVO getBoard(BoardVO board);

	void updateBoard(BoardVO board);

	void deleteBoard(BoardVO board);

}