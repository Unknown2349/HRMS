package com.cg.hrms.asset.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.hrms.asset.model.Asset;

@Repository
public interface AssetRepository extends MongoRepository< Asset, String>{

	

}