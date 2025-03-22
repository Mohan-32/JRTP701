package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.DcEducationEntity;

public interface IDcEducationRepository extends JpaRepository<DcEducationEntity, Integer> {

	
	public DcEducationEntity findByCaseNo(int caseNo);
}
