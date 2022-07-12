package com.cg.hrms.asset.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hrms.asset.model.Asset;
import com.cg.hrms.asset.service.AssetServiceInterface;


@RestController
@RequestMapping("/asset")
public class AssetController {
	

	

	

	@Autowired
	private AssetServiceInterface assetServiceInterface;
	

//	@Autowired
//	private SequenceGeneratorService service;
	
	
	@PostMapping("/create")
	public ResponseEntity<Asset> addAsset(@RequestBody Asset asset){
		Asset assetSaved = assetServiceInterface.addAsset(asset);
		return new ResponseEntity<Asset>(assetSaved, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<List<Asset>> getAllAssets(){
		
		List<Asset> listOfAllAsts = assetServiceInterface.getAllAssets();
		return new ResponseEntity<List<Asset>>(listOfAllAsts, HttpStatus.OK);
	}
	
	
//
//    if (listOfAllEmps.is Present()) {
//      return new ResponseEntity<>(listOfAllEmps.get(), HttpStatus.OK);
//    } else {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//  }
//	@GetMapping("/get/{id}")
//	  public ResponseEntity<Asset> getAssetById(@PathVariable("id") String id){
//		ResponseEntity<Asset> a=assetclient.getAssetById(id);
//		return a;
//	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Asset> getAssetById(@PathVariable("id") String id){
		
		Asset assetRetrieved = assetServiceInterface.getAssetById(id);
		return new ResponseEntity<Asset>(assetRetrieved, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteAssetById(@PathVariable("id") String id){
		
		assetServiceInterface.deleteAssetById(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Asset> updateEmployee(@PathVariable("id") String id,@RequestBody Asset asset){
		Asset assetSaved = assetServiceInterface.addAsset(asset);
		return new ResponseEntity<Asset>(assetSaved, HttpStatus.CREATED);
	}
}





















//@RestController
//@RequestMapping("/asset")
//public class AssetController {
//	
//	@Autowired
//	public AssetRepository assetRepository;
//	
//	@GetMapping(value= "/get")
//	public List<Asset> getAllAssets(){
//		
//		return assetRepository.findAll();
//		
//	}
//	
//	
//	
//	@PostMapping(value = "/create")
//	public String createAsset(@RequestBody Asset asset) {
//		
//		Asset insertedAsset = assetRepository.insert(asset);
//		
//		return "Asset created"+ insertedAsset.getAssetName();
//	}
//	
//	@PutMapping("/update")
//	  public Asset updateAsset(@RequestBody Asset asset) {
//		
//		assetRepository.save(asset);
//		return asset;
//	  }
//	
//	
//	 
//	@DeleteMapping("/delete/{id}")
//	public void deleteAsset(@PathVariable Asset id){
//	assetRepository.delete(id);
//	
//    }
//	
//	
//	@GetMapping("/get/{id}")
//	  public ResponseEntity<Asset> getAssetById(@PathVariable("id") String id) {
//	    Optional<Asset> assetData = assetRepository.findById(id);
//
//	    if (assetData.isPresent()) {
//	      return new ResponseEntity<>(assetData.get(), HttpStatus.OK);
//	    } else {
//	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	  }
//	
//	@PutMapping("/update/{id}")
//	  public ResponseEntity<Asset> updateEmployee(@PathVariable("id") String id, @RequestBody Asset asset) {
//	    Optional<Asset> assetData = assetRepository.findById(id);
//
//	    if (assetData.isPresent()) {
//	      Asset _asset = assetData.get();
//	      _asset.setAssetName(asset.getAssetName());
//	      _asset.setAssetModelNo(asset.getAssetModelNo());
//	      _asset.setAssetType(asset.getAssetType());
//	      return new ResponseEntity<>(assetRepository.save(_asset), HttpStatus.OK);
//	    } else {
//	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	  }
//	
//}