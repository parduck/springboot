package com.sec.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.sec.domain.Board;

public interface BoardRepository extends JpaRepository<Board,Long>,QuerydslPredicateExecutor<Board>{
	@Query("SELECT b FROM Board b")
	List<Board> getBoardList();
	
	List<Board> findByTitle(String searchKeyword);
	
	Page<Board> findByContentContaining(String searchKeyword, Pageable paging);
	
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);

}
