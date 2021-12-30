package com.itemaddress.mapping.itemaddressmapping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itemaddress.mapping.itemaddressmapping.dto.ItemDTO;
import com.itemaddress.mapping.itemaddressmapping.dto.ResultDTO;
import com.itemaddress.mapping.itemaddressmapping.exception.ItemNotFoundException;
import com.itemaddress.mapping.itemaddressmapping.service.ItemService;

@RestController
@RequestMapping(value = "/item")
@CrossOrigin(origins="*")
public class ItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping(value = "/saveData", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResultDTO saveItemData(@Valid @RequestBody ItemDTO itemdto) throws ItemNotFoundException {
		return itemService.saveItemData(itemdto);
	}

	@RequestMapping(value = "/getItemsByAddressId/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResultDTO getItemsByAddressId(@PathVariable("id") int id) {
		return itemService.getItemDataByAddressId(id);
	}

	@RequestMapping(value = "/getNotMappedItemDataFromAddressId/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResultDTO getNotMappedItemDataWithPassedAddressID(@PathVariable(value = "id") int id) {
		return itemService.getNotMappedItemDataWithPassedAddressID(id);
	}

	@RequestMapping(value = "/setAddressIdToNullOnItemId/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResultDTO setAddressIdToNullOnItemId(@PathVariable(value = "id") int id) {
		return itemService.setaddressidToNullOnItemId(id);
	}

	@RequestMapping(value = "/getAddressDataByItemId/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResultDTO getItemDataByItemId(@PathVariable(value = "id") int id) {
		return itemService.getAddressDataByItemId(id);
	}

	@RequestMapping(value = "/deleteAddressdataByItemId", method = RequestMethod.DELETE)
	public ResultDTO deleteAddressdataByItemId(@RequestParam(value = "id") int itemId) {
		return itemService.deleteAddressdataByItemId(itemId);
	}

	@RequestMapping(value = "/getByItemFirstname", method = RequestMethod.GET)
	public ResultDTO getByItemFirstname(@RequestParam(value ="itemName") String itemName) {
		return itemService.getByItemFirstname(itemName);
	}
	@RequestMapping(value = "/getAllItem", method = RequestMethod.GET)
	public ResultDTO getAllItems(){
		return itemService.getAllItems();
	}
}
