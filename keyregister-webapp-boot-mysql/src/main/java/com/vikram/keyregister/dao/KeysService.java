package com.vikram.keyregister.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikram.keyregister.model.KeysModel;
@Service
public class KeysService {
	
	@Autowired
	private KeysRepository keysrepository;
	
	//Get all keys from the database. This method not use in the real allpication
	public List<KeysModel> getAllkeys()
	{
		List<KeysModel> keysmodel=new ArrayList<>();
		keysrepository.findAll().forEach(keysmodel::add);
		return keysmodel;
	}
	
	//Gets all the keys that belongs to a particular district based on the district number
	public List<KeysModel> getAllkeysbydistrictnumber(String districtnumber)
	{
		List<KeysModel> keysmodel=new ArrayList<>();
		keysrepository.findAllBydistrictNumber(districtnumber).forEach(keysmodel::add);
		return keysmodel;
	}
	
	//Gets all the keys base on the addresses There are Sunday district and weekdays districts. There are keys and also codes for the same 
	//address. So This method will get all the keys that are in the DB for particular address
	public List<KeysModel> getAllkeysbyadress(String adress)
	{
		List<KeysModel> keysmodel=new ArrayList<>();
		keysrepository.findAllByadress(adress).forEach(keysmodel::add);
		return keysmodel;
	}
	
	//Gets all keys based on the key owners ex. Hsb, Stangåstaden, Willhem
	public List<KeysModel> getAllkeysbykeyowner(String keyowner)
	{
		List<KeysModel> keysmodel=new ArrayList<>();
		keysrepository.findAllBykeyowner(keyowner).forEach(keysmodel::add);
		return keysmodel;
	}
	
	//Get key by Keynumber. This key number is unique.
	
	public KeysModel getkeybykeynumber(String keynumber)
	{
		return keysrepository.findBykeynumber(keynumber);
	}
	//Add new keys in to the table
	public KeysModel addkeys(KeysModel keysmodel)
	{
		keysrepository.save(keysmodel);
		return null;
	}
	//update the keys based on the id
	public KeysModel updatekeys(int id, KeysModel keysmodel)
	{
		keysrepository.save(keysmodel);
		return null;
	}
	
	//delete the key based on Key number
	public KeysModel deletekey(String keynumber)
	
	{
		keysrepository.deleteBykeynumber(keynumber);
		return null;
	}

}
