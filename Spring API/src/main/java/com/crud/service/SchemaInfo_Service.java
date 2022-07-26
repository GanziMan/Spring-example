package com.crud.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Schema_Info;
import com.crud.repository.SchemaRepository;

@Service
public class SchemaInfo_Service {
	
	@Autowired
	SchemaRepository schemaRepository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<Schema_Info> getschema_List() {
		// TODO Auto-generated method stub
		List<Schema_Info> result= schemaRepository.findAll();
	
		return result;
	}
	public Optional<Schema_Info> findById(String identifier){
		Optional<Schema_Info> result = schemaRepository.findById(identifier);
		return result;
	}
//	public Optional<Meta_Basic> findById(String identifier) {
//		Optional<Meta_Basic> meta_basic = metaRepository.deleteAllById(identifier);
//		return meta_basic;
//	}
//
//	public Optional<TestVo> findById(Long mbrNo){
//		Optional<TestVo> member = testMemberRepository.findById(mbrNo);
//		return member;
//	}
	
	public void updateById(Schema_Info member) {
		Optional<Schema_Info> e=  schemaRepository.findById(member.getIdentifier());
		
		if(e.isPresent()) {
			e.get().setIdentifier(member.getIdentifier()); 
			schemaRepository.save(member);
		
		}
	}
	
	public void deleteById(String identifier) {
		schemaRepository.deleteById(identifier);
	}
	
	public Schema_Info save(Schema_Info data) {
		System.out.println(data.toString());
		logger.info(data.getIdentifier());
		schemaRepository.save(data);
		return data;
	}

	
}