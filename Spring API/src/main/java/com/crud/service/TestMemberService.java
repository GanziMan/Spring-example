package com.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.TestVo;
import com.crud.repository.TestMemberRepository;

@Service
public class TestMemberService {

	@Autowired
	private TestMemberRepository testMemberRepository;
	
	public List<TestVo> findAll() {
        List<TestVo> members = new ArrayList<>();
        testMemberRepository.findAll().forEach(e -> members.add(e));
        return members;
    }
	
	public Optional<TestVo> findById(Long mbrNo){
		Optional<TestVo> member = testMemberRepository.findById(mbrNo);
		return member;
	}
	
	public void deleteById(Long mbrNo) {
		testMemberRepository.deleteById(mbrNo);
	}
	public TestVo save(TestVo member) {
		testMemberRepository.save(member);
		return member;
	}
	
	public void updateById(Long mbrNo, TestVo member) {
		Optional<TestVo> e= testMemberRepository.findById(mbrNo);
		
		if(e.isPresent()) {
			e.get().setMbrNo(member.getMbrNo());
			e.get().setId(member.getId());
			e.get().setName(member.getName());
		}
	}
}
