package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.DcIncomeEntity;

public interface IDcIncomeRepository extends JpaRepository<DcIncomeEntity, Integer> {

	
	public DcIncomeEntity findByCaseNo(int caseNo);
}

