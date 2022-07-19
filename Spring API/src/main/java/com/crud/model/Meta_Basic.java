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
	private String accessRights;
	
	
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
	
	public String getContactPoint_name() {
		return contactPoint_name;
	}

	public void setContactPoint_name(String contactPoint_name) {
		this.contactPoint_name = contactPoint_name;
	}

	public String getContactPoint_mail() {
		return contactPoint_mail;
	}

	public void setContactPoint_mail(String contactPoint_mail) {
		this.contactPoint_mail = contactPoint_mail;
	}

	public String getContactPoint_phone() {
		return contactPoint_phone;
	}

	public void setContactPoint_phone(String contactPoint_phone) {
		this.contactPoint_phone = contactPoint_phone;
	}

	public String getCreator_mail() {
		return creator_mail;
	}

	public void setCreator_mail(String creator_mail) {
		this.creator_mail = creator_mail;
	}

	public String getCreator_phone() {
		return creator_phone;
	}

	public void setCreator_phone(String creator_phone) {
		this.creator_phone = creator_phone;
	}

	public String getCreator_homepage() {
		return creator_homepage;
	}

	public void setCreator_homepage(String creator_homepage) {
		this.creator_homepage = creator_homepage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIssued() {
		return issued;
	}

	public void setIssued(String issued) {
		this.issued = issued;
	}

	public String getAccessRights() {
		return accessRights;
	}

	public void setAccessRights(String accessRights) {
		this.accessRights = accessRights;
	}

	public String getCreator_name() {
		return creator_name;
	}
	
		public void setCreator_name(String creator_name) {	
		this.creator_name = creator_name;
	}
		
	



	
}
