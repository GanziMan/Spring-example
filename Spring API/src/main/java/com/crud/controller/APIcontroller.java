
package com.crud.controller;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Member;
import com.crud.service.MemberService;


@RestController
@RequestMapping("/mms")
public class APIcontroller {   
   
	
//	private static final String Alive="alive";
//	
//
//	private final AtomicLong counter =new AtomicLong();
	
	@Autowired
	private MemberService memberService;
	
//	 @RequestMapping(method = RequestMethod.POST, path = "/pos2") //post api
//	    public PostRequestDTO postRequestAnotherApi(@RequestBody PostRequestDTO infoVO){ // ReqyestBody 어노테이션을 붙여주지 않으니까 body에 넣어준 데이터가 null로 온다.
//		 return infoVO;
//	    }
//	 
	 @GetMapping("/alivecheck") //post api
	   public ResponseEntity<String> alivecheck(){
		 HashMap<String, Object> result = new LinkedHashMap<String, Object>();
		 
		 result.put("status", 400);
		 result.put("message", "parameter null");
		 result.put("data", "실패");
		 
		 return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
	 }
	 
	 @GetMapping("/select")
	 public List<Member> select() {
		 
		 List<Member> member = memberService.getMemberList();
		 
		 return member;
	 }
}