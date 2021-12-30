package com.itemaddress.mapping.itemaddressmapping.service;

import java.util.List;

import com.itemaddress.mapping.itemaddressmapping.dataobject.Item;
import com.itemaddress.mapping.itemaddressmapping.dto.ItemDTO;
import com.itemaddress.mapping.itemaddressmapping.dto.ResultDTO;
import com.itemaddress.mapping.itemaddressmapping.exception.ItemNotFoundException;

public interface ItemService {

	public ResultDTO saveItemData(ItemDTO itemdto) throws ItemNotFoundException;

	public ResultDTO getItemDataByAddressId(int id);

	public ResultDTO getNotMappedItemDataWithPassedAddressID(int id);

	public ResultDTO setaddressidToNullOnItemId(int id);

	public ResultDTO getAddressDataByItemId(int id);

	public ResultDTO deleteAddressdataByItemId(int itemId);
	
	public ResultDTO getByItemFirstname(String itemName);
	
	public ResultDTO getAllItems();

}
