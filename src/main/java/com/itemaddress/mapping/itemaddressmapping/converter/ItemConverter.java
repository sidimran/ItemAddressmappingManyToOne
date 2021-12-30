package com.itemaddress.mapping.itemaddressmapping.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.itemaddress.mapping.itemaddressmapping.dataobject.Address;
import com.itemaddress.mapping.itemaddressmapping.dataobject.Item;
import com.itemaddress.mapping.itemaddressmapping.dto.AddressDTO;
import com.itemaddress.mapping.itemaddressmapping.dto.ItemDTO;

@Component
public class ItemConverter {

	public ItemDTO entityToDto(Item items) {

		ItemDTO itemDto = new ItemDTO();

		itemDto.setItemId(items.getItemId());
		itemDto.setItemName(items.getItemName());
		itemDto.setItemPrice(items.getItemPrice());

		AddressDTO addressDTO = new AddressDTO();

		addressDTO.setAddressid(items.getAddress().getId());
		addressDTO.setAddressName(items.getAddress().getAddressName());
		itemDto.setAddressDTO(addressDTO);
		return itemDto;
	}

	public List<ItemDTO> entityToDto(List<Item> item) {
		return item.stream().map(this::entityToDto).collect(Collectors.toList());

	}

	public Item dtoToEntity(ItemDTO itemDto) {

		Item item = new Item();
		item.setItemName(itemDto.getItemName());
		item.setItemPrice(itemDto.getItemPrice());

		Address address = new Address();
		address.setAddressName(itemDto.getAddressDTO().getAddressName());
		item.setAddress(address);
		return item;

	}

	public List<Item> dtoToEntity(List<ItemDTO> dto) {
		return dto.stream().map(this::dtoToEntity).collect(Collectors.toList());
	}
}
