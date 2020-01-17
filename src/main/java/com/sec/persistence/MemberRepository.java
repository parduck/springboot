package com.sec.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.admin.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
