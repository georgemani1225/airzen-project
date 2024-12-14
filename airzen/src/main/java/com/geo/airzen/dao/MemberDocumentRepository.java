package com.geo.airzen.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.geo.airzen.entity.MemberDocumentInfo;

public interface MemberDocumentRepository extends JpaRepository<MemberDocumentInfo, Integer> {
	
	List<MemberDocumentInfo> findByMemid(Integer memid);
	
}
