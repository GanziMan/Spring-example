package com.crud.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.model.Member;

@Repository
public interface ARepository extends JpaRepository<Member, Long> {

	@Query(value="SELECT * from ds_meta_basic",nativeQuery=true)
	List<Member> findbyDepartmentALL(String department);
	
}
