package com.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ds_meta_basic")
@AllArgsConstructor
@NoArgsConstructor
public class Meta_Basic {

	@Id
	@Column(name = "identifier",unique=true)
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // 
	private String identifier;
	private String accessRights;
	private String contactPoint_name;
	private String contactPoint_mail;
	private String contactPoint_phone;
	private String creator_name;
	private String creator_mail;
	private String creator_phone;
	private String creator_homepage;
	private String title;
	private String issued;
	private String modified;
	private String language;
	private String publisher_name;
	private String publisher_mail;
	private String publisher_phone;
	private String publisher_homepage;
	private String theme;
	private String type;
	private String landingPage;
	private String license;
	private String rights;
	private String distribution;
	private String spatialResolutionInMeters;
	private String temporalResolution;
	private String accrualPeriodicity;
	private String spatial;
	private String temporal;
	private String metadata_type;
	private String endpointURL;
	private String previewURL;
}
