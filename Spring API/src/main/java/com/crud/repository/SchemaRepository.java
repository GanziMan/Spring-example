package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.model.Schema_Info;

public interface SchemaRepository extends JpaRepository<Schema_Info, String> {

}
