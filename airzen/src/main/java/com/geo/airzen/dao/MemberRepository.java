package com.geo.airzen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geo.airzen.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
