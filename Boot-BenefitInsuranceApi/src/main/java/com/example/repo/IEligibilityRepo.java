package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.EligibilityDeterminationEntity;

public interface IEligibilityRepo extends JpaRepository<EligibilityDeterminationEntity, Integer> {

}
