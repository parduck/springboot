package com.sec.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
