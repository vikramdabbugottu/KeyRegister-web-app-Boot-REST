package com.vikram.keyregister.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vikram.keyregister.model.KeysModel;

public interface KeysRepository extends CrudRepository<KeysModel, String> {

	List<KeysModel> findAllBydistrictNumber(String districtnumber);
	List<KeysModel> findAllByadress(String adress);
	List<KeysModel> findAllBykeyowner(String keyowner);
	//public void  findBykeynumber(String keynumber);
	KeysModel findBykeynumber(String keynumber);
	KeysModel deleteBykeynumber(String keynumber);

	//get all the data from the keyregister table
		//get a keys from the table
		//update a key
		//create a new key
		//delete a key
		//*******//
		//** The spring Data Jpa have already created a CRUD frame work. The spring data JPA has a 
		//class. so we need an interface which extends an CRUDreposatory
}
