package com.crud.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.crud.model.Meta_Basic;

@Repository
public interface MetaRepository extends JpaRepository<Meta_Basic, String> {

	public Optional<Meta_Basic> findById(String identifier); 

//
//	// like검색도 가능
//	public List<Meta_Basic> findByNameLike(String keyword);
}
   	