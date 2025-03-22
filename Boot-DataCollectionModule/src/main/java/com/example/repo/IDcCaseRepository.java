package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.DcCaseEntity;

public interface IDcCaseRepository extends JpaRepository<DcCaseEntity, Integer> {

	
	public Integer findByCaseNo(int caseNo);
}
