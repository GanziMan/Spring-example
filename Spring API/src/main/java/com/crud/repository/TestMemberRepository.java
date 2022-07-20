package com.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crud.model.TestVo;

@Repository
public interface TestMemberRepository extends JpaRepository<TestVo, Long> {

	public List<TestVo> findById(String id);

	public List<TestVo> findByName(String name);

	// like검색도 가능
	public List<TestVo> findByNameLike(String keyword);
	
}

