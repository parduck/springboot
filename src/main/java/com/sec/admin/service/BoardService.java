package com.sec.admin.service;

import java.util.List;

import com.sec.domain.Search;
import com.sec.vo.BoardVO;

public interface BoardService {

	List<BoardVO> getBoardList(Search search);

	void insertBoard(BoardVO board);

	BoardVO getBoard(BoardVO board);

	void updateBoard(BoardVO board);

	void deleteBoard(BoardVO board);

}