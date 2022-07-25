package com.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ds_schema_info")
@AllArgsConstructor
@NoArgsConstructor        
public class Schema_Info {
	@Id
	@Column(name="identifier")
	private String identifier;
	@Column(name="number")
	private String number;
	@Column(name="column_name")
	private String column_nmae;
	@Column(name="column_code")
	private String column_code;
	@Column(name="data_type")
	private String column_type;
	@Column(name="primary_key")
	private String primary_key;
	@Column(name="foriegn_key")
	private String foriegn_key;
	@Column(name="required")
	private String required;
	@Column(name="default_value")
	private String default_value;
	@Column(name="restricted")
	private String restricted;
	@Column(name="sensitive_data")
	private String sensitive_data;
	@Column(name="remarks")
	private String remarks;
}
