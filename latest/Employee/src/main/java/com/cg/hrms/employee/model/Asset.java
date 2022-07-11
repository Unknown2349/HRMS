package com.cg.hrms.employee.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ass")
public class Asset {
	
	@Id
	
    private String assetid;
    public String getassetId() {
		return assetid;
	}
	public void setId(String assetid) {
		this.assetid = assetid;
	}
	private String assetName;
	private String assetModelNo;
	private String assetType;
	
	public Asset() {
		super();
		
	}
	public Asset(String assetName, String assetModelNo, String assetType) {
		super();
		this.setAssetName(assetName);
		this.setAssetModelNo(assetModelNo);
		this.setAssetType(assetType);
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getAssetModelNo() {
		return assetModelNo;
	}
	public void setAssetModelNo(String assetModelNo) {
		this.assetModelNo = assetModelNo;
	}
	
	
	
	

}
