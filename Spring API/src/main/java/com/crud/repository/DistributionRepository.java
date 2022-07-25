package com.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Meta_Distribution;

@Repository
public interface DistributionRepository extends JpaRepository<Meta_Distribution, String> {

	public Optional<Meta_Distribution> findById(String identifier); 
}
