package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.model.Meta_Distribution;
import com.crud.repository.DistributionRepository;

@Service
public class Distribution_Service {

	@Autowired
	DistributionRepository distributionRepository;
	
	public List<Meta_Distribution> getmeta_distributionList(){
		
		List<Meta_Distribution> result = distributionRepository.findAll();
		return result;
		}
	
	public Optional<Meta_Distribution> findById(String identifier){
		Optional<Meta_Distribution> result =distributionRepository.findById(identifier);
			return result;
	}
	
	public void updateById(Meta_Distribution member) {
		Optional<Meta_Distribution> result = distributionRepository.findById(member.getIdentifier());
		if(result.isPresent()) {
			result.get().setIdentifier(member.getIdentifier()); 
			distributionRepository.save(member);
		}
	}
	
	public void deleteById(String identifier) {
		distributionRepository.deleteById(identifier);
	}
	
	public Meta_Distribution save(Meta_Distribution data) {
		System.out.println(data.toString());
		distributionRepository.save(data);
		return data;
	}
	
	
	}

