package com.cg.hrms.asset.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hrms.asset.model.Asset;
import com.cg.hrms.asset.repository.AssetRepository;

@Service
public class AssetService implements AssetServiceInterface{
	
	@Autowired
	private AssetRepository assetRepository;
	
	
	@Override
	public Asset addAsset(Asset asset) {
		Asset savedAsset = assetRepository.save(asset);
		return savedAsset;
		
	}
	
	@Override
	public List<Asset> getAllAssets() {
		return assetRepository.findAll();
	}

	@Override
	public Asset getAssetById(String id) {
		return assetRepository.findById(id).get();
	}

	@Override
	public void deleteAssetById(String id) {
		assetRepository.deleteById(id);
	}

	@Override
	public Asset updateAsset(String id, Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	

//	@Override
//	public Asset updateAsset(String id, Asset asset) {
//		return assetRepository.addAsset();
//		
//	}



	

}