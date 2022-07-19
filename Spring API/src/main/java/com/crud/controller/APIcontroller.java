
package com.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Car;
import com.crud.model.Member;
import com.crud.model.Meta_Basic;
import com.crud.service.IMeta_Service;
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
	@Autowired
	private IMeta_Service iMeta_Service;

	
//	 @RequestMapping(method = RequestMethod.POST, path = "/pos2") //post api
//	    public PostRequestDTO postRequestAnotherApi(@RequestBody PostRequestDTO infoVO){ // ReqyestBody 어노테이션을 붙여주지 않으니까 body에 넣어준 데이터가 null로 온다.
//		 return infoVO;
//	    }
//	 
	@GetMapping("/alivecheck") 
	public ResponseEntity<String> alivecheck() {
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

	@GetMapping("/ds_basic_meta/select")
	public List<Meta_Basic> metaselect() {
		
		List<Meta_Basic> meta_basic = iMeta_Service.getmeta_basicList();
		return meta_basic;
	}
	
	@GetMapping("/test")
	public List<Car> list(){
		List<Car> returnList = new ArrayList<>();
		List<Meta_Basic> meta_basic = iMeta_Service.getmeta_basicList();
		HashMap<String, Object> status_result= new LinkedHashMap<String, Object>();

		status_result.put("status",200);
		status_result.put("message", "전체 사용자조회 성공");
		status_result.put("data","조회");
		Car car = new Car.Builder("f", "f")    // 필수값 입력
				.resultCode("0000")
				.list(new ArrayList<>(meta_basic))
				.resultMsg("Everything is working")
			    .build();
		
		returnList.add(car);
		return returnList;
	}
	
	
	  
}