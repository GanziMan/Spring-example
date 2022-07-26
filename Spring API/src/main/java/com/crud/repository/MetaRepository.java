package com.crud.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.model.Meta_Basic;

@Repository
public interface MetaRepository extends JpaRepository<Meta_Basic, String> {

	public Optional<Meta_Basic> findById(String identifier); 
	
	@Query(value="select b.creator_name from ds_metabasic b inner join ds_metadistribution d on b.ideintifier = d.identifier GROUP by b.creator",nativeQuery = true)
	List<Meta_Basic> filterlist_name();
	@Query(value="select b.metadata_type from ds_metabasic b inner join ds_metadistribution d on b.ideintifier = d.identifier GROUP by b.metadata_type",nativeQuery = true)
	List<Meta_Basic> filterlist_type();
	@Query(value="select b.theme from ds_metabasic b inner join ds_metadistribution d on b.ideintifier = d.identifier GROUP by b.theme",nativeQuery = true)
	List<Meta_Basic> filterlist_theme();
	
	
	@Query("select b.accessRights, b.contactPoint_name, b.contactPoint_mail, b.contactPoint_phone, b.creator_name, b.creator_mail, b.creator_phone, b.creator_homepage, b.description, b.title, b.issued, b.modified, b.`language`, b.publisher_name, b.publisher_mail, b.publisher_phone, b.publisher_homepage, b.identifier, b.theme, b.`type`, b.keyword, b.landingPage, b.license, b.rights, b.distribution, b.spatialResolutionInMeters, b.temporalResolution, b.accrualPeriodicity, b.`spatial`, b.temporal, b.metadata_type, d.`format`, b.image, b.endpointURL, b.endpointDescription from ds_meta_basic b inner join ds_meta_distribution d on b.identifier = d.identifier ")
	List<Meta_Basic> metadatalist();
	
	@Query("select b.accessRights, b.contactPoint_name, b.contactPoint_mail, b.contactPoint_phone, b.creator_name, b.creator_mail, b.creator_phone, b.creator_homepage, b.description, b.title, b.issued, b.modified, b.`language`, b.publisher_name, b.publisher_mail, b.publisher_phone, b.publisher_homepage, b.identifier, b.theme, b.`type`,  b.keyword, b.landingPage, b.license, b.rights, b.distribution, b.spatialResolutionInMeters, b.temporalResolution, b.accrualPeriodicity, b.`spatial`, b.temporal,   b.metadata_type, d.`format`, b.image, b.endpointURL, b.endpointDescription  from ds_meta_basic b  inner join ds_meta_distribution d on b.identifier = d.identifier where BINARY(b.identifier) = identifier ")
	List<Meta_Basic> latestlist();
//	// like검색도 가능
//	public List<Meta_Basic> findByNameLike(String keyword);
}
   	