package com.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ds_meta_distribution")
@AllArgsConstructor
@NoArgsConstructor
public class Meta_Distribution {

	@Id
	@Column(name="identifier")
	private String identifier;
	private String accessService;
	private String accessURL;
	private Long byteSize;
	private String compressFormat;
	private String downloadURL;
	private String mediaType;
	private String packageFormat;
	private String spatialResolutionInMeters;
	private String temporalResolution;
	private String accessRights;
	private String description;
	@Column(name="format")
	private String format;
	private String issued;
}
