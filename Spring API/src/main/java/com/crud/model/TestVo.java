package com.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity(name="Testmember")
public class TestVo {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long mbrNo;
		
		private Long num;

	    private String id;

	    private String name;

	    @Builder
	    public TestVo(String id, String name) {
	        this.id = id;
	        this.name = name;
	    }

}
