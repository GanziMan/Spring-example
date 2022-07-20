package com.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.model.Member;
import com.crud.model.Meta_Basic;
import com.crud.model.TestVo;

@Repository
public interface MetaRepository extends JpaRepository<Meta_Basic, String> {

	Optional<Meta_Basic> findById(String identifier);



	

	
}
 