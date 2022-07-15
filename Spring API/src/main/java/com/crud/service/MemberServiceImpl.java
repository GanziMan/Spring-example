package com.crud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Member;
import com.crud.repository.ARepository;

@Service
public class MemberServiceImpl implements MemberService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ARepository aRepository;
	
	@Override
	public List<Member> getMemberList() {
		
		List<Member> result = aRepository.findAll();
		for(int i=0; i<result.size(); i++) {
			logger.info(result.get(i).getUsername());
		}
		
		return result;
	}

	
	
}
