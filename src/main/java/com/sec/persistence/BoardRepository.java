package com.sec.persistence;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.sec.admin.domain.Board;


public interface BoardRepository extends JpaRepository<Board,Long>{
	List<Board> findByTitle(String searchKeyword);
	
	Page<Board> findByContentContaining(String searchKeyword, Pageable paging);
	
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);

}
