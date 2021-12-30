package com.itemaddress.mapping.itemaddressmapping.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.itemaddress.mapping.itemaddressmapping.dataobject.Address;
import com.itemaddress.mapping.itemaddressmapping.dto.AddressDTO;
import com.itemaddress.mapping.itemaddressmapping.dto.ItemDTO;

@Component
public class AddressConverter {

	public AddressDTO entityToDto(Address address) {

		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddressid(address.getId());
		addressDTO.setAddressName(address.getAddressName());

		return addressDTO;

	}

	public List<AddressDTO> entityToDto(List<Address> address) {
		return address.stream().map(this::entityToDto).collect(Collectors.toList());
	}

	public Address dtoToEntity(AddressDTO addressDTO) {

		Address address = new Address();
		address.setAddressName(addressDTO.getAddressName());

		return address;

	}

	public List<Address> DtoToEntity(List<AddressDTO> addressDTO) {

		return addressDTO.stream().map(this::dtoToEntity).collect(Collectors.toList());
	}

}
