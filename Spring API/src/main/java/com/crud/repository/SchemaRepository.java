package com.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Schema_Info;

@Repository
public interface SchemaRepository extends JpaRepository<Schema_Info, String> {

	public Optional<Schema_Info> findById(String identifier); 
}