package com.itemaddress.mapping.itemaddressmapping.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itemaddress.mapping.itemaddressmapping.converter.AddressConverter;
import com.itemaddress.mapping.itemaddressmapping.converter.ItemConverter;
import com.itemaddress.mapping.itemaddressmapping.dataobject.Address;
import com.itemaddress.mapping.itemaddressmapping.dataobject.Item;
import com.itemaddress.mapping.itemaddressmapping.dto.ItemDTO;
import com.itemaddress.mapping.itemaddressmapping.dto.ResultDTO;
import com.itemaddress.mapping.itemaddressmapping.exception.ItemNotFoundException;
import com.itemaddress.mapping.itemaddressmapping.repository.AddressRepository;
import com.itemaddress.mapping.itemaddressmapping.repository.ItemRepository;
import com.itemaddress.mapping.itemaddressmapping.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	ItemConverter itemconverter;

	@Autowired
	AddressConverter addressConverter;

	@Autowired
	AddressRepository addressRepository;

	@Override
	public ResultDTO saveItemData(ItemDTO itemdto) throws ItemNotFoundException {

		ResultDTO dto = new ResultDTO();
		Item item2 = itemconverter.dtoToEntity(itemdto);
		itemRepository.save(item2);
		dto.setMessage("Saved Successfully");
		dto.setData(item2);

		return dto;
	}

	@Override
	public ResultDTO getItemDataByAddressId(int id) {

		ResultDTO dto = new ResultDTO();
		List<Item> listItem = itemRepository.getItemByAddressId(id);

		List<ItemDTO> listItemDTO = new ArrayList<>();
		for (Item item : listItem) {

			listItemDTO.add(itemconverter.entityToDto(item));
		}
		dto.setListData(listItemDTO);
		dto.setMessage("Item data by AddressID");
		return dto;
	}

	@Override
	public ResultDTO getNotMappedItemDataWithPassedAddressID(int id) {

		ResultDTO dto = new ResultDTO<>();
		List<Item> listItem = itemRepository.getNotMappedItemDataWithPassedAddressID(id);

		List<ItemDTO> listItemDTO = new ArrayList<>();
		for (Item item : listItem) {

			listItemDTO.add(itemconverter.entityToDto(item));
		}
		dto.setMessage("Item data Not Mapped with Given Address ID");
		dto.setListData(listItemDTO);

		return dto;
	}

	@Override
	public ResultDTO setaddressidToNullOnItemId(int id) {
		ResultDTO resultDto = new ResultDTO<>();

		Item itemId = itemRepository.getById(id);
		int passItemId = itemRepository.setaddressidToNullOnItemId(itemId.getItemId());
		resultDto.setMessage("address column set to null");
		resultDto.setData(passItemId);

		return null;
	}

	@Override
	public ResultDTO getAddressDataByItemId(int id) {

		ResultDTO resultDTO = new ResultDTO<>();
		List<Item> listItem = itemRepository.getAddressDataByItemId(id);

		List<ItemDTO> listItemDTO = new ArrayList<>();
		for (Item item : listItem) {
			listItemDTO.add(itemconverter.entityToDto(item));

		}
		resultDTO.setMessage("fetched data");
		resultDTO.setListData(listItemDTO);

		return resultDTO;
	}

	@Override
	public ResultDTO deleteAddressdataByItemId(int itemId) {
		ResultDTO resultDTO = new ResultDTO<>();
		Address address = addressRepository.getById(itemId);
		Item item = new Item();

		itemRepository.deleteByAddress(address);
		resultDTO.setMessage("deleted succesfully");

		return resultDTO;
	}

	@JsonIgnore
	@Override
	public ResultDTO getByItemFirstname(String itemName) {
		ResultDTO resultDTO = new ResultDTO<>();
		List<Item> listItemName = itemRepository.getByItemName(itemName);

		List<ItemDTO> itemDTO = new ArrayList<>();

		for (Item item : listItemName) {
			itemDTO.add(itemconverter.entityToDto(item));
		}
		resultDTO.setMessage("fetched data");
		resultDTO.setListData(itemDTO);

		return resultDTO;
	}

	@JsonIgnore
	@Override
	public ResultDTO getAllItems() {

		ResultDTO resultDTO = new ResultDTO<>();
		List<Item> listItem = itemRepository.findAll();
		resultDTO.setData(listItem);
		resultDTO.setListData(listItem);

		return resultDTO;
	}

}
