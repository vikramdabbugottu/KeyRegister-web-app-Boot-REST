package com.vikram.keyregister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vikram.keyregister.dao.KeysService;
import com.vikram.keyregister.model.KeysModel;

@RestController
public class KeysController {
	
	@Autowired
	private KeysService keyservice;
	
	@RequestMapping("/allkeys")
	public List<KeysModel> getallkeys()
	{
		return keyservice.getAllkeys();
		
	}
	
	@RequestMapping("/allkeys/{districtnumber}")
	public List<KeysModel> getallkeysbydistrictnumber(@PathVariable String districtnumber)
	{
		return keyservice.getAllkeysbydistrictnumber(districtnumber);
	}
	
	@RequestMapping("/allkeysadress/{adress}")
	public List<KeysModel> getallkeysbyadress(@PathVariable String adress)
	{
		return keyservice.getAllkeysbyadress(adress);
	}
	
	@RequestMapping("/allkeys/{keyowner}")
	public List<KeysModel> getallkeysbykeyowner(@PathVariable String keyowner)
	{
		return keyservice.getAllkeysbykeyowner(keyowner);
	}
	
	@RequestMapping("/key/{keynumber}")
	public KeysModel getkeybykeynumber(String keynumber)
	{
		return keyservice.getkeybykeynumber(keynumber);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/keys")
	public KeysModel addkeys(@RequestBody KeysModel keysmodel)
	{
		return keyservice.addkeys(keysmodel);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/keys/{id}")
	public KeysModel updatekeys(@RequestBody KeysModel keysmodel, @PathVariable int id)
	{
		return keyservice.updatekeys(id, keysmodel);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/keys/{keynumber}")
	public KeysModel deletekey(@PathVariable String keynumber)
	{
		return keyservice.deletekey(keynumber);
	}
	
	
}

