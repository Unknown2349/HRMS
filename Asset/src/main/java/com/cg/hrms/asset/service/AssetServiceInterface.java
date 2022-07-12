package com.cg.hrms.asset.service;

import java.util.List;

import com.cg.hrms.asset.model.Asset;

public interface AssetServiceInterface {



	public Asset addAsset(Asset asset);

	public List<Asset> getAllAssets();

	public Asset getAssetById(String id);

	public void deleteAssetById(String id);
	
	public Asset updateAsset(String id, Asset asset);

}