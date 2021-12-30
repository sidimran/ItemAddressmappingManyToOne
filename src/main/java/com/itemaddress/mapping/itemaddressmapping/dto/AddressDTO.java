package com.itemaddress.mapping.itemaddressmapping.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.itemaddress.mapping.itemaddressmapping.dataobject.Item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class AddressDTO {

	private int addressid;

	@NotNull(message = "Enter the Address Name")
	private String addressName;
	
	private List<Item> item;

}
