package com.sec.admin;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sec.domain.Board;
import com.sec.repo.BoardRepository;

@SpringBootTest
public class QueryMethodTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testFindByTitle() {
		List<Board> boardList =boardRepo.findByTitle("first test");
		System.out.println("검색결과");
		for(Board board:boardList) {
			System.out.println("-->"+board.toString());			
		}
	}

	@Test
	public void testByContentContaining() {
		Pageable paging = PageRequest.of(0, 2,Sort.Direction.DESC,"seq");
		Page<Board> pageInfo = boardRepo.findByContentContaining("right",paging);
		
		System.out.println("paging like검색:"+pageInfo.getSize()+":"+pageInfo.getTotalElements());
		List<Board> boardList = pageInfo.getContent();
		for(Board board : boardList) {
			System.out.println("-->"+board.toString());
		}
	}
	
	@Test
	public void findByTitleContainingOrContentContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("test","123");
		
		System.out.println("OR검색:");
		for(Board board : boardList) {
			System.out.println("-->"+board.toString());
		}
	}
	
}
