package com.itemaddress.mapping.itemaddressmapping.dto;

import javax.validation.constraints.NotNull;

import com.itemaddress.mapping.itemaddressmapping.dataobject.Address;

import lombok.Data;
import lombok.Getter;

@Data
public class ItemDTO {

	private int itemId;

	@NotNull(message = "Enter the Item Name")
	private String itemName;

	@NotNull(message = "Enter the item Price")
	private int itemPrice;

	private AddressDTO addressDTO;

}
