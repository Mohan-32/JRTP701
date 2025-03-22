package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.PlanEntity;

public interface IPlanRepository extends JpaRepository<PlanEntity, Integer> {

}
