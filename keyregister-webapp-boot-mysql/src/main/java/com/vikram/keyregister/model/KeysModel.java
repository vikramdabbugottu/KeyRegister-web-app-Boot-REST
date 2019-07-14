package com.vikram.keyregister.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class KeysModel {
	

	public KeysModel() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private Date date;
	private String districtNumber;
	private String adress;
	private String keyname;
	private String keynumber;
	private String keyinfo;
	private String keyowner;
	private String ownerinfo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDistrictNumber() {
		return districtNumber;
	}
	public void setDistrictNumber(String districtNumber) {
		this.districtNumber = districtNumber;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getKeyname() {
		return keyname;
	}
	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}
	public String getKeynumber() {
		return keynumber;
	}
	public void setKeynumber(String keynumber) {
		this.keynumber = keynumber;
	}
	public String getKeyinfo() {
		return keyinfo;
	}
	public void setKeyinfo(String keyinfo) {
		this.keyinfo = keyinfo;
	}
	public String getKeyowner() {
		return keyowner;
	}
	public void setKeyowner(String keyowner) {
		this.keyowner = keyowner;
	}
	public String getOwnerinfo() {
		return ownerinfo;
	}
	public void setOwnerinfo(String ownerinfo) {
		this.ownerinfo = ownerinfo;
	}
	
	
}
