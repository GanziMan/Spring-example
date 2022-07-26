package com.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Member;
import com.crud.model.Meta_Basic;
import com.crud.model.Meta_Distribution;
import com.crud.model.Schema_Info;
import com.crud.repository.MetaMapper;
import com.crud.service.Distribution_Service;
import com.crud.service.MemberService;
import com.crud.service.Meta_Service;
import com.crud.service.SchemaInfo_Service;

@RestController
@RequestMapping("/mms")
public class APIcontroller {

//	private static final String Alive="alive";
//	
//
//	private final AtomicLong counter =new AtomicLong();

	@Autowired
	private MemberService memberService;
//	@Autowired
//	private TestMemberService testMemberService;
	@Autowired
	private Meta_Service meta_Service;
	@Autowired
	private Distribution_Service distribution_Service;
	@Autowired
	private SchemaInfo_Service schemainfo_Service;

//	 @RequestMapping(method = RequestMethod.POST, path = "/pos2") //post api
//	    public PostRequestDTO postRequestAnotherApi(@RequestBody PostRequestDTO infoVO){ // ReqyestBody 어노테이션을 붙여주지 않으니까 body에 넣어준 데이터가 null로 온다.
//		 return infoVO;
//	    }
//	 
	@GetMapping("/alivecheck")
	public ResponseEntity<String> alivecheck() {
		HashMap<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("message", "alive");

		return new ResponseEntity(result, HttpStatus.OK);
	}

	@GetMapping("/select")
	public List<Member> select() {

		List<Member> member = memberService.getMemberList();
		return member;
	}

	@GetMapping("/ds_basic_meta/select")
	public List<Meta_Basic> metaselect() {

		List<Meta_Basic> meta_basic = meta_Service.getmeta_basicList();
		return meta_basic;
	}

	@GetMapping("/basic-meta/metadata-list")
	public ResponseEntity<String> list() {


		List<Meta_Basic> meta_basic = meta_Service.getmeta_basicList();
		HashMap<String, Object> status_result = new LinkedHashMap<String, Object>();
		status_result.put("DatasetBasicInfos", meta_basic);

//		Car car = new Car.Builder()    // 필수값 입력
//				.list(new ArrayList<>(meta_basic))
//			    .build();
//		returnList.add(car);
		
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("resultCode", "0000");
		layout.put("resultData", status_result);
		layout.put("resultMsg", "Eyerything is working");

		return new ResponseEntity(layout, HttpStatus.OK);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "basic-meta/metadata-list/param")
	public ResponseEntity<Meta_Basic> list_identifier(@RequestParam("identifier") String identifier) {

		List<Object> resultList = new ArrayList<>();

		Optional<Meta_Basic> meta_Basic = meta_Service.findById(identifier);
		resultList.add(meta_Basic.get());
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("DatasetBasicInfos", resultList);

		HashMap<String, Object> layout2 = new LinkedHashMap<String, Object>();
		layout2.put("resultCode", "0000");
		layout2.put("resultData", layout);
		layout2.put("resultMsg", "Eyerything is working");

		return new ResponseEntity(layout2, HttpStatus.OK);
	}
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "basic-meta/filter-list")
	public ResponseEntity<Meta_Basic> basic_filterlist(@RequestParam("identifier") String identifier){
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		List<Meta_Basic> name = meta_Service.filterlist_name();
		List<Meta_Basic> type = meta_Service.filterlist_type();
		List<Meta_Basic> theme = meta_Service.filterlist_theme();
		layout.put("DataType", type);
		layout.put("Creator",  name);
		layout.put("Theme", theme);
		return new ResponseEntity(layout,HttpStatus.OK);
	}

//	@GetMapping("/basic-meta/metadata-list/{identifier}")
//	@ResponseBody
//	public List<Car> getId(@PathVariable String identifier) {
//		
//		List<Car> returnList = new ArrayList<>();
//		List<Meta_Basic> meta_Basic= iMeta_Service.getmeta_basicById();
//		HashMap<String, Object> status_result= new LinkedHashMap<String, Object>();
//		status_result.put("status",200);
//		status_result.put("message", "특정 사용자조회 성공");
//		status_result.put("data","조회");
//		
//		Car car =new Car.Builder()
//				.resultCode("0000")
//				.list(new ArrayList<>(meta_Basic))
//				.resultMsg("EveryThing work")
//				.build();
//
//		return returnList;
//	}

	// CRUD
	// ds_meta_basic/select_all
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "/ds_meta_basic/select_all")
	public ResponseEntity<List<Meta_Basic>> getAllmembers() {
		List<Meta_Basic> metadata = meta_Service.getmeta_basicList();
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("status", "200");
		layout.put("result", metadata);
		layout.put("message", "정상 호출");

		return new ResponseEntity(layout, HttpStatus.OK);
	}

	// ds_meta_basic/select_identifier
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "/ds_meta_basic/select_identifier")
	public ResponseEntity<Meta_Basic> getMember(@RequestParam("identifier") String identifier) {
		Optional<Meta_Basic> metadata = meta_Service.findById(identifier);
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("status", "200");
		layout.put("result", metadata.get());
		layout.put("message", "정상 호출");
		return new ResponseEntity(layout, HttpStatus.OK);
	}

	// ds_meta_basic/delete_schema
	@DeleteMapping(value = "/ds_meta_basic/delete_schema", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Meta_Basic> deleteMember(@RequestParam("identifier") String identifier) {
		meta_Service.deleteById(identifier);
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("status", "200");
		layout.put("result", "DATASET_DOUZONE_4 삭제완료");
		layout.put("message", "삭제 완료");
		return new ResponseEntity(layout, HttpStatus.OK);
	}

//	
//	
////	 회원번호로 회원삭제
//	@DeleteMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
//	    public ResponseEntity<Void> deleteMember(@PathVariable("mbrNo") Long mbrNo) {
//        testMemberService.deleteById(mbrNo);
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	    }
//	

	// 회원번호로 수
//	@PutMapping(value="/{mbrNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<TestVo> updateMember(@PathVariable("mbrNo") Long mbrNo, TestVo member){
//		testMemberService.updateById(mbrNo, member);
//		return new ResponseEntity<TestVo>(member, HttpStatus.OK);
//	}

	@PutMapping(value = "ds_meta_basic/update_schema", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Meta_Basic> updateMember(@RequestBody Meta_Basic member) {
		meta_Service.updateById(member);
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("status", "200");
		layout.put("result", "DATASET 업데이트 완료");
		layout.put("message", "업데이트 완료");
		return new ResponseEntity(layout, HttpStatus.OK);

	}

	// 회원 입력
//    @PostMapping                                                                                                                                         
//    public ResponseEntity<TestVo> save(TestVo member) {
//        return new ResponseEntity<TestVo>(testMemberService.save(member), HttpStatus.OK);
//    }  
	@PostMapping(value = "ds_meta_basic/insert_schema")
	public ResponseEntity<Meta_Basic> save(@RequestBody Meta_Basic data) {
		meta_Service.save(data);
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("status", "200");
		layout.put("result", "DATASET 추가");
		layout.put("message", "추가 완료");
		return new ResponseEntity(layout, HttpStatus.OK);
	}

	// 회원 입력
//	@RequestMapping(value = "/saveMember", method = RequestMethod.GET)
//	public ResponseEntity<TestVo> save(HttpServletRequest req, TestVo member) {
//		return new ResponseEntity<TestVo>(testMemberService.save(member), HttpStatus.OK);
//	}

	// ds_distribution/select_all
	@GetMapping(value = "ds_distribution/select_all", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Meta_Distribution>> getAlldistribution() {
		List<Meta_Distribution> metadata = distribution_Service.getmeta_distributionList();
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("status", "200");
		layout.put("result", metadata);
		layout.put("message", "정상 호출");

		return new ResponseEntity(layout, HttpStatus.OK);
	}

	// ds_distribution/select_identifier
	@GetMapping(value = "ds_distribution/select_identifier", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Meta_Distribution> getdistribution(@RequestParam("identifier") String identifier) {
		Optional<Meta_Distribution> metadata = distribution_Service.findById(identifier);
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("status", "200");
		layout.put("result", metadata.get());
		layout.put("message", "정상 호출");
		return new ResponseEntity(layout, HttpStatus.OK);
	}

	// ds_distribution/delete_schema
	@DeleteMapping(value = "/ds_distribution/delete_schema", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Meta_Distribution> deletedistribution(@RequestParam("identifier") String identifier) {
		distribution_Service.deleteById(identifier);
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("status", "200");
		layout.put("result", "DATASET_DOUZONE_4 삭제완료");
		layout.put("message", "삭제 완료");
		return new ResponseEntity(layout, HttpStatus.OK);
	}

	// ds_distribution/update_schema
	@PutMapping(value = "ds_distribution/update_schema", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Meta_Basic> updatedistribution(@RequestBody Meta_Distribution member) {
		distribution_Service.updateById(member);
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("status", "200");
		layout.put("result", "DATASET 업데이트 완료");
		layout.put("message", "업데이트 완료");
		return new ResponseEntity(layout, HttpStatus.OK);
	}

	// ds_distribution/insert_schema
	@PostMapping(value = "ds_distribution/insert_schema")
	public ResponseEntity<Meta_Distribution> save(@RequestBody Meta_Distribution data) {
		distribution_Service.save(data);
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("status", "200");
		layout.put("result", "DATASET 추가");
		layout.put("message", "추가 완료");
		return new ResponseEntity(layout, HttpStatus.OK);
	}

	// 여기서 부턴 schema_INFO crud api 명세서

	// ds_schema_info/select_all
	@GetMapping(value = "ds_schema_info/select_all", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Schema_Info>> getAllschemainfo() {
		List<Schema_Info> metadata = schemainfo_Service.getschema_List();
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("status", "200");
		layout.put("result", metadata);
		layout.put("message", "정상 호출");

		return new ResponseEntity(layout, HttpStatus.OK);
	}

	// ds_distribution/select_identifier
	@GetMapping(value = "ds_schema_info/select_identifier", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Schema_Info> getschemainfo(@RequestParam("identifier") String identifier) {
		Optional<Schema_Info> metadata = schemainfo_Service.findById(identifier);
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("status", "200");
		layout.put("result", metadata.get());
		layout.put("message", "정상 호출");
		return new ResponseEntity(layout, HttpStatus.OK);
	}

	// ds_distribution/delete_schema
	@DeleteMapping(value = "/ds_schema_info/delete_schema", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Schema_Info> deleteschemainfo(@RequestParam("identifier") String identifier) {
		schemainfo_Service.deleteById(identifier);
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("status", "200");
		layout.put("result", "DATASET_DOUZONE_4 삭제완료");
		layout.put("message", "삭제 완료");
		return new ResponseEntity(layout, HttpStatus.OK);
	}

	// ds_distribution/update_schema
	@PutMapping(value = "ds_schema_info/update_schema", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Schema_Info> updateschemainfo(@RequestBody Schema_Info member) {
		schemainfo_Service.updateById(member);
		HashMap<String, Object> layout = new LinkedHashMap<String, Object>();
		layout.put("status", "200");
		layout.put("result", "DATASET 업데이트 완료");
		layout.put("message", "업데이트 완료");
		return new ResponseEntity(layout, HttpStatus.OK);
	}
	// ds_distribution/insert_schema
	@PostMapping(value = "ds_schema_info/insert_schema")
	public ResponseEntity<Schema_Info> save(@RequestBody Schema_Info data) {

		return new ResponseEntity(schemainfo_Service.save(data), HttpStatus.OK);
	}
}