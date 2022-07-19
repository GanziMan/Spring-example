package com.crud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Meta_Basic;
import com.crud.repository.ARepository;
import com.crud.repository.MetaRepository;

@Service
public class Meta_Service implements IMeta_Service {

	
	@Autowired
	MetaRepository	metaRepository;
	

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public List<Meta_Basic> getmeta_basicList() {
		// TODO Auto-generated method stub
		List<Meta_Basic> result= metaRepository.findAll();
	
		return result;
	}

}
 