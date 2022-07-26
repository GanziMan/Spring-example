package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Meta_Basic;
import com.crud.repository.MetaMapper;
import com.crud.repository.MetaRepository;

@Service
public class Meta_Service {

	
	@Autowired
	MetaRepository	metaRepository;
	

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<Meta_Basic> getmeta_basicList() {
		// TODO Auto-generated method stub
		
		List<Meta_Basic> result= metaRepository.findAll();
	
		return result;
	}
	public Optional<Meta_Basic> findById(String identifier){
		Optional<Meta_Basic> result = metaRepository.findById(identifier);
		return result;
	}
	
	public List<Meta_Basic> findAll(){
		List<Meta_Basic> result = metaRepository.findAll();
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
	
	public void updateById(Meta_Basic member) {
		Optional<Meta_Basic> e=  metaRepository.findById(member.getIdentifier());
		
		if(e.isPresent()) {
			e.get().setIdentifier(member.getIdentifier()); 
			metaRepository.save(member);
		
		}
	}
	
	public void deleteById(String identifier) {
		metaRepository.deleteById(identifier);
	}
	
	public Meta_Basic save(Meta_Basic data) {
		System.out.println(data.toString());
		logger.info(data.getIdentifier());
		metaRepository.save(data);
		return data;
	}
	
	public List<Meta_Basic> filterlist_name(){
		List<Meta_Basic> result = metaRepository.filterlist_name();
		return result;
	}
	public List<Meta_Basic> filterlist_type(){
		List<Meta_Basic> result = metaRepository.filterlist_name();
		return result;
	}
	public List<Meta_Basic> filterlist_theme(){
		List<Meta_Basic> result = metaRepository.filterlist_name();
		return result;
	}
	

	
}
 