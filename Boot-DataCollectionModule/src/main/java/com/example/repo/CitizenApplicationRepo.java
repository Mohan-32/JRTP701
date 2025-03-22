package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CitizenApplicationEntity;

public interface CitizenApplicationRepo extends JpaRepository<CitizenApplicationEntity, Integer> {

}
