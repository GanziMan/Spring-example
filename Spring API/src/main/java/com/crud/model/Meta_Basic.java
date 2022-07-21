package com.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.websocket.Decoder.Text;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@Setter
@Table(name="ds_meta_basic")	
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Meta_Basic {
	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Id
	@GeneratedValue	
	private String identifier;
	private String accessRights;
	private Long id;
	private String contactPoint_name;
	private String contactPoint_mail;
	private String contactPoint_phone;
	private String creator_name;
	private String creator_mail;
	private String creator_phone;
	private String creator_homepage;
	private String description;
	private String title;
	private String issued;
	private String modifed;
	private String language;
	private String publisher_name;
	private String publisher_mail;
	private String publisher_phone;
	private String publisher_homepage;
	private String theme;
	private String type;
	private String keyword;
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
